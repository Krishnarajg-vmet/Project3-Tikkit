package com.kay.Tikkit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.PermissionDto;
import com.kay.Tikkit.service.PermissionService;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PreAuthorize("hasAuthority('READ_PERMISSION')")
    @GetMapping
    public List<PermissionDto> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @PreAuthorize("hasAuthority('READ_PERMISSION')")
    @GetMapping("/{id}")
    public PermissionDto getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_PERMISSION')")
    @PostMapping
    public PermissionDto createPermission(@RequestBody PermissionDto dto) {
        return permissionService.createPermission(dto);
    }

    @PreAuthorize("hasAuthority('UPDATE_PERMISSION')")
    @PutMapping("/{id}")
    public PermissionDto updatePermission(@PathVariable Long id, @RequestBody PermissionDto dto) {
        return permissionService.updatePermission(id, dto);
    }

    @PreAuthorize("hasAuthority('DELETE_PERMISSION')")
    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
    }
}
