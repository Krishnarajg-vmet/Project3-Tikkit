package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.EmployeeDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Designation;
import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.mapper.EmployeeMapper;
import com.kay.Tikkit.repositories.AreaRepository;
import com.kay.Tikkit.repositories.BranchRepository;
import com.kay.Tikkit.repositories.DepartmentRepository;
import com.kay.Tikkit.repositories.DesignationRepository;
import com.kay.Tikkit.repositories.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private DepartmentRepository departmentrepository;
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	public EmployeeDto createEmployee(EmployeeDto dto) {
		 if (dto.getBranchId() == null) {
		        throw new IllegalArgumentException("Branch ID must not be null");
		    }
		    if (dto.getDepartmentId() == null) {
		        throw new IllegalArgumentException("Department ID must not be null");
		    }
		    if (dto.getDesignationId() == null) {
		        throw new IllegalArgumentException("Designation ID must not be null");
		    }
		    if (dto.getAreaId() == null) {
		        throw new IllegalArgumentException("Area ID must not be null");
		    }
		Branch branch = branchRepository.findById(dto.getBranchId()).orElseThrow(() -> new EntityNotFoundException("Branch not found"));
		Department department = departmentrepository.findById(dto.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found"));
		Designation designation = designationRepository.findById(dto.getDesignationId()).orElseThrow(() -> new EntityNotFoundException("Designation not found"));
		Area area = areaRepository.findById(dto.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area not found"));
		
		Employee employee = EmployeeMapper.toEntity(dto, branch, department, designation, area);
		employee.setIsActive(true);
		employee.setCreatedDt(LocalDateTime.now());
				
		return EmployeeMapper.toDto(employeeRepository.save(employee));
	}
	
	public EmployeeDto getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.map(EmployeeMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
	}
	
	public EmployeeDto updateEmployee(EmployeeDto dto, Long id) {
		return employeeRepository.findById(id).map(existing -> {
			Branch branch = branchRepository.findById(dto.getBranchId()).orElseThrow(() -> new EntityNotFoundException("Branch not found"));
			Department department = departmentrepository.findById(dto.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found"));
			Designation designation = designationRepository.findById(dto.getDesignationId()).orElseThrow(() -> new EntityNotFoundException("Designation not found"));
			Area area = areaRepository.findById(dto.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area not found"));
			existing.setModifiedDt(LocalDateTime.now());
			existing.setIsActive(dto.getIsActive());
			EmployeeMapper.updateEntity(existing, dto, branch, department, designation, area);
			return EmployeeMapper.toDto(employeeRepository.save(existing));
		}).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
	}
	
	public List<EmployeeDto> getAllEmployee(){
		return employeeRepository.findAll()
				.stream()
				.map(EmployeeMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).ifPresent(e -> {
			e.setIsActive(false);
			e.setModifiedDt(LocalDateTime.now());
			employeeRepository.save(e);
		});
	}

}
