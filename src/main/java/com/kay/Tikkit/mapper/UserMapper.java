package com.kay.Tikkit.mapper;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserDepartment;
import com.kay.Tikkit.entity.UserRole;

public class UserMapper {
	
	public static UserDto toDto(User user, Set<UserRole> userRole, Set<UserDepartment> userDepartment) {
	    if (user == null) return null;

	    UserDto dto = new UserDto();
	    dto.setUserId(user.getUserId());
	    dto.setUserName(user.getUserName());

	    if (user.getEmployee() != null) {
	        dto.setEmployeeId(user.getEmployee().getEmployeeId());
	        dto.setEmployeeName(user.getEmployee().getFirstName() + " " + user.getEmployee().getLastName());
	        dto.setEmployeeCode(user.getEmployee().getEmployeeCode());
	    }

	    if (userRole != null) {
	        dto.setRoleIds(userRole.stream()
	                .map(ur -> ur.getRole().getRoleId())
	                .collect(Collectors.toSet()));
	        dto.setRoleNames(userRole.stream()
	                .map(ur -> ur.getRole().getRoleName())
	                .collect(Collectors.toSet()));
	    }

	    if (userDepartment != null) {
	        dto.setDepartmentIds(userDepartment.stream()
	                .map(ud -> ud.getDepartment() != null ? ud.getDepartment().getDepartmentId() : null)
	                .filter(Objects::nonNull)
	                .collect(Collectors.toSet()));

	        dto.setDepartmentNames(userDepartment.stream()
	                .map(ud -> ud.getDepartment() != null ? ud.getDepartment().getDepartmentName() : null)
	                .filter(Objects::nonNull)
	                .collect(Collectors.toSet()));
	    }
	    
	    dto.setIsActive(user.getIsActive());

	    return dto;
	}
	
	public static User toEntity(UserDto dto, Set<Role> roles, Set<Department> departments) {
	    if (dto == null) return null;

	    User user = new User();
	    if (dto.getUserId() != null) {
	        user.setUserId(dto.getUserId());
	    }
	    user.setUserName(dto.getUserName());

	    if (dto.getEmployeeId() != null) {
	        Employee employee = new Employee();
	        employee.setEmployeeId(dto.getEmployeeId());
	        employee.setEmployeeCode(dto.getEmployeeCode());
	        String[] nameParts = dto.getEmployeeName().split(" ");
	        if (nameParts.length >= 2) {
	            employee.setFirstName(nameParts[0]);
	            employee.setLastName(nameParts[1]);
	        }
	        user.setEmployee(employee);
	    }

	    if (dto.getRoleIds() != null && !dto.getRoleIds().isEmpty()) {
	        Set<UserRole> userRoles = dto.getRoleIds().stream()
	                .map(roleId -> {
	                    Role role = roles.stream()
	                            .filter(r -> r.getRoleId().equals(roleId))
	                            .findFirst()
	                            .orElseThrow(() -> new IllegalArgumentException("Role not found for ID: " + roleId));

	                    UserRole userRole = new UserRole();
	                    userRole.setRole(role);
	                    userRole.setUser(user);
	                    return userRole;
	                })
	                .collect(Collectors.toSet());

	        user.setUserRoles(userRoles);
	    }

	    if (dto.getDepartmentIds() != null && !dto.getDepartmentIds().isEmpty()) {
	        Set<UserDepartment> userDepartments = dto.getDepartmentIds().stream()
	                .map(departmentId -> {
	                    Department department = departments.stream()
	                            .filter(d -> d.getDepartmentId().equals(departmentId))
	                            .findFirst()
	                            .orElseThrow(() -> new IllegalArgumentException("Department not found for ID: " + departmentId));

	                    UserDepartment userDepartment = new UserDepartment();
	                    userDepartment.setDepartment(department);
	                    userDepartment.setUser(user);
	                    return userDepartment;
	                })
	                .collect(Collectors.toSet());

	        user.setUserDepartments(userDepartments);
	    }
	    
	    user.setIsActive(dto.getIsActive());

	    return user;
	}



}
