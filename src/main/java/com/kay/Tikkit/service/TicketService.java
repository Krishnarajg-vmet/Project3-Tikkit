package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kay.Tikkit.config.SecurityUtil;
import com.kay.Tikkit.dto.PaginatedTicketListDto;
import com.kay.Tikkit.dto.TicketCreateDto;
import com.kay.Tikkit.dto.TicketListDto;
import com.kay.Tikkit.dto.TicketResponseDto;
import com.kay.Tikkit.dto.TicketUpdateDto;
import com.kay.Tikkit.entity.Complaint;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;
import com.kay.Tikkit.mapper.TicketMapper;
import com.kay.Tikkit.repositories.ComplaintRepository;
import com.kay.Tikkit.repositories.DepartmentRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.repositories.UserRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ComplaintRepository complaintRepository;
    private final TicketHistoryService ticketHistoryService;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final SecurityUtil securityUtil;

    public TicketService(TicketRepository ticketRepository,
                         ComplaintRepository complaintRepository,
                         TicketHistoryService ticketHistoryService,
                         UserRepository userRepository,
                         DepartmentRepository departmentRepository,
                         SecurityUtil securityUtil) {
        this.ticketRepository = ticketRepository;
        this.complaintRepository = complaintRepository;
        this.ticketHistoryService = ticketHistoryService;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.securityUtil = securityUtil;
    }

    @Transactional
    public String generateTicketNumber(Long toDepartmentId) {
        Department department = departmentRepository.findById(toDepartmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        String departmentCode = department.getDepartmentCode();
        long serialNumber = ticketRepository.countByToDepartmentDepartmentId(department.getDepartmentId()) + 1;

        return "TKT-" + departmentCode + String.format("%05d", serialNumber);
    }

    @Transactional
    public TicketResponseDto createTicket(TicketCreateDto dto) {
    	User createdBy = securityUtil.getCurrentUser();
        Ticket ticket = new Ticket();
        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setTicketType(dto.getTicketType());
        ticket.setTicketPriority(dto.getTicketPriority());
        ticket.setTicketStatus(TicketStatus.NEW);
        ticket.setProduct(dto.getProduct());
        ticket.setTicketNumber(generateTicketNumber(dto.getToDepartmentId()));
        ticket.setIsActive(true);
        ticket.setCreatedBy(createdBy);
        ticket.setCreatedDt(LocalDateTime.now());

        if (dto.getComplaintId() != null) {
            Complaint complaint = complaintRepository.findById(dto.getComplaintId())
                    .orElseThrow(() -> new RuntimeException("Complaint not found"));
            ticket.setComplaint(complaint);
        }

        Department fromDept = departmentRepository.findById(dto.getFromDepartmentId())
                .orElseThrow(() -> new RuntimeException("From Department not found"));
        Department toDept = departmentRepository.findById(dto.getToDepartmentId())
                .orElseThrow(() -> new RuntimeException("To Department not found"));

        ticket.setFromDepartment(fromDept);
        ticket.setToDepartment(toDept);

        ticketRepository.save(ticket);
        ticketHistoryService.logHistory(ticket, "CREATE", null, createdBy, "Ticket created");

        return TicketMapper.toResponseDto(ticket); // mapping inside transaction
    }

    @Transactional
    public TicketResponseDto modifyTicket(Long ticketId, TicketUpdateDto dto) {
    	User modifiedBy = securityUtil.getCurrentUser();
        Ticket ticket = getTicket(ticketId);

        if (ticket.getAssignedTo() != null && ticket.getTicketStatus().equals(TicketStatus.OPEN))
            throw new RuntimeException("Cannot modify ticket after assignment");

        Ticket oldTicket = cloneTicket(ticket);

        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setTicketType(dto.getTicketType());
        ticket.setTicketPriority(dto.getTicketPriority());

        if (dto.getComplaintId() != null) {
            Complaint complaint = complaintRepository.findById(dto.getComplaintId())
                    .orElseThrow(() -> new RuntimeException("Complaint not found"));
            ticket.setComplaint(complaint);
        }

        Department fromDept = departmentRepository.findById(dto.getFromDepartmentId())
                .orElseThrow(() -> new RuntimeException("From Department not found"));
        Department toDept = departmentRepository.findById(dto.getToDepartmentId())
                .orElseThrow(() -> new RuntimeException("To Department not found"));

        ticket.setFromDepartment(fromDept);
        ticket.setToDepartment(toDept);

        ticket.setModifiedBy(modifiedBy);
        ticket.setModifiedDt(LocalDateTime.now());

        ticketRepository.save(ticket);
        ticketHistoryService.logHistory(ticket, "MODIFY", oldTicket, modifiedBy, "Ticket modified");

        return TicketMapper.toResponseDto(ticket);
    }

    @Transactional
    private Ticket changeTicketStatus(Ticket ticket, TicketStatus status, String action, String comment) {
    	User user = securityUtil.getCurrentUser();
        Ticket oldTicket = cloneTicket(ticket);

        switch (status) {
            case OPEN -> {ticket.setAssignedDt(LocalDateTime.now()); ticket.setAssignedBy(user);}
            case IN_PROGRESS -> {ticket.setModifiedDt(LocalDateTime.now()); ticket.setModifiedBy(user);}
            case RESOLVED -> {ticket.setResolvedDt(LocalDateTime.now());ticket.setResolvedBy(user); }
            case CLOSED -> {ticket.setClosedDt(LocalDateTime.now());ticket.setClosedBy(user);}
            case RE_OPEN -> {ticket.setReopenedDt(LocalDateTime.now());ticket.setReopenedBy(user);}
            default -> {}
        }

        ticket.setTicketStatus(status);
        ticket.setModifiedBy(user);
        ticket.setModifiedDt(LocalDateTime.now());
        ticketRepository.save(ticket);

        ticketHistoryService.logHistory(ticket, action, oldTicket, user, comment);
        return ticket;
    }

    @Transactional
    public TicketResponseDto assignTicket(Long ticketId, Long userId) {
        Ticket ticket = getTicket(ticketId);
        User assignedTo = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        ticket.setAssignedTo(assignedTo);
        Ticket updatedTicket = changeTicketStatus(ticket, TicketStatus.OPEN, "ASSIGN",
                "Assigned to " + assignedTo.getUserName());
        return TicketMapper.toResponseDto(updatedTicket);
    }

    @Transactional
    public TicketResponseDto inProgressTicket(Long ticketId) {
        Ticket ticket = getTicket(ticketId);
        Ticket updatedTicket = changeTicketStatus(ticket, TicketStatus.IN_PROGRESS, "INPROGRESS",
                "Ticket moved to INPROGRESS");
        return TicketMapper.toResponseDto(updatedTicket);
    }

    @Transactional
    public TicketResponseDto resolveTicket(Long ticketId) {
        Ticket ticket = getTicket(ticketId);
        Ticket updatedTicket = changeTicketStatus(ticket, TicketStatus.RESOLVED, "RESOLVE", "Ticket resolved");
        return TicketMapper.toResponseDto(updatedTicket);
    }

    @Transactional
    public TicketResponseDto closeTicket(Long ticketId) {
        Ticket ticket = getTicket(ticketId);
        Ticket updatedTicket = changeTicketStatus(ticket, TicketStatus.CLOSED, "CLOSE", "Ticket closed");
        return TicketMapper.toResponseDto(updatedTicket);
    }

    @Transactional
    public TicketResponseDto reopenTicket(Long ticketId) {
        Ticket ticket = getTicket(ticketId);
        Ticket updatedTicket = changeTicketStatus(ticket, TicketStatus.RE_OPEN, "REOPEN", "Ticket reopened");
        return TicketMapper.toResponseDto(updatedTicket);
    }

    @Transactional(readOnly = true)
    public TicketResponseDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findByTicketIdWithHistoryAndComments(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found: " + ticketId));
        return TicketMapper.toResponseDto(ticket);
    }

    @Transactional(readOnly = true)
    public List<TicketListDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(TicketMapper::toListDto).toList();
    }

    private Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found: " + ticketId));
    }

    private Ticket cloneTicket(Ticket t) {
        Ticket clone = new Ticket();
        clone.setTicketStatus(t.getTicketStatus());
        clone.setTicketType(t.getTicketType());
        clone.setTicketPriority(t.getTicketPriority());
        clone.setAssignedTo(t.getAssignedTo());
        clone.setComplaint(t.getComplaint());
        clone.setFromDepartment(t.getFromDepartment());
        clone.setToDepartment(t.getToDepartment());
        return clone;
    }

    @Transactional(readOnly = true)
    public PaginatedTicketListDto getTicketsPaginatedWithFilters(
            TicketStatus ticketStatus,
            TicketType ticketType,
            TicketPriority ticketPriority,
            int page,
            int size) {

        Specification<Ticket> specification = Specification.where(null);

        if (ticketStatus != null)
            specification = specification.and((root, query, cb) -> cb.equal(root.get("ticketStatus"), ticketStatus));

        if (ticketType != null)
            specification = specification.and((root, query, cb) -> cb.equal(root.get("ticketType"), ticketType));

        if (ticketPriority != null)
            specification = specification.and((root, query, cb) -> cb.equal(root.get("ticketPriority"), ticketPriority));

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDt").descending());
        Page<Ticket> ticketsPage = ticketRepository.findAll(specification, pageable);

        return TicketMapper.toPaginatedDto(ticketsPage);
    }
}
