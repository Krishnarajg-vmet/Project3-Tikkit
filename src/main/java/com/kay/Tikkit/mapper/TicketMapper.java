package com.kay.Tikkit.mapper;

import java.util.stream.Collectors;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.*;

public class TicketMapper {

    public static TicketDto toDto(Ticket ticket) {
        if (ticket == null) return null;

        TicketDto dto = new TicketDto();

        dto.setTicketId(ticket.getTicketId());
        dto.setTicketNumber(ticket.getTicketNumber());
        dto.setTicketTitle(ticket.getTicketTitle());
        dto.setDescription(ticket.getDescription());
        dto.setTicketStatus(ticket.getTicketStatus());
        dto.setTicketPriority(ticket.getTicketPriority());
        dto.setTicketType(ticket.getTicketType());
        dto.setTicketCategory(ticket.getCategory());
        dto.setSubCategory(ticket.getSubCategory());
        dto.setIsInternal(ticket.getIsInternal());
        dto.setCreatedAt(ticket.getCreatedAt());
        dto.setUpdatedAt(ticket.getUpdatedAt());
        dto.setAssignedAt(ticket.getAssignedAt());
        dto.setInProgressAt(ticket.getInProgressAt());
        dto.setResolvedAt(ticket.getResolvedAt());
        dto.setClosedAt(ticket.getClosedAt());
        dto.setReopenedAt(ticket.getReopenedAt());
        dto.setDueDate(ticket.getDueDate());

        if (ticket.getRaisedTo() != null) {
            dto.setRaisedToDepartmentId(ticket.getRaisedTo().getDepartmentId());
            dto.setRaisedToDepartmentName(ticket.getRaisedTo().getDepartmentName());
        }
        if (ticket.getRaisedBy() != null) {
            dto.setRaisedByDepartmentId(ticket.getRaisedBy().getDepartmentId());
            dto.setRaisedByDepartmentName(ticket.getRaisedBy().getDepartmentName());
        }

        if (ticket.getCreatedBy() != null) {
            dto.setCreatedByUserId(ticket.getCreatedBy().getUserId());
            dto.setCreatedByUserName(ticket.getCreatedBy().getUserName());
        }
        if (ticket.getModifiedBy() != null) {
            dto.setModifiedByUserId(ticket.getModifiedBy().getUserId());
            dto.setModifiedByUserName(ticket.getModifiedBy().getUserName());
        }
        if (ticket.getAssignedTo() != null) {
            dto.setAssignedToUserId(ticket.getAssignedTo().getUserId());
            dto.setAssignedToUserName(ticket.getAssignedTo().getUserName());
        }

        if (ticket.getParentTicket() != null) {
            dto.setParentTicketId(ticket.getParentTicket().getTicketId());
        }
        if (ticket.getChildTickets() != null) {
            dto.setChildTicketIds(
                ticket.getChildTickets().stream()
                      .map(Ticket::getTicketId)
                      .collect(Collectors.toList())
            );
        }

        // Comments, Attachments, and History
        if (ticket.getComments() != null) {
            dto.setComments(ticket.getComments().stream()
                    .map(CommentMapper::toDto)
                    .collect(Collectors.toList()));
        }

        if (ticket.getAttachments() != null) {
            dto.setAttachments(ticket.getAttachments().stream()
                    .map(AttachmentMapper::toDto)
                    .collect(Collectors.toList()));
        }

        if (ticket.getTicketHistory() != null) {
            dto.setTicketHistory(ticket.getTicketHistory().stream()
                    .map(TicketHistoryMapper::toDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static Ticket toEntity(TicketDto dto, Department raisedTo, Department raisedBy, 
                                  User createdBy, User modifiedBy, User assignedTo, Ticket parentTicket) {
        if (dto == null) return null;

        Ticket ticket = new Ticket();
        if (dto.getTicketId() != null && dto.getTicketId() > 0) {
            ticket.setTicketId(dto.getTicketId());
        }

        ticket.setTicketNumber(dto.getTicketNumber());
        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setTicketStatus(dto.getTicketStatus());
        ticket.setTicketPriority(dto.getTicketPriority());
        ticket.setTicketType(dto.getTicketType());
        ticket.setCategory(dto.getTicketCategory());
        ticket.setSubCategory(dto.getSubCategory());
        ticket.setIsInternal(dto.getIsInternal());
        ticket.setCreatedAt(dto.getCreatedAt());
        ticket.setUpdatedAt(dto.getUpdatedAt());
        ticket.setAssignedAt(dto.getAssignedAt());
        ticket.setInProgressAt(dto.getInProgressAt());
        ticket.setResolvedAt(dto.getResolvedAt());
        ticket.setClosedAt(dto.getClosedAt());
        ticket.setReopenedAt(dto.getReopenedAt());
        ticket.setDueDate(dto.getDueDate());

        ticket.setRaisedTo(raisedTo);
        ticket.setRaisedBy(raisedBy);
        ticket.setCreatedBy(createdBy);
        ticket.setModifiedBy(modifiedBy);
        ticket.setAssignedTo(assignedTo);
        ticket.setParentTicket(parentTicket);

        return ticket;
    }
}

