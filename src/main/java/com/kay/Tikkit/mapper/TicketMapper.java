package com.kay.Tikkit.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.Complaint;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.User;

public class TicketMapper {


    public static Ticket toEntity(TicketCreateDto dto) {
        if (dto == null) return null;

        Ticket ticket = new Ticket();
        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setTicketType(dto.getTicketType());
        ticket.setTicketStatus(dto.getTicketStatus());
        ticket.setTicketPriority(dto.getTicketPriority());
        ticket.setProduct(dto.getProduct());

        if (dto.getComplaintId() != null) {
            Complaint complaint = new Complaint();
            complaint.setComplaintId(dto.getComplaintId());
            ticket.setComplaint(complaint);
        }

        if (dto.getFromDepartmentId() != null) {
            Department dept = new Department();
            dept.setDepartmentId(dto.getFromDepartmentId());
            ticket.setFromDepartment(dept);
        }

        if (dto.getToDepartmentId() != null) {
            Department dept = new Department();
            dept.setDepartmentId(dto.getToDepartmentId());
            ticket.setToDepartment(dept);
        }

        if (dto.getCreatedById() != null) {
            User user = new User();
            user.setUserId(dto.getCreatedById());
            ticket.setCreatedBy(user);
        }

        return ticket;
    }

    public static void updateEntity(Ticket ticket, TicketUpdateDto dto) {
        if (ticket == null || dto == null) return;

        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setTicketType(dto.getTicketType());
        ticket.setTicketPriority(dto.getTicketPriority());
        ticket.setProduct(dto.getProduct());

        if (dto.getComplaintId() != null) {
            Complaint complaint = new Complaint();
            complaint.setComplaintId(dto.getComplaintId());
            ticket.setComplaint(complaint);
        }

        if (dto.getFromDepartmentId() != null) {
            Department dept = new Department();
            dept.setDepartmentId(dto.getFromDepartmentId());
            ticket.setFromDepartment(dept);
        }

        if (dto.getToDepartmentId() != null) {
            Department dept = new Department();
            dept.setDepartmentId(dto.getToDepartmentId());
            ticket.setToDepartment(dept);
        }

        if (dto.getModifiedById() != null) {
            User user = new User();
            user.setUserId(dto.getModifiedById());
            ticket.setModifiedBy(user);
        }
    }

    public static TicketListDto toListDto(Ticket ticket) {
        if (ticket == null) return null;

        TicketListDto dto = new TicketListDto();
        dto.setTicketId(ticket.getTicketId());
        dto.setTicketNumber(ticket.getTicketNumber());
        dto.setTicketTitle(ticket.getTicketTitle());
        dto.setTicketType(ticket.getTicketType());
        dto.setTicketPriority(ticket.getTicketPriority());
        dto.setTicketStatus(ticket.getTicketStatus());
        dto.setProduct(ticket.getProduct());

        if (ticket.getComplaint() != null)
            dto.setComplaintName(ticket.getComplaint().getComplaintName());

        if (ticket.getFromDepartment() != null)
            dto.setFromDepartmentName(ticket.getFromDepartment().getDepartmentName());

        if (ticket.getCreatedBy() != null)
            dto.setCreatedByName(ticket.getCreatedBy().getUserName());

        if (ticket.getAssignedTo() != null)
            dto.setAssignedToName(ticket.getAssignedTo().getUserName());

        if (ticket.getModifiedBy() != null)
            dto.setModifiedByName(ticket.getModifiedBy().getUserName());

        dto.setCreatedDt(ticket.getCreatedDt());
        dto.setAssignedDt(ticket.getAssignedDt());
        dto.setModifiedDt(ticket.getModifiedDt());

        return dto;
    }

    public static TicketResponseDto toResponseDto(Ticket ticket) {
        if (ticket == null) return null;

        TicketResponseDto dto = new TicketResponseDto();

        dto.setTicketId(ticket.getTicketId());
        dto.setTicketTitle(ticket.getTicketTitle());
        dto.setTicketNumber(ticket.getTicketNumber());
        dto.setDescription(ticket.getDescription());

        dto.setTicketType(ticket.getTicketType());
        dto.setTicketPriority(ticket.getTicketPriority());
        dto.setTicketStatus(ticket.getTicketStatus());
        dto.setProduct(ticket.getProduct());

        if (ticket.getComplaint() != null) {
            dto.setComplaintId(ticket.getComplaint().getComplaintId());
            dto.setComplaintName(ticket.getComplaint().getComplaintName());
        }

        if (ticket.getFromDepartment() != null) {
            dto.setFromDepartmentId(ticket.getFromDepartment().getDepartmentId());
            dto.setFromDepartmentName(ticket.getFromDepartment().getDepartmentName());
        }

        if (ticket.getToDepartment() != null) {
            dto.setToDepartmentId(ticket.getToDepartment().getDepartmentId());
            dto.setToDepartmentName(ticket.getToDepartment().getDepartmentName());
        }

        if (ticket.getCreatedBy() != null) {
            dto.setCreatedById(ticket.getCreatedBy().getUserId());
            dto.setCreatedByName(ticket.getCreatedBy().getUserName());
        }

        if (ticket.getModifiedBy() != null) {
            dto.setModifiedById(ticket.getModifiedBy().getUserId());
            dto.setModifiedByName(ticket.getModifiedBy().getUserName());
        }

        if (ticket.getAssignedTo() != null) {
            dto.setAssignedToId(ticket.getAssignedTo().getUserId());
            dto.setAssignedToName(ticket.getAssignedTo().getUserName());
        }

        if (ticket.getResolvedBy() != null) {
            dto.setResolvedById(ticket.getResolvedBy().getUserId());
            dto.setResolvedByName(ticket.getResolvedBy().getUserName());
        }

        if (ticket.getClosedBy() != null) {
            dto.setClosedById(ticket.getClosedBy().getUserId());
            dto.setClosedByName(ticket.getClosedBy().getUserName());
        }

        if (ticket.getReopenedBy() != null) {
            dto.setReopenedById(ticket.getReopenedBy().getUserId());
            dto.setReopenedByName(ticket.getReopenedBy().getUserName());
        }

        dto.setCreatedDt(ticket.getCreatedDt());
        dto.setModifiedDt(ticket.getModifiedDt());
        dto.setAssignedDt(ticket.getAssignedDt());
        dto.setResolvedDt(ticket.getResolvedDt());
        dto.setClosedDt(ticket.getClosedDt());
        dto.setReopenedDt(ticket.getReopenedDt());

        // Check for null comments and map accordingly
        if (ticket.getTicketHistory() != null) {
            dto.setHistory(
                ticket.getTicketHistory()
                    .stream()
                    .map(TicketHistoryMapper::toDto)
                    .collect(Collectors.toList())
            );
        }

        if (ticket.getComments() != null) {
            dto.setComments(
                ticket.getComments()
                    .stream()
                    .map(CommentMapper::toDto)
                    .collect(Collectors.toList())
            );
        } else {
            dto.setComments(Collections.emptyList());
        }

        return dto;
    }
   
        public static PaginatedTicketListDto toPaginatedDto(Page<Ticket> ticketPage) {
            if (ticketPage == null) return null;

            List<TicketListDto> ticketDtos = ticketPage.getContent().stream()
                    .map(TicketMapper::toListDto)
                    .collect(Collectors.toList());

            return new PaginatedTicketListDto(
                    ticketDtos, 
                    ticketPage.getNumber(),
                    ticketPage.getSize(),
                    ticketPage.getTotalElements(),
                    ticketPage.getTotalPages(), 
                    ticketPage.isFirst(), 
                    ticketPage.isLast(),
                    ticketPage.hasNext(),
                    ticketPage.hasPrevious()
            );
        }

}
