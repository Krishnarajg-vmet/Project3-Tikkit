package com.kay.Tikkit.controller;

import com.kay.Tikkit.service.UserDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/user-departments")
public class UserDepartmentRestController {

    private final UserDepartmentService userDepartmentService;

    public UserDepartmentRestController(UserDepartmentService userDepartmentService) {
        this.userDepartmentService = userDepartmentService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<Void> assignDepartments(@PathVariable Long userId, @RequestBody Set<Long> departmentIds) {
        userDepartmentService.assignDepartmentsToUser(userId, departmentIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{userId}/{departmentId}")
    public ResponseEntity<Void> removeDepartment(@PathVariable Long userId, @PathVariable Long departmentId) {
        userDepartmentService.removeDepartmentFromUser(userId, departmentId);
        return ResponseEntity.noContent().build();
    }
}
