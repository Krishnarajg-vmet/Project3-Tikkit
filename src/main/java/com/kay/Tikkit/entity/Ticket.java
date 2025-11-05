package com.kay.Tikkit.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.kay.Tikkit.enums.*;

import jakarta.persistence.*;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private Long ticketId;
	
	@Column(name="ticket_number", unique=true, nullable = false)
	private String ticketNumber;
	
	@Column(name="ticket_title", nullable = false)
	private String ticketTitle;
	
	@ManyToOne
	@JoinColumn(name="raised_to_department_id", nullable = false)
	private Department raisedTo;
	
	@ManyToOne
	@JoinColumn(name="raised_by_department_id", nullable = false)
	private Department raisedBy;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_status", nullable = false)
	private TicketStatus ticketStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_priority", nullable = false)
	private TicketPriority ticketPriority;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_type", nullable = false)
	private TicketType ticketType;
	
	@Column(name="description", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_category", nullable = false)
	private TicketCategory category;
	
	@Column(name="sub_category", nullable = false)
	private String subCategory;
	
	@Column(name="is_internal", nullable = false)
	private Boolean isInternal;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Attachment> attachments;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TicketHistory> ticketHistory;
	
	@ManyToOne
	private Ticket parentTicket;
	
	@OneToMany(mappedBy = "parentTicket")
	private List<Ticket> childTickets;
	
	@ManyToOne
	@JoinColumn(name = "created_by_user_id", nullable = false, updatable = false)
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "modified_by_user_id")
	private User modifiedBy;
	
	@ManyToOne
	@JoinColumn(name="assigned_to_user_id")
	private User assignedTo;
	
	@Column(name="created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
    private LocalDateTime updatedAt;
    
	@Column(name="assigned_at")
    private LocalDateTime assignedAt;
    
	@Column(name="inprogress_at")
    private LocalDateTime inProgressAt;
    
	@Column(name="resolved_at")
    private LocalDateTime resolvedAt;
    
	@Column(name="closed_at")
    private LocalDateTime closedAt;
    
	@Column(name="reopened_at")
    private LocalDateTime reopenedAt;
    
	@Column(name="due_date")
    private LocalDateTime dueDate;

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

	public Department getRaisedTo() {
		return raisedTo;
	}

	public void setRaisedTo(Department raisedTo) {
		this.raisedTo = raisedTo;
	}

	public Department getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Department raisedBy) {
		this.raisedBy = raisedBy;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketCategory getCategory() {
		return category;
	}

	public void setCategory(TicketCategory category) {
		this.category = category;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachment(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<TicketHistory> getTicketHistory() {
		return ticketHistory;
	}

	public void setTicketHistory(List<TicketHistory> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	public Ticket getParentTicket() {
		return parentTicket;
	}

	public void setParentTicket(Ticket parentTicket) {
		this.parentTicket = parentTicket;
	}

	public List<Ticket> getChildTickets() {
		return childTickets;
	}

	public void setChildTickets(List<Ticket> childTickets) {
		this.childTickets = childTickets;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	

}
