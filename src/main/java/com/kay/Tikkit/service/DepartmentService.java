package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.DepartmentDto;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.mapper.DepartmentMapper;
import com.kay.Tikkit.repositories.BranchRepository;
import com.kay.Tikkit.repositories.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	public DepartmentDto createDepartment(DepartmentDto dto) {
		Branch branch = branchRepository.findById(dto.getBranchId()).orElseThrow(() -> new EntityNotFoundException("Branch not found"));
		Department department = DepartmentMapper.toEntity(dto, branch);
		department.setIsActive(true);
		department.setCreatedDt(LocalDateTime.now());
		return DepartmentMapper.toDto(departmentRepository.save(department));
	}
	
	public DepartmentDto getById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department.map(DepartmentMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Department not found"));
	}
	
	public DepartmentDto updateDepartment(DepartmentDto dto, Long id) {
		return departmentRepository.findById(id).map(existing -> {
			Branch branch = branchRepository.findById(dto.getBranchId()).orElseThrow(() -> new EntityNotFoundException("Branch not found"));
			existing.setBranch(branch);
			existing.setDepartmentCode(dto.getDepartmentCode());
			existing.setDepartmentName(dto.getDepartmentName());
			existing.setIsActive(dto.getIsActive());
			existing.setModifiedDt(LocalDateTime.now());
			return DepartmentMapper.toDto(departmentRepository.save(existing));
		}).orElseThrow(() -> new EntityNotFoundException("Department not found"));
	}
	
	public List<DepartmentDto> getAllDepartment(){
		return departmentRepository.findAll()
				.stream()
				.map(DepartmentMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteDepartment(Long id) {
		departmentRepository.findById(id).ifPresent(d -> {
			d.setIsActive(false);
			d.setModifiedDt(LocalDateTime.now());
			departmentRepository.save(d);
		});
	}

}
