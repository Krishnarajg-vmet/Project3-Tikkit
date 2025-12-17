package com.kay.Tikkit.dto;

public class TicketReopenDto {

	private Long ticketId;
	private Long reopenedById;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
		public Long getReopenedById() {
		return reopenedById;
	}
	public void setReopenedById(Long reopenedById) {
		this.reopenedById = reopenedById;
	}
	
}
