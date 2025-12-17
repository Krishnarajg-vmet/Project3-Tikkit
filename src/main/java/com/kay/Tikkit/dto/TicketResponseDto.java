package com.kay.Tikkit.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.kay.Tikkit.enums.Product;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

public class TicketResponseDto {

    private Long ticketId;
    private String ticketTitle;
    private String description;
    private String ticketNumber;

    private TicketType ticketType;
    private TicketPriority ticketPriority;
    private TicketStatus ticketStatus;
    
    private Product product;
    
    private Long complaintId;
    private String complaintName;

    private Long fromDepartmentId;
    private String fromDepartmentName;

    private Long toDepartmentId;
    private String toDepartmentName;

    private Long createdById;
    private String createdByName;

    private Long modifiedById;
    private String modifiedByName;

    private Long assignedToId;
    private String assignedToName;
    
    private Long resolvedById;
    private String resolvedByName;
    
    private Long closedById;
    private String closedByName;
    
    private Long reopenedById;
    private String reopenedByName;

    private LocalDateTime createdDt;
    private LocalDateTime modifiedDt;
    private LocalDateTime assignedDt;
    private LocalDateTime resolvedDt;
    private LocalDateTime closedDt;
    private LocalDateTime reopenedDt;
    
    private List<TicketHistoryDto> history;
    private List<CommentDto> comments;
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
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Long getFromDepartmentId() {
		return fromDepartmentId;
	}
	public void setFromDepartmentId(Long fromDepartmentId) {
		this.fromDepartmentId = fromDepartmentId;
	}
	public String getFromDepartmentName() {
		return fromDepartmentName;
	}
	public void setFromDepartmentName(String fromDepartmentName) {
		this.fromDepartmentName = fromDepartmentName;
	}
	public Long getToDepartmentId() {
		return toDepartmentId;
	}
	public void setToDepartmentId(Long toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}
	public String getToDepartmentName() {
		return toDepartmentName;
	}
	public void setToDepartmentName(String toDepartmentName) {
		this.toDepartmentName = toDepartmentName;
	}
	public Long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public Long getModifiedById() {
		return modifiedById;
	}
	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}
	public String getModifiedByName() {
		return modifiedByName;
	}
	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
	}
	public Long getAssignedToId() {
		return assignedToId;
	}
	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}
	public String getAssignedToName() {
		return assignedToName;
	}
	public void setAssignedToName(String assignedToName) {
		this.assignedToName = assignedToName;
	}
	public Long getResolvedById() {
		return resolvedById;
	}
	public void setResolvedById(Long resolvedById) {
		this.resolvedById = resolvedById;
	}
	public String getResolvedByName() {
		return resolvedByName;
	}
	public void setResolvedByName(String resolvedByName) {
		this.resolvedByName = resolvedByName;
	}
	public Long getClosedById() {
		return closedById;
	}
	public void setClosedById(Long closedById) {
		this.closedById = closedById;
	}
	public String getClosedByName() {
		return closedByName;
	}
	public void setClosedByName(String closedByName) {
		this.closedByName = closedByName;
	}
	public Long getReopenedById() {
		return reopenedById;
	}
	public void setReopenedById(Long reopenedById) {
		this.reopenedById = reopenedById;
	}
	public String getReopenedByName() {
		return reopenedByName;
	}
	public void setReopenedByName(String reopenedByName) {
		this.reopenedByName = reopenedByName;
	}
	public LocalDateTime getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	public LocalDateTime getAssignedDt() {
		return assignedDt;
	}
	public void setAssignedDt(LocalDateTime assignedDt) {
		this.assignedDt = assignedDt;
	}
	public LocalDateTime getResolvedDt() {
		return resolvedDt;
	}
	public void setResolvedDt(LocalDateTime resolvedDt) {
		this.resolvedDt = resolvedDt;
	}
	public LocalDateTime getClosedDt() {
		return closedDt;
	}
	public void setClosedDt(LocalDateTime closedDt) {
		this.closedDt = closedDt;
	}
	public LocalDateTime getReopenedDt() {
		return reopenedDt;
	}
	public void setReopenedDt(LocalDateTime reopenedDt) {
		this.reopenedDt = reopenedDt;
	}
	public List<TicketHistoryDto> getHistory() {
		return history;
	}
	public void setHistory(List<TicketHistoryDto> history) {
		this.history = history;
	}
	public List<CommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
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
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	
}
