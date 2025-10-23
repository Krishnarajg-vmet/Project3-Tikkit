package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserDepartment;
import com.kay.Tikkit.entity.UserRole;
import com.kay.Tikkit.mapper.UserMapper;
import com.kay.Tikkit.repositories.DepartmentRepository;
import com.kay.Tikkit.repositories.EmployeeRepository;
import com.kay.Tikkit.repositories.RoleRepository;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public UserDto createUser(UserDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID " + dto.getEmployeeId()));

        if (userRepository.existsByUserName(dto.getUserName())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmployeeEmployeeCode(dto.getEmployeeCode())) {
            throw new RuntimeException("This employee already has a username");
        }

        Set<Role> roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
        if (roles.isEmpty()) {
            throw new RuntimeException("At least one valid role must be provided");
        }

        Set<Department> departments = new HashSet<>(departmentRepository.findAllById(dto.getDepartmentIds()));

        dto.setCreatedDt(LocalDateTime.now());
        dto.setIsActive(true);

        User user = UserMapper.toEntity(dto, roles, departments);
        user.setCreatedDt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return UserMapper.toDto(savedUser, savedUser.getUserRoles(), savedUser.getUserDepartments());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the userID " + id));
        return UserMapper.toDto(user, user.getUserRoles(), user.getUserDepartments());
    }

    public UserDto updateUser(Long id, UserDto dto) {
        return userRepository.findById(id).map(existing -> {

            Set<Role> roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
            if (roles.isEmpty()) {
                throw new RuntimeException("At least one valid role must be provided");
            }

            Set<Department> departments = new HashSet<>(departmentRepository.findAllById(dto.getDepartmentIds()));

            existing.setUserName(dto.getUserName());
            existing.setIsActive(dto.getIsActive());
            existing.setModifiedDt(LocalDateTime.now());

            existing.getUserRoles().clear();
            for (Role role : roles) {
                UserRole userRole = new UserRole();
                userRole.setUser(existing);
                userRole.setRole(role);
                existing.getUserRoles().add(userRole);
            }

            existing.getUserDepartments().clear();
            for (Department dept : departments) {
                UserDepartment userDept = new UserDepartment();
                userDept.setUser(existing);
                userDept.setDepartment(dept);
                existing.getUserDepartments().add(userDept);
            }

            User updated = userRepository.save(existing);
            return UserMapper.toDto(updated, updated.getUserRoles(), updated.getUserDepartments());

        }).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
    
    public List<UserDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserMapper.toDto(user, user.getUserRoles(), user.getUserDepartments()))
                .collect(Collectors.toList());
    }
    
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the userID " + userId));
        
        user.setIsActive(false);
        user.setModifiedDt(LocalDateTime.now());
        userRepository.save(user);
    }
    
}
