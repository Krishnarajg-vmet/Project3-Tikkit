package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.BranchDto;
import com.kay.Tikkit.service.BranchService;

@RestController
@RequestMapping("/api/branches")
public class BranchRestController {
	
	private final BranchService branchService;
	
	public BranchRestController(BranchService branchService) {
		this.branchService = branchService;
	}
	
	@PreAuthorize("hasAuthority('READ_BRANCH')")
	@GetMapping
	public List<BranchDto> getAllBranches(){
		return branchService.getAllBranch();
	}
	
	@PreAuthorize("hasAuthority('CREATE_BRANCH')")
	@PostMapping
	public BranchDto createBranch(@RequestBody BranchDto dto) {
		return branchService.createBranch(dto);
	}
	
	@PreAuthorize("hasAuthority('READ_BRANCH')")
	@GetMapping("/{id}")
	public ResponseEntity<BranchDto> findById(@PathVariable Long id) {
		BranchDto branch = branchService.getById(id);
		return branch !=null ? ResponseEntity.ok(branch) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('UPDATE_BRANCH')")
	@PutMapping("/{id}")
	public ResponseEntity<BranchDto> updateBranch(@PathVariable Long id, @RequestBody BranchDto dto) {
		BranchDto branch = branchService.updateBranch(id, dto);
		return branch !=null ? ResponseEntity.ok(branch) : ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('DELETE_BRANCH')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
		branchService.deleteBranch(id);
		return ResponseEntity.noContent().build();
	}

}
