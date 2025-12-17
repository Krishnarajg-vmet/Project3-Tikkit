package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAuthority('READ_COMPANY')")
	@GetMapping
	public List<CompanyDto> getAllCompany(){
		return companyService.getAllActiveCompany();
	}
	
	@PreAuthorize("hasAuthority('CREATE_COMPANY')")
	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto dto) {
		return companyService.createCompany(dto);
	}
	
	@PreAuthorize("hasAuthority('READ_COMPANY')")
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> findById(@PathVariable Long id) {
		CompanyDto company =  companyService.getById(id);
		return company !=null ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasAuthority('UPDATE_COMPANY')")
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @RequestBody CompanyDto dto) {
		CompanyDto updated = companyService.updateCompany(id, dto);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasAuthority('DELETE_COMPANY')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return ResponseEntity.noContent().build();
	}

}
