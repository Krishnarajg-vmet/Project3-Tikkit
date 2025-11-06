package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.AttachmentDto;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.AttachmentMapper;
import com.kay.Tikkit.repositories.*;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public AttachmentDto addAttachment(AttachmentDto dto) {
        Ticket ticket = ticketRepository.findById(dto.getTicketId())
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        User uploadedBy = userRepository.findById(dto.getUploadedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        dto.setUploadedAt(LocalDateTime.now());

        Attachment attachment = AttachmentMapper.toEntity(dto, ticket, uploadedBy);
        return AttachmentMapper.toDto(attachmentRepository.save(attachment));
    }

    public List<AttachmentDto> getAttachmentsByTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        return attachmentRepository.findByTicket(ticket)
                .stream()
                .map(AttachmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteAttachment(Long attachmentId) {
        attachmentRepository.deleteById(attachmentId);
    }
}
