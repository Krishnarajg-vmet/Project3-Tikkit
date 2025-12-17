package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.PermissionDto;
import com.kay.Tikkit.entity.Permission;
import com.kay.Tikkit.mapper.PermissionMapper;
import com.kay.Tikkit.repositories.PermissionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    
    @Autowired
    private PermissionMapper permissionMapper;

    public PermissionDto createPermission(PermissionDto dto) {
        Permission permission = permissionMapper.toEntity(dto);
        permission.setIsActive(true);  // Set as active by default
        permission.setCreatedDt(LocalDateTime.now());
        return permissionMapper.toDto(permissionRepository.save(permission));
    }

    public PermissionDto getPermissionById(Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        return permission.map(permissionMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
    }

    public PermissionDto updatePermission(Long id, PermissionDto dto) {
        return permissionRepository.findById(id)
            .map(existingPermission -> {
                if (dto.getPermissionName() != null)
                    existingPermission.setPermissionName(dto.getPermissionName());
                if (dto.getDescription() != null)
                    existingPermission.setDescription(dto.getDescription());
                if (dto.getIsActive() != null)
                    existingPermission.setIsActive(dto.getIsActive());
                
                existingPermission.setModifiedDt(LocalDateTime.now());
                return permissionMapper.toDto(permissionRepository.save(existingPermission));
            })
            .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
    }

    public List<PermissionDto> getAllPermissions() {
        return permissionRepository.findAll()
                .stream()
                .map(permissionMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deletePermission(Long id) {
        permissionRepository.findById(id).ifPresent(permission -> {
            permission.setIsActive(false);  // Deactivate instead of delete
            permission.setModifiedDt(LocalDateTime.now());
            permissionRepository.save(permission);
        });
    }
}
