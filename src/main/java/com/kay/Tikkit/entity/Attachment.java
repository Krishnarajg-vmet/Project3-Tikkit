package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="attachment_id")
	private Long attachmentId;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", nullable = false)
	private Ticket ticket;
	
	@Column(name="file_name", nullable = false)
	private String fileName;
	
	@Column(name="file_type", nullable = false)
	private String fileType;
	
	@Column(name="file_url", nullable = false)
	private String fileUrl;
	
	@Column(name="file_size", nullable = false)
	private Long fileSize;
	
	@Column(name="uploaded_at", nullable = false)
	private LocalDateTime uploadedAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User uploadedBy;

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public User getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(User uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

}
