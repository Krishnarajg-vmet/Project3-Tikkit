package com.kay.Tikkit.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class UserDto {

    private Long userId;
    private String userName;

    private Long employeeId;
    private String employeeName;
    private String employeeCode;

    private Set<Long> roleIds;
    private Set<String> roleNames;

    private Set<Long> departmentIds;
    private Set<String> departmentNames;

    private Boolean isActive;
    private LocalDateTime createdDt;
    private LocalDateTime modifiedDt;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Set<Long> getRoleIds() {
        return roleIds;
    }
    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<String> getRoleNames() {
        return roleNames;
    }
    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }

    public Set<Long> getDepartmentIds() {
        return departmentIds;
    }
    public void setDepartmentIds(Set<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public Set<String> getDepartmentNames() {
        return departmentNames;
    }
    public void setDepartmentNames(Set<String> departmentNames) {
        this.departmentNames = departmentNames;
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
