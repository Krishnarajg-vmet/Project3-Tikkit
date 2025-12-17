package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAuthority('READ_ROLE')")
	@GetMapping
	public List<RoleDto> getAllRoles() {
		return roleService.getAllRole();
	}
	
	@PreAuthorize("hasAuthority('CREATE_ROLE')")
	@PostMapping
	public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto dto) {
		RoleDto created = roleService.createRole(dto);
		return ResponseEntity.ok(created);
	}
	
	@PreAuthorize("hasAuthority('READ_ROLE')")
	@GetMapping("/{id}")
	public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
		RoleDto role = roleService.getRoleById(id);
		return role != null ? ResponseEntity.ok(role) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('UPDATE_ROLE')")
	@PutMapping("/{id}")
	public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @RequestBody RoleDto dto) {
		RoleDto updated = roleService.updateRole(id, dto);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('DELETE_ROLE')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
		roleService.deleteRole(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('ASSIGN_PERMISSION_TO_ROLE')")
	@PostMapping("/{roleId}/permissions/{permissionId}")
    public ResponseEntity<RoleDto> addPermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        RoleDto updatedRole = roleService.addPermissionToRole(roleId, permissionId);
        return ResponseEntity.ok(updatedRole);
    }

	@PreAuthorize("hasAuthority('ASSIGN_PERMISSION_TO_ROLE')")
    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    public ResponseEntity<RoleDto> removePermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        RoleDto updatedRole = roleService.removePermissionFromRole(roleId, permissionId);
        return ResponseEntity.ok(updatedRole);
    }
	
}
