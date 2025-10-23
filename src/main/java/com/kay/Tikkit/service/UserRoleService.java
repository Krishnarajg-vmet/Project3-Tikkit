package com.kay.Tikkit.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserRole;
import com.kay.Tikkit.repositories.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserRoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void assignRolesToUser(Long userId, Set<Long> roleIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Set<Role> roles = new HashSet<>(roleRepository.findAllById(roleIds));
        if (roles.isEmpty()) {
            throw new RuntimeException("No valid roles provided");
        }

        user.getUserRoles().clear();
        for (Role role : roles) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            user.getUserRoles().add(userRole);
        }

        userRepository.save(user);
    }

    public void removeRoleFromUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.getUserRoles().removeIf(ur -> ur.getRole().getRoleId().equals(roleId));
        userRepository.save(user);
    }
}
