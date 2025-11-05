package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class TicketHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_history_id")
	private Long ticketHistoryId;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", nullable=false)
	private Ticket ticket;
	
	@Column(name="field_changed", nullable = false)
	private String fieldChanged;
	
	@Column(name="old_value")
	private String oldValue;
	
	@Column(name="new_value")
	private String newValue;
	
	@ManyToOne
	@JoinColumn(name="changed_by", nullable = false)
	private User changesBy;
	
	@Column(name="changed_at", nullable = false)
	private LocalDateTime changedAt;

	public Long getTicketHistoryId() {
		return ticketHistoryId;
	}

	public void setTicketHistoryId(Long ticketHistoryId) {
		this.ticketHistoryId = ticketHistoryId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getFieldChanged() {
		return fieldChanged;
	}

	public void setFieldChanged(String fieldChanged) {
		this.fieldChanged = fieldChanged;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public User getChangesBy() {
		return changesBy;
	}

	public void setChangesBy(User changesBy) {
		this.changesBy = changesBy;
	}

	public LocalDateTime getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}
	
	

}
