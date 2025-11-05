package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto dto) {
        CommentDto created = commentService.addComment(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<CommentDto>> getCommentsByTicket(@PathVariable Long ticketId) {
        List<CommentDto> comments = commentService.getCommentsByTicket(ticketId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @RequestBody CommentDto dto) {
        CommentDto updated = commentService.updateComment(dto, commentId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
