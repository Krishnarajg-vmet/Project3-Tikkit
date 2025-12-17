package com.kay.Tikkit.mapper;

import org.springframework.stereotype.Component;

import com.kay.Tikkit.dto.PermissionDto;
import com.kay.Tikkit.entity.Permission;

@Component
public class PermissionMapper {

    public PermissionDto toDto(Permission permission) {
        if (permission == null) return null;

        PermissionDto dto = new PermissionDto();
        dto.setPermissionId(permission.getPermissionId());
        dto.setPermissionName(permission.getPermissionName());
        dto.setDescription(permission.getDescription());
        dto.setIsActive(permission.getIsActive());  // Active status
        dto.setCreatedDt(permission.getCreatedDt());  // Created timestamp
        dto.setModifiedDt(permission.getModifiedDt());  // Modified timestamp
        return dto;
    }

    public Permission toEntity(PermissionDto dto) {
        if (dto == null) return null;

        Permission permission = new Permission();
        permission.setPermissionName(dto.getPermissionName());
        permission.setDescription(dto.getDescription());
        permission.setIsActive(dto.getIsActive());
        permission.setCreatedDt(dto.getCreatedDt());
        permission.setModifiedDt(dto.getModifiedDt());
        return permission;
    }
}
