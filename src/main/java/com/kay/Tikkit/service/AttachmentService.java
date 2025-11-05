package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.AttachmentDto;
import com.kay.Tikkit.entity.Attachment;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.AttachmentMapper;
import com.kay.Tikkit.repositories.AttachmentRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.repositories.UserRepository;

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
        Ticket ticket = ticketRepository.findById(dto.getAttachmentId())
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        User uploadedBy = userRepository.findById(dto.getUploadedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        dto.setUploadedAt(LocalDateTime.now());

        Attachment attachment = AttachmentMapper.toEntity(dto, ticket, uploadedBy);
        attachment = attachmentRepository.save(attachment);

        return AttachmentMapper.toDto(attachment);
    }

    public List<AttachmentDto> getAttachmentsByTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        return attachmentRepository.findByTicket(ticket)
                .stream()
                .map(AttachmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
