package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
	
	@GetMapping
	public List<BranchDto> getAllBranches(){
		return branchService.getAllBranch();
	}
	
	@PostMapping
	public BranchDto createBranch(BranchDto dto) {
		return branchService.createBranch(dto);
	}
	
	@GetMapping("/id")
	public ResponseEntity<BranchDto> findById(@PathVariable Long id) {
		BranchDto branch = branchService.getById(id);
		return branch !=null ? ResponseEntity.ok(branch) : ResponseEntity.noContent().build();
	}
	
	@PutMapping("/id")
	public ResponseEntity<BranchDto> updateBranch(@PathVariable Long id, @RequestBody BranchDto dto) {
		BranchDto branch = branchService.updateBranch(id, dto);
		return branch !=null ? ResponseEntity.ok(branch) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
		branchService.deleteBranch(id);
		return ResponseEntity.noContent().build();
	}

}
