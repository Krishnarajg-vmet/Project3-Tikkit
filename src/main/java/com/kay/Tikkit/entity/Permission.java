package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Permission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="permission_id")
    private Long permissionId;

    @Column(name="permission_name", nullable = false, unique = true)
    private String permissionName;

    @Column(name = "permission_description", nullable = true)
    private String description;
    
    @Column(name="is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name="created_dt", nullable = false)
    private LocalDateTime createdDt;
    
    @Column(name="modified_dt")
    private LocalDateTime modifiedDt;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
