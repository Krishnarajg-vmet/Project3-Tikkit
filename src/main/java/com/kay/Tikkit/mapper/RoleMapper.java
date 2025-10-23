package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.RoleDto;
import com.kay.Tikkit.entity.Role;

public class RoleMapper {
	
	public static RoleDto toDto(Role role) {
		if(role == null) return null;
		
		RoleDto dto = new RoleDto();
		dto.setRoleId(role.getRoleId());
		dto.setRoleName(role.getRoleName());
		dto.setIsActive(role.getIsActive());
		
		return dto;
		
	}
	
	public static Role toEntity(RoleDto dto) {
		if(dto==null) return null;
		
		Role role = new Role();
		role.setRoleName(dto.getRoleName());
		role.setIsActive(role.getIsActive());
		
		return role;
	}

}
