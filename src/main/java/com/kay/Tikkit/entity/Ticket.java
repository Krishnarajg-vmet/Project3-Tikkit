package com.kay.Tikkit.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.kay.Tikkit.enums.*;

import jakarta.persistence.*;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private Long ticketId;
	
	@Column(name="ticket_number", unique = true, nullable = false)
	private String ticketNumber;
	
	@Column(name= "ticket_title", nullable = false)
	private String ticketTitle;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_type", nullable = false)
	private TicketType ticketType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_status", nullable = false)
	private TicketStatus ticketStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_priority", nullable = false)
	private TicketPriority ticketPriority;
	
	@Enumerated(EnumType.STRING)
	@Column(name="product", nullable = false)
	private Product product;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="complaint_id")
	private Complaint complaint;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	private Set<TicketHistory> ticketHistory;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	private Set<Comment> comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="from_department_id", nullable = false)
	private Department fromDepartment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="to_department_id", nullable = false)
	private Department toDepartment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by_id")
	private User createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to_id")
	private User assignedTo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_by_id")
	private User assignedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by_id")
	private User modifiedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resolved_by_id")
	private User resolvedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "closed_by_id")
	private User closedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reopened_by_id")
	private User reopenedBy;
	
	@Column(name="created_dt", nullable = false)
	private LocalDateTime createdDt;
	
	@Column(name="assigned_dt")
	private LocalDateTime assignedDt;
	
	@Column(name="modified_dt")
	private LocalDateTime modifiedDt;
	
	@Column(name="resolved_dt")
	private LocalDateTime resolvedDt;
	
	@Column(name="closed_dt")
	private LocalDateTime closedDt;
	
	@Column(name="reopened_dt")
	private LocalDateTime reopenedDt;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;

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

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TicketHistory> getTicketHistory() {
		return ticketHistory;
	}

	public void setTicketHistory(Set<TicketHistory> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Department getFromDepartment() {
		return fromDepartment;
	}

	public void setFromDepartment(Department fromDepartment) {
		this.fromDepartment = fromDepartment;
	}

	public Department getToDepartment() {
		return toDepartment;
	}

	public void setToDepartment(Department toDepartment) {
		this.toDepartment = toDepartment;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(User assignedBy) {
		this.assignedBy = assignedBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public User getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(User resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public User getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(User closedBy) {
		this.closedBy = closedBy;
	}

	public User getReopenedBy() {
		return reopenedBy;
	}

	public void setReopenedBy(User reopenedBy) {
		this.reopenedBy = reopenedBy;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
