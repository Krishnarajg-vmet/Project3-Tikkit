package com.kay.Tikkit.service;

import com.kay.Tikkit.config.SecurityUtil;
import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.entity.Comment;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.repositories.CommentRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.mapper.CommentMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TicketHistoryService ticketHistoryService;
    private final TicketRepository ticketRepository;
    private final SecurityUtil securityUtil;

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          TicketHistoryService ticketHistoryService,
                          TicketRepository ticketRepository,
                          SecurityUtil securityUtil) {
        this.commentRepository = commentRepository;
        this.ticketHistoryService = ticketHistoryService;
        this.ticketRepository = ticketRepository;
        this.securityUtil = securityUtil;
    }

    @Transactional
    public Comment addComment(Long ticketId, String commentText) {
        User currentUser = securityUtil.getCurrentUser();

        if (currentUser == null) {
            throw new IllegalStateException("No user is currently authenticated.");
        }

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found. ID: " + ticketId));

        Comment comment = new Comment();
        comment.setTicket(ticket);
        comment.setComment(commentText);
        comment.setCreatedBy(currentUser);
        comment.setCreatedDt(LocalDateTime.now());
        comment.setIsActive(true);

        Comment savedComment = commentRepository.save(comment);
        ticketHistoryService.logHistory(
                ticket,
                "COMMENT_ADD",
                null,
                currentUser,
                "Comment added: " + commentText
        );

        return savedComment;
    }

    @Transactional
    public List<CommentDto> getCommentsByTicket(Long ticketId) {
        List<Comment> comments = commentRepository.findByTicketTicketId(ticketId);
        return comments.stream()
                .map(CommentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Comment getCommentById(Long ticketId, Long commentId) {
        return commentRepository.findById(commentId)
                .filter(c -> c.getTicket().getTicketId().equals(ticketId))
                .orElseThrow(() -> new EntityNotFoundException(
                        "Comment not found. Ticket ID: " + ticketId + ", Comment ID: " + commentId));
    }

    @Transactional
    public Comment updateComment(Long ticketId, Long commentId, @Valid String updatedText) {
        // Get current user
        User currentUser = securityUtil.getCurrentUser();

        if (currentUser == null) {
            throw new IllegalStateException("No user is currently authenticated.");
        }

        Comment comment = getCommentById(ticketId, commentId);

        comment.setComment(updatedText);
        comment.setModifiedBy(currentUser); // Set current user as the modifier of the comment
        comment.setModifiedDt(LocalDateTime.now());

        Comment updatedComment = commentRepository.save(comment);

        // Log history of comment update
        ticketHistoryService.logHistory(
                comment.getTicket(),
                "COMMENT_UPDATE",
                null,
                currentUser,
                "Comment updated to: " + updatedText
        );

        return updatedComment;
    }

    @Transactional
    public void deleteComment(Long ticketId, Long commentId) {
        // Get current user
        User currentUser = securityUtil.getCurrentUser();

        if (currentUser == null) {
            throw new IllegalStateException("No user is currently authenticated.");
        }

        Comment comment = getCommentById(ticketId, commentId);
        comment.setIsActive(false);
        commentRepository.save(comment);

        // Log history of comment deletion
        ticketHistoryService.logHistory(
                comment.getTicket(),
                "COMMENT_DELETE",
                null,
                currentUser, // The user performing the deletion
                "Comment deleted: " + comment.getComment()
        );
    }
}
