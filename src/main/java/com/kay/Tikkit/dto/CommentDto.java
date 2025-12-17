package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

public class CommentDto {
	
	private Long commentId;
    private String commentText;

    private Long commentedById;
    private String commentedByName;

    private LocalDateTime commentedDt;

    private Long modifiedById;
    private String modifiedByName;
    private LocalDateTime modifiedDt;

    private Long ticketId;
    private String ticketNumber;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Long getCommentedById() {
		return commentedById;
	}
	public void setCommentedById(Long commentedById) {
		this.commentedById = commentedById;
	}
	public String getCommentedByName() {
		return commentedByName;
	}
	public void setCommentedByName(String commentedByName) {
		this.commentedByName = commentedByName;
	}
	public LocalDateTime getCommentedDt() {
		return commentedDt;
	}
	public void setCommentedDt(LocalDateTime commentedDt) {
		this.commentedDt = commentedDt;
	}
	public Long getModifiedById() {
		return modifiedById;
	}
	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}
	public String getModifiedByName() {
		return modifiedByName;
	}
	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
	}
	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
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
