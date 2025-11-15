package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.RoleDto;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.mapper.RoleMapper;
import com.kay.Tikkit.repositories.RoleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleDto createRole(RoleDto dto) {
		
		Role role = RoleMapper.toEntity(dto);
		role.setIsActive(true);
		role.setCreatedDt(LocalDateTime.now());
		return RoleMapper.toDto(roleRepository.save(role));
		
	}
	
	public RoleDto getRoleById(Long id) {
		Optional<Role> role = roleRepository.findById(id);
		return role.map(RoleMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
	}
	
	public RoleDto updateRole(Long id, RoleDto dto) {
	    return roleRepository.findById(id)
	        .map(existingRole -> {
	            if (dto.getRoleName() != null)
	                existingRole.setRoleName(dto.getRoleName());

	            if (dto.getIsActive() != null)
	                existingRole.setIsActive(dto.getIsActive());

	            existingRole.setModifiedDt(LocalDateTime.now());
	            return RoleMapper.toDto(roleRepository.save(existingRole));
	        })
	        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
	}
	
	public List<RoleDto> getAllRole() {
		return roleRepository.findAll()
				.stream()
				.map(RoleMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteRole(Long id) {
		roleRepository.findById(id).ifPresent(r -> {
		r.setIsActive(false);
		r.setModifiedDt(LocalDateTime.now());
		roleRepository.save(r);
		});
	}

}
