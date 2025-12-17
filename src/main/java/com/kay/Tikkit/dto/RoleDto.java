package com.kay.Tikkit.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class RoleDto {
	
	private Long roleId;
	private String roleName;
	private Boolean isActive;
	private LocalDateTime createdDt;
	private LocalDateTime modifiedDt;
	private Set<PermissionDto> permissions;
	
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
	public Set<PermissionDto> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<PermissionDto> permissions) {
		this.permissions = permissions;
	}
}
