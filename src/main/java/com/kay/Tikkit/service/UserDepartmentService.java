package com.kay.Tikkit.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserDepartment;
import com.kay.Tikkit.repositories.DepartmentRepository;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserDepartmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void assignDepartmentsToUser(Long userId, Set<Long> departmentIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Set<Department> departments = new HashSet<>(departmentRepository.findAllById(departmentIds));

        user.getUserDepartments().clear();
        for (Department dept : departments) {
            UserDepartment userDept = new UserDepartment();
            userDept.setUser(user);
            userDept.setDepartment(dept);
            user.getUserDepartments().add(userDept);
        }

        userRepository.save(user);
    }

    public void removeDepartmentFromUser(Long userId, Long departmentId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.getUserDepartments().removeIf(ud -> ud.getDepartment().getDepartmentId().equals(departmentId));
        userRepository.save(user);
    }
}

