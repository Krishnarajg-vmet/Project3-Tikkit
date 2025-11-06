package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.TicketHistoryMapper;
import com.kay.Tikkit.repositories.*;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketHistoryService {

    @Autowired
    private TicketHistoryRepository ticketHistoryRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketHistoryDto addTicketHistory(Long ticketId, String fieldChanged, String oldValue, String newValue, Long changedByUserId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        User changedBy = userRepository.findById(changedByUserId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        TicketHistory history = new TicketHistory();
        history.setTicket(ticket);
        history.setFieldChanged(fieldChanged);
        history.setOldValue(oldValue);
        history.setNewValue(newValue);
        history.setChangedAt(LocalDateTime.now());
        history.setChangesBy(changedBy);

        return TicketHistoryMapper.toDto(ticketHistoryRepository.save(history));
    }
    
    public List<TicketHistoryDto> getHistoryByTicket(Long ticketId) {
        List<TicketHistory> historyList = ticketHistoryRepository.findByTicketId(ticketId);
        return historyList.stream()
                .map(TicketHistoryMapper::toDto)
                .toList();
    }

}
