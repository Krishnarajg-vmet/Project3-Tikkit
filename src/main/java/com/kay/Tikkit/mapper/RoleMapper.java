package com.kay.Tikkit.mapper;

import java.util.stream.Collectors;

import com.kay.Tikkit.dto.PermissionDto;
import com.kay.Tikkit.dto.RoleDto;
import com.kay.Tikkit.entity.Role;

public class RoleMapper {
	
	public static RoleDto toDto(Role role) {
        if (role == null) return null;

        RoleDto dto = new RoleDto();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        dto.setIsActive(role.getIsActive());
        dto.setCreatedDt(role.getCreatedDt());
        dto.setModifiedDt(role.getModifiedDt());

        if (role.getPermissions() != null && !role.getPermissions().isEmpty()) {
            dto.setPermissions(
                role.getPermissions()
                    .stream()
                    .map(permission -> {
                        PermissionDto pDto = new PermissionDto();
                        pDto.setPermissionId(permission.getPermissionId());
                        pDto.setPermissionName(permission.getPermissionName());
                        pDto.setDescription(permission.getDescription());
                        pDto.setIsActive(permission.getIsActive());
                        pDto.setCreatedDt(permission.getCreatedDt());
                        pDto.setModifiedDt(permission.getModifiedDt());
                        return pDto;
                    })
                    .collect(Collectors.toSet())
            );
        }

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
