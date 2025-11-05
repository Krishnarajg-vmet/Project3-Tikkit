package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.entity.Comment;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.CommentMapper;
import com.kay.Tikkit.repositories.CommentRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentDto addComment(CommentDto dto) {
        Ticket ticket = ticketRepository.findById(dto.getTicketId())
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        User createdBy = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        dto.setCreatedAt(LocalDateTime.now());

        Comment comment = CommentMapper.toEntity(dto, ticket, createdBy);
        comment = commentRepository.save(comment);

        return CommentMapper.toDto(comment);
    }

    public List<CommentDto> getCommentsByTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        return commentRepository.findByTicket(ticket)
                .stream()
                .map(CommentMapper::toDto)
                .collect(Collectors.toList());
    }

    public CommentDto updateComment(CommentDto dto, Long commentId) {
        return commentRepository.findById(commentId).map(existing -> {
            User modifiedBy = userRepository.findById(dto.getModifiedByUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
            existing.setMessage(dto.getMessage());
            return CommentMapper.toDto(commentRepository.save(existing));
        }).orElseThrow(() -> new EntityNotFoundException("Comment not found"));
    }

    public void deleteComment(Long commentId) {
        commentRepository.findById(commentId).ifPresent(commentRepository::delete);
    }
}
