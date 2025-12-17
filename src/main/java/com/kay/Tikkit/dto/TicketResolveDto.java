package com.kay.Tikkit.dto;

public class TicketResolveDto {
	
	private Long ticketId;
	private Long resolvedById;

	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getResolvedById() {
		return resolvedById;
	}
	public void setResolvedById(Long resolvedById) {
		this.resolvedById = resolvedById;
	}
		
}
