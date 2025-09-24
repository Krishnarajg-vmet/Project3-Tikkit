package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.*;
import com.kay.Tikkit.repositories.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    public DistrictDto createDistrict(DistrictDto dto) {
    	       
        State state = stateRepository.findById(dto.getStateId())
            .orElseThrow(() -> new EntityNotFoundException("State not found"));
        Country country = state.getCountry();
        
        District district = DistrictMapper.toEntity(dto, country, state);
        district.setIsActive(true);
        return DistrictMapper.toDto(districtRepository.save(district));
    }
    
    public DistrictDto getById(Long id) {
    	Optional<District> optional = districtRepository.findById(id);
    	return optional.map(DistrictMapper::toDto).orElse(null);
    }
    
    public DistrictDto updateDistrict(Long id, DistrictDto dto) {
    	return districtRepository.findById(id).map(existing -> {
            Country country = countryRepository.findById(dto.getCountryId()).orElseThrow();
            State state = stateRepository.findById(dto.getStateId()).orElseThrow();
            existing.setDistrictName(dto.getDistrictName());
            existing.setCountry(country);
            existing.setState(state);
            existing.setIsActive(dto.getIsActive());
            return DistrictMapper.toDto(districtRepository.save(existing));

    	}).orElse(null);
    }

    public List<DistrictDto> getAllActiveDistricts() {
        return districtRepository.findByIsActiveTrue()
                .stream()
                .map(DistrictMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteDistrict(Long id) {
        districtRepository.findById(id).ifPresent(d -> {
            d.setIsActive(false);
            districtRepository.save(d);
        });
    }

	public List<DistrictDto> getDistrictByStateId(Long stateId) {
        List<District> district = districtRepository.findByStateStateIdAndIsActiveTrue(stateId);
        return district.stream().map(DistrictMapper::toDto).collect(Collectors.toList());
    }
}

