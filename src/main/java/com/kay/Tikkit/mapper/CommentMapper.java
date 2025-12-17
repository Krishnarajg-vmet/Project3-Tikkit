package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.CommentDto;
import com.kay.Tikkit.entity.Comment;

public class CommentMapper {

    public static CommentDto toDto(Comment comment) {
        if (comment == null) return null;

        CommentDto dto = new CommentDto();

        dto.setCommentId(comment.getCommentId());
        dto.setCommentedByName(comment.getComment());

        dto.setTicketId(comment.getTicket().getTicketId());
        dto.setTicketNumber(comment.getTicket().getTicketNumber());

        dto.setCommentedById(comment.getCreatedBy() != null ? comment.getCreatedBy().getUserId() : null);
        dto.setModifiedById(comment.getModifiedBy() != null ? comment.getModifiedBy().getUserId() : null);

        dto.setCommentedDt(comment.getCreatedDt());
        dto.setModifiedDt(comment.getModifiedDt());

        return dto;
    }
}
