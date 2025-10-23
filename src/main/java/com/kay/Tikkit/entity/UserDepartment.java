package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class UserDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_department_id")
	private Long userDepartmentId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name = "created_dt", nullable=false)
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	private LocalDateTime modifiedDt;

	public Long getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	
	
}
