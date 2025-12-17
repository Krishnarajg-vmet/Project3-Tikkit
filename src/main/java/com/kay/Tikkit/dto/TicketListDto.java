package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

import com.kay.Tikkit.enums.Product;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

public class TicketListDto {
	
	private Long ticketId;
	private String ticketNumber;
    private String ticketTitle;
    
    private TicketType ticketType;
    private TicketPriority ticketPriority;
    private TicketStatus ticketStatus;
    
    private Product product;
    
    private String complaintName;
    
    private String fromDepartmentName;

    private String createdByName;
    private String assignedToName;
    private String modifiedByName;
    
    private LocalDateTime createdDt;
    private LocalDateTime assignedDt;
    private LocalDateTime modifiedDt;
    
    public TicketListDto() {
        // no-args constructor needed for frameworks or manual object creation
    }
    
    public TicketListDto(
    	    Long ticketId,
    	    String ticketNumber,
    	    String ticketTitle,
    	    TicketType ticketType,
    	    TicketPriority ticketPriority,
    	    TicketStatus ticketStatus,
    	    Product product,
    	    String complaintName,
    	    String fromDepartmentName,
    	    String createdByName,
    	    String assignedToName,
    	    String modifiedByName,
    	    LocalDateTime createdDt,
    	    LocalDateTime assignedDt,
    	    LocalDateTime modifiedDt
    	) {
    	    this.ticketId = ticketId;
    	    this.ticketNumber = ticketNumber;
    	    this.ticketTitle = ticketTitle;
    	    this.ticketType = ticketType;
    	    this.ticketPriority = ticketPriority;
    	    this.ticketStatus = ticketStatus;
    	    this.product = product;
    	    this.complaintName = complaintName;
    	    this.fromDepartmentName = fromDepartmentName;
    	    this.createdByName = createdByName;
    	    this.assignedToName = assignedToName;
    	    this.modifiedByName = modifiedByName;
    	    this.createdDt = createdDt;
    	    this.assignedDt = assignedDt;
    	    this.modifiedDt = modifiedDt;
    	}

    
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
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getAssignedToName() {
		return assignedToName;
	}
	public void setAssignedToName(String assignedToName) {
		this.assignedToName = assignedToName;
	}
	public String getModifiedByName() {
		return modifiedByName;
	}
	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
	}
	public LocalDateTime getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
	public LocalDateTime getAssignedDt() {
		return assignedDt;
	}
	public void setAssignedDt(LocalDateTime assignedDt) {
		this.assignedDt = assignedDt;
	}
	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getFromDepartmentName() {
		return fromDepartmentName;
	}
	public void setFromDepartmentName(String fromDepartmentName) {
		this.fromDepartmentName = fromDepartmentName;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getComplaintName() {
		return complaintName;
	}
	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}
    

}
