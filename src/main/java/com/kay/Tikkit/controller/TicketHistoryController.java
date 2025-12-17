package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.service.TicketHistoryService;

@RestController
@RequestMapping("/api/tickets/history")
public class TicketHistoryController {

    private final TicketHistoryService ticketHistoryService;

    public TicketHistoryController(TicketHistoryService ticketHistoryService) {
        this.ticketHistoryService = ticketHistoryService;
    }

    @PreAuthorize("hasAuthority('TICKET_HISTORY')")
    @GetMapping("/{ticketId}")
    public ResponseEntity<List<TicketHistoryDto>> getTicketHistory(@PathVariable Long ticketId) {

        List<TicketHistoryDto> dtos = ticketHistoryService.getHistory(ticketId);

        return ResponseEntity.ok(dtos);
    }
}
