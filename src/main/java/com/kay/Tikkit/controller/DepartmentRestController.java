package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.DepartmentDto;
import com.kay.Tikkit.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {
	
	private final DepartmentService departmentService;
	
	public DepartmentRestController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@PreAuthorize("hasAuthority('READ_DEPARTMENT')")
	@GetMapping
	public List<DepartmentDto> getAllDepartments(){
		return departmentService.getAllDepartment();
	}
	
	@PreAuthorize("hasAuthority('CREATE_DEPARTMENT')")
	@PostMapping
	public DepartmentDto createDepartment(@RequestBody DepartmentDto dto) {
		return departmentService.createDepartment(dto);
	}
	
	@PreAuthorize("hasAuthority('READ_DEPARTMENT')")
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> findById(@PathVariable Long id) {
		DepartmentDto department = departmentService.getById(id);
		return department !=null ? ResponseEntity.ok(department) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('UPDATE_DEPARTMENT')")
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto dto) {
		DepartmentDto department = departmentService.updateDepartment(dto, id);
		return department != null ? ResponseEntity.ok(department) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('DELETE_DEPARTMENT')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}

}
