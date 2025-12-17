package com.kay.Tikkit.controller;

import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.service.CommentService;
import com.kay.Tikkit.mapper.CommentMapper;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets/{ticketId}/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserRepository userRepository;

    @Autowired
    public CommentController(CommentService commentService, UserRepository userRepository) {
        this.commentService = commentService;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasAuthority('CREATE_COMMENT')")
    @PostMapping
    public ResponseEntity<CommentDto> addComment(
            @PathVariable Long ticketId,
            @RequestBody @Valid String commentText) {
        var comment = commentService.addComment(ticketId, commentText);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }

    @PreAuthorize("hasAuthority('READ_COMMENT')")
    @GetMapping
    public ResponseEntity<List<CommentDto>> getCommentsByTicket(@PathVariable Long ticketId) {
        List<CommentDto> comments = commentService.getCommentsByTicket(ticketId);
        return ResponseEntity.ok(comments);
    }

    @PreAuthorize("hasAuthority('CREATE_COMMENT')")
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable Long ticketId,
            @PathVariable Long commentId) {

        var comment = commentService.getCommentById(ticketId, commentId);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }

    @PreAuthorize("hasAuthority('READ_COMMENT')")
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable Long ticketId,
            @PathVariable Long commentId,
            @RequestBody @Valid String updatedText) {

        var updatedComment = commentService.updateComment(ticketId, commentId, updatedText);
        return ResponseEntity.ok(CommentMapper.toDto(updatedComment));
    }

    @PreAuthorize("hasAuthority('DELETE_COMMENT')")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long ticketId,
            @PathVariable Long commentId) {

        commentService.deleteComment(ticketId, commentId);
        return ResponseEntity.noContent().build();
    }
}
