package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.AttachmentDto;
import com.kay.Tikkit.service.AttachmentService;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentRestController {

    private final AttachmentService attachmentService;

    public AttachmentRestController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping
    public ResponseEntity<AttachmentDto> addAttachment(@RequestBody AttachmentDto dto) {
        AttachmentDto created = attachmentService.addAttachment(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<AttachmentDto>> getAttachmentsByTicket(@PathVariable Long ticketId) {
        List<AttachmentDto> attachments = attachmentService.getAttachmentsByTicket(ticketId);
        return ResponseEntity.ok(attachments);
    }
}
