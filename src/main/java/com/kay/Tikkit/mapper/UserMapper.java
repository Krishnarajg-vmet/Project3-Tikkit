package com.kay.Tikkit.mapper;

import java.time.LocalDateTime;

import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;

public class UserMapper {

	public static UserDto toDto(User user) {
		if(user == null) return null;
		
		UserDto dto = new UserDto();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		
		if(user.getEmployee() != null) {
			dto.setEmployeeId(user.getEmployee().getEmployeeId());
			dto.setFirstName(user.getEmployee().getFirstName());
			dto.setLastName(user.getEmployee().getLastName());
		}
		
		if(user.getRole() != null) {
			dto.setRoleId(user.getRole().getRoleId());
			dto.setRoleName(user.getRole().getRoleName());
		}
		
		if(user.getDepartment() != null) {
			dto.setDepartmentId(user.getDepartment().getDepartmentId());
			dto.setDepartmentName(user.getDepartment().getDepartmentName());
		}
		
		dto.setIsActive(user.getIsActive());
		dto.setCreatedDt(user.getCreatedDt());
		dto.setModifiedDt(user.getModifiedDt());
		
		return dto;
		
	}
	
	public static User toEntity(UserDto dto, Employee employee, Role role, Department department, String encodedPassword) {
		if(dto == null) return null;
		
		User user = new User();
		if(dto.getUserId() != null && dto.getUserId() >0) {
			user.setUserId(dto.getUserId());
		}
		
		user.setUserName(dto.getUserName());
		user.setPassword(encodedPassword);
		user.setPasswordResetRequired(true);
		user.setRole(role);
		user.setEmployee(employee);
		user.setDepartment(department);
		user.setIsActive(true);
		user.setCreatedDt(LocalDateTime.now());
		
		return user;
	}
	
	public static User updateUser(UserDto dto, Employee employee, Role role, Department department) {
		
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setEmployee(employee);
		user.setRole(role);
		user.setDepartment(department);
		user.setIsActive(dto.getIsActive());
		user.setModifiedDt(LocalDateTime.now());
		
		return user;
	}
	
	public static User updatePassword(User user, String encodedPassword) {
        if (user == null) return null;

        user.setPassword(encodedPassword);
        user.setPasswordResetRequired(false);
        user.setModifiedDt(LocalDateTime.now());

        return user;
    }
}
