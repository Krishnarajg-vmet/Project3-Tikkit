package com.kay.Tikkit.dto;

public class TicketAssignDto {
	
	private Long ticketId;
	
	private Long assignedToId;	
	private Long assignedById;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getAssignedToId() {
		return assignedToId;
	}
	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}
	
	public Long getAssignedById() {
		return assignedById;
	}
	public void setAssignedById(Long assignedById) {
		this.assignedById = assignedById;
	}

}
