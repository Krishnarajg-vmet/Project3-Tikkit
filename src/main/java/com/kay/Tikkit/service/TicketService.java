package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.TicketDto;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.mapper.TicketMapper;
import com.kay.Tikkit.repositories.*;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketHistoryService ticketHistoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AttachmentService attachmentService;

    public TicketDto createTicket(TicketDto dto) {
        Department raisedTo = departmentRepository.findById(dto.getRaisedToDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("RaisedTo Department not found"));

        Department raisedBy = departmentRepository.findById(dto.getRaisedByDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("RaisedBy Department not found"));

        User createdBy = userRepository.findById(dto.getCreatedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("CreatedBy User not found"));

        Ticket parentTicket = null;
        if (dto.getParentTicketId() != null) {
            parentTicket = ticketRepository.findById(dto.getParentTicketId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent Ticket not found"));
        }

        Ticket ticket = TicketMapper.toEntity(dto, raisedTo, raisedBy, createdBy, null, null, parentTicket);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setTicketStatus(TicketStatus.OPEN);

        Ticket savedTicket = ticketRepository.save(ticket);

        ticketHistoryService.addTicketHistory(savedTicket.getTicketId(), "Status", null, TicketStatus.OPEN.name(), dto.getCreatedByUserId());

        return TicketMapper.toDto(savedTicket);
    }

    public TicketDto updateTicket(Long ticketId, TicketDto dto) {
        Ticket existing = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        User modifiedBy = userRepository.findById(dto.getModifiedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("ModifiedBy User not found"));

        String oldStatus = existing.getTicketStatus().name();

        existing.setTicketTitle(dto.getTicketTitle());
        existing.setDescription(dto.getDescription());
        existing.setTicketStatus(dto.getTicketStatus());
        existing.setTicketPriority(dto.getTicketPriority());
        existing.setTicketType(dto.getTicketType());
        existing.setUpdatedAt(LocalDateTime.now());
        existing.setModifiedBy(modifiedBy);

        Ticket updated = ticketRepository.save(existing);

        if (!oldStatus.equals(dto.getTicketStatus().name())) {
            ticketHistoryService.addTicketHistory(ticketId, "Status", oldStatus, dto.getTicketStatus().name(), dto.getModifiedByUserId());
        }

        return TicketMapper.toDto(updated);
    }

    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        return TicketMapper.toDto(ticket);
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
