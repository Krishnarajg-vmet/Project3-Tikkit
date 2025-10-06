package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
	
	@GetMapping
	public List<DepartmentDto> getAllDepartments(){
		return departmentService.getAllDepartment();
	}
	
	@PostMapping
	public DepartmentDto createDepartment(@RequestBody DepartmentDto dto) {
		return departmentService.createDepartment(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> findById(@PathVariable Long id) {
		DepartmentDto department = departmentService.getById(id);
		return department !=null ? ResponseEntity.ok(department) : ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto dto) {
		DepartmentDto department = departmentService.updateDepartment(dto, id);
		return department != null ? ResponseEntity.ok(department) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}

}
