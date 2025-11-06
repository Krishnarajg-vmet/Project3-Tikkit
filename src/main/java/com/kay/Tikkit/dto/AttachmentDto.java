package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

public class AttachmentDto {

	private Long attachmentId;
	private Long ticketId;
	private String ticketNumber;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private Long fileSize;
    private Long uploadedByUserId;
    private String uploadedByUserName;
    private LocalDateTime uploadedAt;
	public Long getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
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
	public Long getUploadedByUserId() {
		return uploadedByUserId;
	}
	public void setUploadedByUserId(Long uploadedByUserId) {
		this.uploadedByUserId = uploadedByUserId;
	}
	public String getUploadedByUserName() {
		return uploadedByUserName;
	}
	public void setUploadedByUserName(String uploadedByUserName) {
		this.uploadedByUserName = uploadedByUserName;
	}
	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}
	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	    
   
}
