package com.kay.Tikkit.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.kay.Tikkit.enums.*;

public class TicketDto {

    private Long ticketId;
    private String ticketNumber;
    private String ticketTitle;
    private String description;

    private Long raisedToDepartmentId;
    private String raisedToDepartmentName;
    private Long raisedByDepartmentId;
    private String raisedByDepartmentName;

    private TicketStatus ticketStatus;
    private TicketPriority ticketPriority;
    private TicketType ticketType;
    private TicketCategory ticketCategory;

    private String subCategory;
    private Boolean isInternal;

    private Long createdByUserId;
    private String createdByUserName;
    private Long modifiedByUserId;
    private String modifiedByUserName;
    private Long assignedToUserId;
    private String assignedToUserName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime assignedAt;
    private LocalDateTime inProgressAt;
    private LocalDateTime resolvedAt;
    private LocalDateTime closedAt;
    private LocalDateTime reopenedAt;
    private LocalDateTime dueDate;

    private List<CommentDto> comments;
    private List<AttachmentDto> attachments;
    private List<TicketHistoryDto> ticketHistory;

    private Long parentTicketId;
    private List<Long> childTicketIds;
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
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
	public Long getRaisedToDepartmentId() {
		return raisedToDepartmentId;
	}
	public void setRaisedToDepartmentId(Long raisedToDepartmentId) {
		this.raisedToDepartmentId = raisedToDepartmentId;
	}
	public String getRaisedToDepartmentName() {
		return raisedToDepartmentName;
	}
	public void setRaisedToDepartmentName(String raisedToDepartmentName) {
		this.raisedToDepartmentName = raisedToDepartmentName;
	}
	public Long getRaisedByDepartmentId() {
		return raisedByDepartmentId;
	}
	public void setRaisedByDepartmentId(Long raisedByDepartmentId) {
		this.raisedByDepartmentId = raisedByDepartmentId;
	}
	public String getRaisedByDepartmentName() {
		return raisedByDepartmentName;
	}
	public void setRaisedByDepartmentName(String raisedByDepartmentName) {
		this.raisedByDepartmentName = raisedByDepartmentName;
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
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public TicketCategory getTicketCategory() {
		return ticketCategory;
	}
	public void setTicketCategory(TicketCategory ticketCategory) {
		this.ticketCategory = ticketCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Boolean getIsInternal() {
		return isInternal;
	}
	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}
	public Long getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	public String getCreatedByUserName() {
		return createdByUserName;
	}
	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}
	public Long getModifiedByUserId() {
		return modifiedByUserId;
	}
	public void setModifiedByUserId(Long modifiedByUserId) {
		this.modifiedByUserId = modifiedByUserId;
	}
	public String getModifiedByUserName() {
		return modifiedByUserName;
	}
	public void setModifiedByUserName(String modifiedByUserName) {
		this.modifiedByUserName = modifiedByUserName;
	}
	public Long getAssignedToUserId() {
		return assignedToUserId;
	}
	public void setAssignedToUserId(Long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}
	public String getAssignedToUserName() {
		return assignedToUserName;
	}
	public void setAssignedToUserName(String assignedToUserName) {
		this.assignedToUserName = assignedToUserName;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDateTime getAssignedAt() {
		return assignedAt;
	}
	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}
	public LocalDateTime getInProgressAt() {
		return inProgressAt;
	}
	public void setInProgressAt(LocalDateTime inProgressAt) {
		this.inProgressAt = inProgressAt;
	}
	public LocalDateTime getResolvedAt() {
		return resolvedAt;
	}
	public void setResolvedAt(LocalDateTime resolvedAt) {
		this.resolvedAt = resolvedAt;
	}
	public LocalDateTime getClosedAt() {
		return closedAt;
	}
	public void setClosedAt(LocalDateTime closedAt) {
		this.closedAt = closedAt;
	}
	public LocalDateTime getReopenedAt() {
		return reopenedAt;
	}
	public void setReopenedAt(LocalDateTime reopenedAt) {
		this.reopenedAt = reopenedAt;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public List<CommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}
	public List<AttachmentDto> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AttachmentDto> attachments) {
		this.attachments = attachments;
	}
	public List<TicketHistoryDto> getTicketHistory() {
		return ticketHistory;
	}
	public void setTicketHistory(List<TicketHistoryDto> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}
	public Long getParentTicketId() {
		return parentTicketId;
	}
	public void setParentTicketId(Long parentTicketId) {
		this.parentTicketId = parentTicketId;
	}
	public List<Long> getChildTicketIds() {
		return childTicketIds;
	}
	public void setChildTicketIds(List<Long> childTicketIds) {
		this.childTicketIds = childTicketIds;
	}

}

