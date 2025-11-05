package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

public class TicketHistoryDto {
	
	private Long ticketHistoryId;
    private String fieldChanged;
    private String oldValue;
    private String newValue;
    private Long changedByUserId;
    private String changedByUserName;
    private LocalDateTime changedAt;
	public Long getTicketHistoryId() {
		return ticketHistoryId;
	}
	public void setTicketHistoryId(Long ticketHistoryId) {
		this.ticketHistoryId = ticketHistoryId;
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
	public Long getChangedByUserId() {
		return changedByUserId;
	}
	public void setChangedByUserId(Long changedByUserId) {
		this.changedByUserId = changedByUserId;
	}
	public String getChangedByUserName() {
		return changedByUserName;
	}
	public void setChangedByUserName(String changedByUserName) {
		this.changedByUserName = changedByUserName;
	}
	public LocalDateTime getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}
    

}
