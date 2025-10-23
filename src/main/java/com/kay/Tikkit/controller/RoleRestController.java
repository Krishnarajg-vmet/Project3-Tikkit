package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.RoleDto;
import com.kay.Tikkit.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

	private final RoleService roleService;
	
	public RoleRestController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping
	public List<RoleDto> getAllRoles() {
		return roleService.getAllRole();
	}
	
	@PostMapping
	public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto dto) {
		RoleDto created = roleService.createRole(dto);
		return ResponseEntity.ok(created);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
		RoleDto role = roleService.getRoleById(id);
		return role != null ? ResponseEntity.ok(role) : ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @RequestBody RoleDto dto) {
		RoleDto updated = roleService.updateRole(id, dto);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
		roleService.deleteRole(id);
		return ResponseEntity.noContent().build();
	}
	
}
