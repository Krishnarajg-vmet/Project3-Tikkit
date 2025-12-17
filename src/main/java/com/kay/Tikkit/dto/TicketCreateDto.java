package com.kay.Tikkit.dto;

import com.kay.Tikkit.enums.Product;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

public class TicketCreateDto {
	
	private String ticketTitle;
	private String description;
	
	private TicketType ticketType;
	private TicketStatus ticketStatus;
	private TicketPriority ticketPriority;
	
	private Product product;
	private Long complaintId;
	private String complaintName;
	
	private Long fromDepartmentId;
	private String fromDepartmentName;
	private Long toDepartmentId;
	private String toDepartmentName;
	
	private Long createdById;
	
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
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public TicketPriority getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(TicketPriority ticketPriority) {
		this.ticketPriority = ticketPriority;
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
	
	public Long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}
	public String getFromDepartmentName() {
		return fromDepartmentName;
	}
	public void setFromDepartmentName(String fromDepartmentName) {
		this.fromDepartmentName = fromDepartmentName;
	}
	public String getToDepartmentName() {
		return toDepartmentName;
	}
	public void setToDepartmentName(String toDepartmentName) {
		this.toDepartmentName = toDepartmentName;
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
