package com.kay.Tikkit.dto;

import com.kay.Tikkit.enums.Product;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketType;

public class TicketUpdateDto {
	
	private Long ticketId;
	private String ticketTitle;
	private String description;
	
	private TicketType ticketType;
	private TicketPriority ticketPriority;
	
	private Product product;
	
	private Long complaintId;
	private String complaintName;
	
	private Long fromDepartmentId;
	private Long toDepartmentId;
	
	private Long modifiedById;
		
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	public TicketPriority getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(TicketPriority ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public Long getModifiedById() {
		return modifiedById;
	}
	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}
	public Long getFromDepartmentId() {
		return fromDepartmentId;
	}
	public void setFromDepartmentId(Long fromDepartmentId) {
		this.fromDepartmentId = fromDepartmentId;
	}
	public Long getToDepartmentId() {
		return toDepartmentId;
	}
	public void setToDepartmentId(Long toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintName() {
		return complaintName;
	}
	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}

}
