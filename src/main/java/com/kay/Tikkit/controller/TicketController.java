package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;
import com.kay.Tikkit.repositories.UserRepository;
import com.kay.Tikkit.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final UserRepository userRepository;

    public TicketController(TicketService ticketService, UserRepository userRepository) {
        this.ticketService = ticketService;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasAuthority('CREATE_TICKET')")
    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketCreateDto dto) {
        TicketResponseDto response = ticketService.createTicket(dto);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('UPDATE_TICKET')")
    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable Long ticketId,
                                                          @RequestBody TicketUpdateDto dto) {
        TicketResponseDto response = ticketService.modifyTicket(ticketId, dto);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('MODIFY_TICKET')")
    @PostMapping("/{ticketId}/assign")
    public ResponseEntity<TicketResponseDto> assignTicket(@PathVariable Long ticketId,
                                                          @RequestBody TicketAssignDto dto) {
        TicketResponseDto response = ticketService.assignTicket(ticketId, dto.getAssignedToId());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('MODIFY_TICKET')")
    @PostMapping("/{ticketId}/inprogress")
    public ResponseEntity<TicketResponseDto> moveToInProgress(@PathVariable Long ticketId) {
        TicketResponseDto response = ticketService.inProgressTicket(ticketId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('MODIFY_TICKET')")
    @PostMapping("/{ticketId}/resolve")
    public ResponseEntity<TicketResponseDto> resolveTicket(@PathVariable Long ticketId) {
        TicketResponseDto response = ticketService.resolveTicket(ticketId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('UPDATE_TICKET')")
    @PostMapping("/{ticketId}/close")
    public ResponseEntity<TicketResponseDto> closeTicket(@PathVariable Long ticketId) {
        TicketResponseDto response = ticketService.closeTicket(ticketId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('READ_TICKET')")
    @PostMapping("/{ticketId}/reopen")
    public ResponseEntity<TicketResponseDto> reopenTicket(@PathVariable Long ticketId) {
        TicketResponseDto response = ticketService.reopenTicket(ticketId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('READ_TICKET')")
    @GetMapping
    public ResponseEntity<List<TicketListDto>> getAllTickets() {
        List<TicketListDto> list = ticketService.getAllTickets();
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAuthority('READ_TICKET')")
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long ticketId) {
        TicketResponseDto ticketDto = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticketDto);
    }

    @PreAuthorize("hasAuthority('READ_TICKET')")
    @GetMapping("/paged")
    public ResponseEntity<PaginatedTicketListDto> getTicketsPaged(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) TicketStatus ticketStatus,
            @RequestParam(required = false) TicketType ticketType,
            @RequestParam(required = false) TicketPriority ticketPriority) {

        if (page < 1) page = 1;

        PaginatedTicketListDto response =
                ticketService.getTicketsPaginatedWithFilters(ticketStatus, ticketType, ticketPriority, page - 1, size);

        return ResponseEntity.ok(response);
    }
}
