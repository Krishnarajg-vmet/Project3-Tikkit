package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.CompanyDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Company;
import com.kay.Tikkit.mapper.CompanyMapper;
import com.kay.Tikkit.repositories.AreaRepository;
import com.kay.Tikkit.repositories.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Transactional
	public CompanyDto createCompany(CompanyDto dto) {
		
		Area area = areaRepository.findById(dto.getAreaId())
		        .orElseThrow(() -> new EntityNotFoundException("Area Not Found"));
		
		Company company = CompanyMapper.toEntity(dto, area);
		company.setIsActive(true);
		return CompanyMapper.toDto(companyRepository.save(company));
		
	}
	
	public CompanyDto getById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.map(CompanyMapper::toDto).orElse(null);
	}
	
	public CompanyDto updateCompany (Long id, CompanyDto dto) {
		return companyRepository.findById(id).map(existing ->{
			Area area = areaRepository.findById(dto.getAreaId()).orElseThrow(()-> new EntityNotFoundException("Area not Found"));
			existing.setArea(area);
			existing.setCompanyName(dto.getCompanyName());
			existing.setIsActive(dto.getIsActive());
			return CompanyMapper.toDto(companyRepository.save(existing));
		}).orElse(null);
	}
	
	public List<CompanyDto> getAllActiveCompany(){
		return companyRepository.findByIsActiveTrue()
				.stream()
				.map(CompanyMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteCompany(Long id) {
		companyRepository.findById(id).ifPresent(c ->{
			c.setIsActive(false);
			companyRepository.save(c);
		});
	}

}
