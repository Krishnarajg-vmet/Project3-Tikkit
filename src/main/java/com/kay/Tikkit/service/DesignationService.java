package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.DesignationDto;
import com.kay.Tikkit.entity.Designation;
import com.kay.Tikkit.mapper.DesignationMapper;
import com.kay.Tikkit.repositories.DesignationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DesignationService {
	
	@Autowired
	private DesignationRepository designationRespository;
	
	public DesignationDto createDesignation(DesignationDto dto) {
		Designation designation = DesignationMapper.toEntity(dto);
		designation.setIsActive(true);
		designation.setCreatedDt(LocalDateTime.now());
		
		return DesignationMapper.toDto(designationRespository.save(designation));
	}
	
	public DesignationDto getById(Long id){
		Optional<Designation> designation = designationRespository.findById(id);
		return designation.map(DesignationMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Designation not found"));
	}
	
	public DesignationDto updateDesignation(Long id, DesignationDto dto) {
		return designationRespository.findById(id).map(existing -> {
			existing.setDesignationName(dto.getDesignationName());
			existing.setIsActive(dto.getIsActive());
			existing.setModifiedDt(LocalDateTime.now());
			return DesignationMapper.toDto(designationRespository.save(existing));
		}).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public List<DesignationDto> getAllDesignation(){
		return designationRespository.findAll()
				.stream()
				.map(DesignationMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public void deleteDesignation(Long id) {
		designationRespository.findById(id).ifPresent(d -> {
			d.setIsActive(false);
			d.setModifiedDt(LocalDateTime.now());
			designationRespository.save(d);
		});
	}

}
