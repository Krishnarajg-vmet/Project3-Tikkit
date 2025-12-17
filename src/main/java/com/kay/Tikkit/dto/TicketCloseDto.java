package com.kay.Tikkit.dto;

public class TicketCloseDto {
	
	private Long ticketId;
	private Long closedById;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getClosedById() {
		return closedById;
	}
	public void setClosedById(Long closedById) {
		this.closedById = closedById;
	}
		
}
