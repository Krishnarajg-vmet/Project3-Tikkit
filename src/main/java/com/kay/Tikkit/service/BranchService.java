package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.BranchDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Company;
import com.kay.Tikkit.mapper.BranchMapper;
import com.kay.Tikkit.repositories.AreaRepository;
import com.kay.Tikkit.repositories.BranchRepository;
import com.kay.Tikkit.repositories.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	public BranchDto createBranch(BranchDto dto) {
		
		Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Company Not Found"));
		Area area = areaRepository.findById(dto.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area Not Found"));
		
		Branch branch = BranchMapper.toEntity(dto, company, area);
		branch.setIsActive(true);
		branch.setCreatedDt(null);
		return BranchMapper.toDto(branchRepository.save(branch));
	}
	
	public BranchDto getById(Long id) {
		Optional<Branch> branch = branchRepository.findById(id);
		return branch.map(BranchMapper::toDto).orElse(null);
	}
	
	public BranchDto updateBranch(Long id, BranchDto dto) {
		return branchRepository.findById(id).map(existing -> {
			Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Company Not Found"));
			Area area = areaRepository.findById(dto.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area Not Found"));
			existing.setCompany(company);
			existing.setArea(area);
			existing.setBranchName(dto.getBranchName());
			existing.setIsActive(dto.getIsActive());
			existing.setModifiedDt(null);
			return BranchMapper.toDto(branchRepository.save(existing));
		}).orElse(null);
	}
	
	public List<BranchDto> getAllBranch() {
		return branchRepository.findAll()
				.stream()
				.map(BranchMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteBranch(Long id) {
		branchRepository.findById(id).ifPresent(b -> {
			b.setIsActive(false);
			branchRepository.save(b);
		});
	}

}
