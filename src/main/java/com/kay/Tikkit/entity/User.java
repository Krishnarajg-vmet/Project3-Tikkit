package com.kay.Tikkit.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name", nullable = false, unique = true)
	private String userName;
	
	@OneToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserRole> userRoles = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserDepartment> userDepartments = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name = "created_dt", nullable=false)
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
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

	public Set<UserDepartment> getUserDepartments() {
		return userDepartments;
	}

	public void setUserDepartments(Set<UserDepartment> userDepartments) {
		this.userDepartments = userDepartments;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void addRole(Role role) {
	    UserRole userRole = new UserRole();
	    userRole.setUser(this);
	    userRole.setRole(role);
	    userRole.setIsActive(true);
	    userRole.setCreatedDt(LocalDateTime.now());
	    this.userRoles.add(userRole);
	}

	public void removeRole(Role role) {
	    this.userRoles.removeIf(ur -> ur.getRole().getRoleId().equals(role.getRoleId()));
	}

	public void addDepartment(Department department) {
	    UserDepartment userDept = new UserDepartment();
	    userDept.setUser(this);
	    userDept.setDepartment(department);
	    userDept.setIsActive(true);
	    userDept.setCreatedDt(LocalDateTime.now());
	    this.userDepartments.add(userDept);
	}

	public void removeDepartment(Department department) {
	    this.userDepartments.removeIf(ud -> ud.getDepartment().getDepartmentId().equals(department.getDepartmentId()));
	}


}
