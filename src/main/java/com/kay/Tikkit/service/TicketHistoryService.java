package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.TicketHistory;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.TicketHistoryMapper;
import com.kay.Tikkit.repositories.TicketHistoryRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketHistoryService {

    @Autowired
    private TicketHistoryRepository ticketHistoryRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketHistoryDto addHistory(TicketHistoryDto dto) {
        Ticket ticket = ticketRepository.findById(dto.getTicketHistoryId())
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        User changedBy = userRepository.findById(dto.getChangedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        dto.setChangedAt(LocalDateTime.now());

        TicketHistory history = TicketHistoryMapper.toEntity(dto, ticket, changedBy);
        history = ticketHistoryRepository.save(history);

        return TicketHistoryMapper.toDto(history);
    }

    public List<TicketHistoryDto> getHistoryByTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        return ticketHistoryRepository.findByTicket(ticket)
                .stream()
                .map(TicketHistoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
