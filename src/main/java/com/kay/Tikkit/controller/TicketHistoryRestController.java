package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.TicketHistoryDto;
import com.kay.Tikkit.service.TicketHistoryService;

@RestController
@RequestMapping("/api/ticket-history")
public class TicketHistoryRestController {

    private final TicketHistoryService ticketHistoryService;

    public TicketHistoryRestController(TicketHistoryService ticketHistoryService) {
        this.ticketHistoryService = ticketHistoryService;
    }

    @PostMapping
    public ResponseEntity<TicketHistoryDto> addHistory(@RequestBody TicketHistoryDto dto) {
        TicketHistoryDto created = ticketHistoryService.addHistory(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketHistoryDto>> getHistoryByTicket(@PathVariable Long ticketId) {
        List<TicketHistoryDto> historyList = ticketHistoryService.getHistoryByTicket(ticketId);
        return ResponseEntity.ok(historyList);
    }
}
