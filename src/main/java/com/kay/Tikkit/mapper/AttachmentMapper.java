package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.AttachmentDto;
import com.kay.Tikkit.entity.Attachment;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;

public class AttachmentMapper {

    public static AttachmentDto toDto(Attachment attachment) {
        if (attachment == null) return null;

        AttachmentDto dto = new AttachmentDto();
        dto.setAttachmentId(attachment.getAttachmentId());
        dto.setFileName(attachment.getFileName());
        dto.setFileType(attachment.getFileType());
        dto.setFileUrl(attachment.getFileUrl());
        dto.setFileSize(attachment.getFileSize());
        dto.setUploadedAt(attachment.getUploadedAt());

        if (attachment.getUploadedBy() != null) {
            dto.setUploadedByUserId(attachment.getUploadedBy().getUserId());
            dto.setUploadedByUserName(attachment.getUploadedBy().getUserName());
        }

        return dto;
    }

    public static Attachment toEntity(AttachmentDto dto, Ticket ticket, User uploadedBy) {
        if (dto == null) return null;

        Attachment attachment = new Attachment();
        if (dto.getAttachmentId() != null && dto.getAttachmentId() > 0) {
            attachment.setAttachmentId(dto.getAttachmentId());
        }

        attachment.setFileName(dto.getFileName());
        attachment.setFileType(dto.getFileType());
        attachment.setFileUrl(dto.getFileUrl());
        attachment.setFileSize(dto.getFileSize());
        attachment.setUploadedAt(dto.getUploadedAt());
        attachment.setTicket(ticket);
        attachment.setUploadedBy(uploadedBy);

        return attachment;
    }
}
