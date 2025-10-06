package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.DesignationDto;
import com.kay.Tikkit.service.DesignationService;


@RestController
@RequestMapping("/api/designations")
public class DesignationRestController {
	
	private final DesignationService designationService;
	
	public DesignationRestController (DesignationService designationService) {
		this.designationService = designationService;
	}
	
	@GetMapping
	public List<DesignationDto> getAllDesignation(){
		return designationService.getAllDesignation();
	}
	
	@PostMapping
	public DesignationDto createDesignation(@RequestBody DesignationDto dto) {
		return designationService.createDesignation(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DesignationDto> findById(@PathVariable Long id) {
		DesignationDto designation = designationService.getById(id);
		return designation != null ? ResponseEntity.ok(designation) : ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DesignationDto> updateDesignation(@PathVariable Long id, @RequestBody DesignationDto dto) {
		DesignationDto designation = designationService.updateDesignation(id, dto);
		return designation != null ? ResponseEntity.ok(designation) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
		designationService.deleteDesignation(id);
		return ResponseEntity.noContent().build();
	}

}
