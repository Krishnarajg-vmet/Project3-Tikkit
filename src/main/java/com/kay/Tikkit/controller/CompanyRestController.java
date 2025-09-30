package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.CompanyDto;
import com.kay.Tikkit.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {
	
	private final CompanyService companyService;
	
	public CompanyRestController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	public List<CompanyDto> getAllCompany(){
		return companyService.getAllActiveCompany();
	}
	
	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto dto) {
		return companyService.createCompany(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> findById(@PathVariable Long id) {
		CompanyDto company =  companyService.getById(id);
		return company !=null ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @RequestBody CompanyDto dto) {
		CompanyDto updated = companyService.updateCompany(id, dto);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return ResponseEntity.noContent().build();
	}

}
