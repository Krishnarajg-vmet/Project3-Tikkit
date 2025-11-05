package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.entity.Comment;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;

public class CommentMapper {

    public static CommentDto toDto(Comment comment) {
        if (comment == null) return null;

        CommentDto dto = new CommentDto();
        dto.setCommentId(comment.getCommentId());
        dto.setMessage(comment.getMessage());
        dto.setCreatedAt(comment.getCreatedAt());

        if (comment.getAuthor() != null) {
            dto.setAuthorId(comment.getAuthor().getUserId());
            dto.setAuthorName(comment.getAuthor().getUserName());
        }

        return dto;
    }

    public static Comment toEntity(CommentDto dto, Ticket ticket, User author) {
        if (dto == null) return null;

        Comment comment = new Comment();
        if (dto.getCommentId() != null && dto.getCommentId() > 0) {
            comment.setCommentId(dto.getCommentId());
        }

        comment.setMessage(dto.getMessage());
        comment.setCreatedAt(dto.getCreatedAt());
        comment.setTicket(ticket);
        comment.setAuthor(author);

        return comment;
    }
}
