package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.entity.Complaint;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.TicketHistory;
import com.kay.Tikkit.entity.User;

public class TicketHistoryMapper {

    public static TicketHistoryDto toDto(TicketHistory history) {

        if (history == null) return null;

        TicketHistoryDto dto = new TicketHistoryDto();
        dto.setTicketHistoryId(history.getTicketHistoryId());

        if (history.getTicket() != null)
            dto.setTicketId(history.getTicket().getTicketId());

        if (history.getComplaint() != null)
            dto.setComplaintId(history.getComplaint().getComplaintId());

        dto.setActionType(history.getActionType());

        dto.setFromStatus(history.getTicketStatusFrom());
        dto.setToStatus(history.getTicketStatusTo());

        dto.setFromType(history.getTicketTypeFrom());
        dto.setToType(history.getTicketTypeTo());

        dto.setFromPriority(history.getTicketPriorityFrom());
        dto.setToPriority(history.getTicketPriorityTo());

        if (history.getAssignedFrom() != null)
            dto.setFromUserId(history.getAssignedFrom().getUserId());

        if (history.getAssignedTo() != null)
            dto.setToUserId(history.getAssignedTo().getUserId());

        dto.setCommentText(history.getCommentText());
        dto.setChangeSummary(history.getChangeDescription());

        if (history.getChangedBy() != null) {
            dto.setChangedByUserId(history.getChangedBy().getUserId());
            dto.setChangedByUserName(history.getChangedBy().getUserName());
        }

        dto.setChangedDt(history.getChangedDt());

        return dto;
    }

    public static TicketHistory toEntity(TicketHistoryDto dto) {

        if (dto == null) return null;

        TicketHistory history = new TicketHistory();

        history.setTicketHistoryId(dto.getTicketHistoryId());
        history.setActionType(dto.getActionType());

        history.setTicketStatusFrom(dto.getFromStatus());
        history.setTicketStatusTo(dto.getToStatus());

        history.setTicketTypeFrom(dto.getFromType());
        history.setTicketTypeTo(dto.getToType());

        history.setTicketPriorityFrom(dto.getFromPriority());
        history.setTicketPriorityTo(dto.getToPriority());

        history.setCommentText(dto.getCommentText());
        history.setChangeDescription(dto.getChangeSummary());

        history.setChangedDt(dto.getChangedDt());

        if (dto.getTicketId() != null) {
            Ticket t = new Ticket();
            t.setTicketId(dto.getTicketId());
            history.setTicket(t);
        }

        if (dto.getComplaintId() != null) {
            Complaint c = new Complaint();
            c.setComplaintId(dto.getComplaintId());
            history.setComplaint(c);
        }

        if (dto.getFromUserId() != null) {
            User from = new User();
            from.setUserId(dto.getFromUserId());
            history.setAssignedFrom(from);
        }

        if (dto.getToUserId() != null) {
            User to = new User();
            to.setUserId(dto.getToUserId());
            history.setAssignedTo(to);
        }

        if (dto.getChangedByUserId() != null) {
            User changed = new User();
            changed.setUserId(dto.getChangedByUserId());
            history.setChangedBy(changed);
        }

        return history;
    }
}
