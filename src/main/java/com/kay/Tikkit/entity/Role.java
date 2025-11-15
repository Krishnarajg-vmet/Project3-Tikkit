package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleId;
	
	@Column(name="role_name", nullable = false, unique = true)
	private String roleName;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name = "created_dt", nullable=false)
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	private LocalDateTime modifiedDt;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
