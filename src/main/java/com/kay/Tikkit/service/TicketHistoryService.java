package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.TicketHistory;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.TicketHistoryMapper;
import com.kay.Tikkit.repositories.TicketHistoryRepository;

@Service
public class TicketHistoryService {

    private final TicketHistoryRepository ticketHistoryRepository;

    public TicketHistoryService(TicketHistoryRepository ticketHistoryRepository) {
        this.ticketHistoryRepository = ticketHistoryRepository;
    }

    @Transactional
    public void logHistory(Ticket newTicket,
                           String actionType,
                           Ticket oldTicket,
                           User changedBy,
                           String changeDescription) {

        TicketHistory history = new TicketHistory();

        history.setTicket(newTicket);
        history.setActionType(actionType);

        if (oldTicket != null) {
            history.setTicketStatusFrom(oldTicket.getTicketStatus());
            history.setTicketTypeFrom(oldTicket.getTicketType());
            history.setTicketPriorityFrom(oldTicket.getTicketPriority());

            history.setAssignedFrom(oldTicket.getAssignedTo());
            history.setComplaintFrom(oldTicket.getComplaint());
            history.setFromDepartmentFrom(oldTicket.getFromDepartment());
            history.setToDepartmentFrom(oldTicket.getToDepartment());
        }

        history.setTicketStatusTo(newTicket.getTicketStatus());
        history.setTicketTypeTo(newTicket.getTicketType());
        history.setTicketPriorityTo(newTicket.getTicketPriority());

        history.setAssignedTo(newTicket.getAssignedTo());
        history.setComplaintTo(newTicket.getComplaint());
        history.setFromDepartmentTo(newTicket.getFromDepartment());
        history.setToDepartmentTo(newTicket.getToDepartment());

        history.setChangedBy(changedBy);
        history.setChangedDt(LocalDateTime.now());
        history.setChangeDescription(changeDescription);

        history.setCreatedBy(changedBy);
        history.setCreatedDate(LocalDateTime.now());

        history.setLastModifiedBy(changedBy);
        history.setLastModifiedDate(LocalDateTime.now());

        ticketHistoryRepository.save(history);
    }

    @Transactional
    public List<TicketHistory> getHistoryByTicketId(Long ticketId) {
        return ticketHistoryRepository.findByTicketTicketIdOrderByChangedDtDesc(ticketId);
    }
    
    @Transactional
    public List<TicketHistoryDto> getHistory(Long ticketId) {
        List<TicketHistory> historyList = ticketHistoryRepository.findByTicketTicketIdOrderByChangedDtDesc(ticketId);

        historyList.forEach(h -> {
            if (h.getCreatedBy() != null) {
                h.getCreatedBy().getUserName();
            }
            if (h.getLastModifiedBy() != null) {
                h.getLastModifiedBy().getUserName();
            }
        });

        return historyList.stream()
                .map(TicketHistoryMapper::toDto)
                .toList();
    }


}
