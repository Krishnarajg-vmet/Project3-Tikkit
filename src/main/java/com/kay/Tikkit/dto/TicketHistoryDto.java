package com.kay.Tikkit.dto;

import java.time.LocalDateTime;

import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

public class TicketHistoryDto {

    private Long ticketHistoryId;

    private Long ticketId;
    private Long complaintId;

    private String actionType;

    private TicketStatus fromStatus;
    private TicketStatus toStatus;

    private TicketType fromType;
    private TicketType toType;

    private TicketPriority fromPriority;
    private TicketPriority toPriority;

    private Long fromUserId;
    private Long toUserId;

    private String commentText;
    private String changeSummary;

    private Long changedByUserId;
    private String changedByUserName;

    private LocalDateTime changedDt;

	public Long getTicketHistoryId() {
		return ticketHistoryId;
	}

	public void setTicketHistoryId(Long ticketHistoryId) {
		this.ticketHistoryId = ticketHistoryId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public TicketStatus getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(TicketStatus fromStatus) {
		this.fromStatus = fromStatus;
	}

	public TicketStatus getToStatus() {
		return toStatus;
	}

	public void setToStatus(TicketStatus toStatus) {
		this.toStatus = toStatus;
	}

	public TicketType getFromType() {
		return fromType;
	}

	public void setFromType(TicketType fromType) {
		this.fromType = fromType;
	}

	public TicketType getToType() {
		return toType;
	}

	public void setToType(TicketType toType) {
		this.toType = toType;
	}

	public TicketPriority getFromPriority() {
		return fromPriority;
	}

	public void setFromPriority(TicketPriority fromPriority) {
		this.fromPriority = fromPriority;
	}

	public TicketPriority getToPriority() {
		return toPriority;
	}

	public void setToPriority(TicketPriority toPriority) {
		this.toPriority = toPriority;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getChangeSummary() {
		return changeSummary;
	}

	public void setChangeSummary(String changeSummary) {
		this.changeSummary = changeSummary;
	}

	public Long getChangedByUserId() {
		return changedByUserId;
	}

	public void setChangedByUserId(Long changedByUserId) {
		this.changedByUserId = changedByUserId;
	}

	public String getChangedByUserName() {
		return changedByUserName;
	}

	public void setChangedByUserName(String changedByUserName) {
		this.changedByUserName = changedByUserName;
	}

	public LocalDateTime getChangedDt() {
		return changedDt;
	}

	public void setChangedDt(LocalDateTime changedDt) {
		this.changedDt = changedDt;
	}
    
    

}
