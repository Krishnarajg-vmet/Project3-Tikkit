package com.kay.Tikkit.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
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
        roles.forEach(user::addRole);

        userRepository.save(user);
    }

    public void removeRoleFromUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Role dummyRole = new Role();
        dummyRole.setRoleId(roleId);
        user.removeRole(dummyRole);

        userRepository.save(user);
    }
}
