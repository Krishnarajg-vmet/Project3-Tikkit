package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
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
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public UserDto createUser(UserDto dto) {
		System.out.println("Received DTO: " + dto.getEmployeeId() + " "+ dto.getUserName());
		if(dto.getEmployeeId() == null) {
			throw new IllegalArgumentException("Employee ID must not be null");
		}
		if(dto.getRoleId() == null) {
			throw new IllegalArgumentException("Role ID must not be null");
		}
		if(dto.getDepartmentId() == null) {
		        throw new IllegalArgumentException("Department ID must not be null");
		    }
		
		Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new EntityNotFoundException("Role not found"));
		Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found"));
		
		User user = UserMapper.toEntity(dto, employee, role, department);
		user.setIsActive(true);
		
		return UserMapper.toDto(userRepository.save(user));
	}
	
	public UserDto editUser(UserDto dto, Long id) {
		return userRepository.findById(id).map(existing -> {
			Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
			Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new EntityNotFoundException("Role not found"));
			Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found"));
			UserMapper.updateUser(dto, employee, role, department);
			existing.setUserName(dto.getUserName());
	        existing.setEmployee(employee);
	        existing.setRole(role);
	        existing.setDepartment(department);
	        existing.setIsActive(dto.getIsActive());
	        existing.setModifiedDt(LocalDateTime.now());
			return UserMapper.toDto(userRepository.save(existing));
		}).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
	
	public UserDto getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(UserMapper::toDto).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
	
	public List<UserDto> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(UserMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteUser(Long id) {
		userRepository.findById(id).ifPresent(u -> {
			u.setIsActive(false);
			u.setModifiedDt(LocalDateTime.now());
			userRepository.save(u);
		});
	}

}
