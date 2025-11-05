package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

public class CommentDto {
	
	 private Long commentId;
	 private String message;
	 private Long ticketId;
	 private Long authorId;
	 private String authorName;
	 private Long modifiedByUserId;
	 private String modifiedByUserName;
	 private LocalDateTime createdAt;
	 private LocalDateTime modifiedAt;
	 
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getModifiedByUserId() {
		return modifiedByUserId;
	}
	public void setModifiedByUserId(Long modifiedByUserId) {
		this.modifiedByUserId = modifiedByUserId;
	}
	public String getModifiedByUserName() {
		return modifiedByUserName;
	}
	public void setModifiedByUserName(String modifiedByUserName) {
		this.modifiedByUserName = modifiedByUserName;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
    

}
