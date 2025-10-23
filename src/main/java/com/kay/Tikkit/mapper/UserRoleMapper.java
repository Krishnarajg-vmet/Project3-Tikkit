package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.UserRoleDto;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserRole;

public class UserRoleMapper {
	
	public static UserRoleDto toDto(UserRole userRole) {
		if(userRole == null) return null;
		
		UserRoleDto dto = new UserRoleDto();
		dto.setUserRoleId(userRole.getUserRoleId());
		dto.setUserId(userRole.getUser().getUserId());
		dto.setUserName(userRole.getUser().getUserName());
		dto.setRoleId(userRole.getRole().getRoleId());
		dto.setRoleName(userRole.getRole().getRoleName());
		dto.setIsActive(userRole.getIsActive());
		
		return dto;
	}

	public static UserRole toEntity(UserRoleDto dto, Role role, User user) {
		if(dto == null) return null;
		
		UserRole userRole = new UserRole();
		if(role == null ) {
			throw new IllegalArgumentException("Role cannot be null");
		}
		
		if(user == null ) {
			throw new IllegalArgumentException("User cannot be null");
		}
		userRole.setRole(role);
		userRole.setUser(user);
		userRole.setIsActive(dto.getIsActive());
		
		return userRole;
	}
}
