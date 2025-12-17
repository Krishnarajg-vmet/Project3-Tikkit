package com.kay.Tikkit.dto;

public class TicketInProgressDto {
	
	private Long ticketId;
	private Long modifiedById;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getModifiedById() {
		return modifiedById;
	}
	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}

}
