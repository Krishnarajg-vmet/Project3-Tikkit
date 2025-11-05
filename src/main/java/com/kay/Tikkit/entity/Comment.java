package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long commentId;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", nullable = false)
	private Ticket ticket;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User author;
	
	@Column(name="message", nullable = false, columnDefinition = "TEXT")
	private String message;
	
	@Column(name="created_at", nullable = false)
	private LocalDateTime createdAt;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
