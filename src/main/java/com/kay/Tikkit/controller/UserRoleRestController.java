package com.kay.Tikkit.controller;

import com.kay.Tikkit.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleRestController {

    private final UserRoleService userRoleService;

    public UserRoleRestController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<Void> assignRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
        userRoleService.assignRolesToUser(userId, roleIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{userId}/{roleId}")
    public ResponseEntity<Void> removeRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userRoleService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.noContent().build();
    }
}
