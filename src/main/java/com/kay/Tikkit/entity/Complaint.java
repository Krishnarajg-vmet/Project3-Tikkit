package com.kay.Tikkit.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaint_id")
	private Long complaintId;
	
	@Column(name="complaint_name", unique = true, nullable = false)
	private String complaintName;
	
	@OneToMany(mappedBy = "complaint", fetch = FetchType.LAZY)
	private List<Ticket> tickets;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by", nullable = false)
	private User createdBy;
	
	@Column(name="created_dt", nullable = false)
	private LocalDateTime createdDt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="modified_by", nullable = false)
	private User modifiedBy;
	
	@Column(name="modified_dt", nullable = false)
	private LocalDateTime modifiedDt;

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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

}
