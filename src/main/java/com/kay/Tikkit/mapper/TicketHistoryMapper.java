package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.TicketHistory;
import com.kay.Tikkit.entity.User;

public class TicketHistoryMapper {

    public static TicketHistoryDto toDto(TicketHistory history) {
        if (history == null) return null;

        TicketHistoryDto dto = new TicketHistoryDto();
        dto.setTicketHistoryId(history.getTicketHistoryId());
        dto.setFieldChanged(history.getFieldChanged());
        dto.setOldValue(history.getOldValue());
        dto.setNewValue(history.getNewValue());
        dto.setChangedAt(history.getChangedAt());

        if (history.getChangesBy() != null) {
            dto.setChangedByUserId(history.getChangesBy().getUserId());
            dto.setChangedByUserName(history.getChangesBy().getUserName());
        }

        return dto;
    }

    public static TicketHistory toEntity(TicketHistoryDto dto, Ticket ticket, User changedBy) {
        if (dto == null) return null;

        TicketHistory history = new TicketHistory();
        if (dto.getTicketHistoryId() != null && dto.getTicketHistoryId() > 0) {
            history.setTicketHistoryId(dto.getTicketHistoryId());
        }

        history.setFieldChanged(dto.getFieldChanged());
        history.setOldValue(dto.getOldValue());
        history.setNewValue(dto.getNewValue());
        history.setChangedAt(dto.getChangedAt());
        history.setTicket(ticket);
        history.setChangesBy(changedBy);

        return history;
    }
}
