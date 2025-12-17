package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_history")
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_history_id")
    private Long ticketHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status_from")
    private TicketStatus ticketStatusFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status_to")
    private TicketStatus ticketStatusTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type_from")
    private TicketType ticketTypeFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type_to")
    private TicketType ticketTypeTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_priority_from")
    private TicketPriority ticketPriorityFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_priority_to")
    private TicketPriority ticketPriorityTo;
    
 // complaint tracking
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complaint_from_id")
    private Complaint complaintFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complaint_to_id")
    private Complaint complaintTo;

    // department tracking
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_department_from_id")
    private Department fromDepartmentFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_department_to_id")
    private Department fromDepartmentTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_department_from_id")
    private Department toDepartmentFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_department_to_id")
    private Department toDepartmentTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_from_user_id")
    private User assignedFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_user_id")
    private User assignedTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_user_id")
    private User changedBy;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "change_description")
    private String changeDescription;

    @Column(name = "changed_dt", nullable = false)
    private LocalDateTime changedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_modified_by_id")
    private User lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

	public Long getTicketHistoryId() {
		return ticketHistoryId;
	}

	public void setTicketHistoryId(Long ticketHistoryId) {
		this.ticketHistoryId = ticketHistoryId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public TicketStatus getTicketStatusFrom() {
		return ticketStatusFrom;
	}

	public void setTicketStatusFrom(TicketStatus ticketStatusFrom) {
		this.ticketStatusFrom = ticketStatusFrom;
	}

	public TicketStatus getTicketStatusTo() {
		return ticketStatusTo;
	}

	public void setTicketStatusTo(TicketStatus ticketStatusTo) {
		this.ticketStatusTo = ticketStatusTo;
	}

	public TicketType getTicketTypeFrom() {
		return ticketTypeFrom;
	}

	public void setTicketTypeFrom(TicketType ticketTypeFrom) {
		this.ticketTypeFrom = ticketTypeFrom;
	}

	public TicketType getTicketTypeTo() {
		return ticketTypeTo;
	}

	public void setTicketTypeTo(TicketType ticketTypeTo) {
		this.ticketTypeTo = ticketTypeTo;
	}

	public TicketPriority getTicketPriorityFrom() {
		return ticketPriorityFrom;
	}

	public void setTicketPriorityFrom(TicketPriority ticketPriorityFrom) {
		this.ticketPriorityFrom = ticketPriorityFrom;
	}

	public TicketPriority getTicketPriorityTo() {
		return ticketPriorityTo;
	}

	public void setTicketPriorityTo(TicketPriority ticketPriorityTo) {
		this.ticketPriorityTo = ticketPriorityTo;
	}

	public User getAssignedFrom() {
		return assignedFrom;
	}

	public void setAssignedFrom(User assignedFrom) {
		this.assignedFrom = assignedFrom;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	public LocalDateTime getChangedDt() {
		return changedDt;
	}

	public void setChangedDt(LocalDateTime changedDt) {
		this.changedDt = changedDt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Complaint getComplaintFrom() {
		return complaintFrom;
	}

	public void setComplaintFrom(Complaint complaintFrom) {
		this.complaintFrom = complaintFrom;
	}

	public Complaint getComplaintTo() {
		return complaintTo;
	}

	public void setComplaintTo(Complaint complaintTo) {
		this.complaintTo = complaintTo;
	}

	public Department getFromDepartmentFrom() {
		return fromDepartmentFrom;
	}

	public void setFromDepartmentFrom(Department fromDepartmentFrom) {
		this.fromDepartmentFrom = fromDepartmentFrom;
	}

	public Department getFromDepartmentTo() {
		return fromDepartmentTo;
	}

	public void setFromDepartmentTo(Department fromDepartmentTo) {
		this.fromDepartmentTo = fromDepartmentTo;
	}

	public Department getToDepartmentFrom() {
		return toDepartmentFrom;
	}

	public void setToDepartmentFrom(Department toDepartmentFrom) {
		this.toDepartmentFrom = toDepartmentFrom;
	}

	public Department getToDepartmentTo() {
		return toDepartmentTo;
	}

	public void setToDepartmentTo(Department toDepartmentTo) {
		this.toDepartmentTo = toDepartmentTo;
	}
    

}
