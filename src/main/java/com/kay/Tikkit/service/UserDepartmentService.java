package com.kay.Tikkit.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.User;
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
        departments.forEach(user::addDepartment);

        userRepository.save(user);
    }

    public void removeDepartmentFromUser(Long userId, Long departmentId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Department dummyDept = new Department();
        dummyDept.setDepartmentId(departmentId);
        user.removeDepartment(dummyDept);

        userRepository.save(user);
    }
}

