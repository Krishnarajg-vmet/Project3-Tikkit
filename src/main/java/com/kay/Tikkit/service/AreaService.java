package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.AreaDto;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.AreaMapper;
import com.kay.Tikkit.repositories.*;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CityRepository cityRepository;

    public AreaDto createArea(AreaDto dto) {
        City city = cityRepository.findById(dto.getCityId()).orElseThrow();
        District district = city.getDistrict();
        Country country = city.getCountry();
        State state = city.getState();

        Area area = AreaMapper.toEntity(dto, country, state, district, city);
        area.setIsActive(true);
        return AreaMapper.toDto(areaRepository.save(area));
    }

    public List<AreaDto> getAllActiveAreas() {
        return areaRepository.findByIsActiveTrue()
                .stream()
                .map(AreaMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteArea(Long id) {
        areaRepository.findById(id).ifPresent(area -> {
            area.setIsActive(false);
            areaRepository.save(area);
        });
    }

	public AreaDto updateArea(Long id, AreaDto dto) {
		
		return areaRepository.findById(id).map(existing->{
	        City city = cityRepository.findById(dto.getCityId()).orElseThrow();
			District district = city.getDistrict();
			Country country = city.getCountry();
			State state = city.getState();
	        existing.setAreaName(dto.getAreaName());
	        existing.setPincode(dto.getPincode());
	        existing.setCountry(country);
	        existing.setState(state);
	        existing.setDistrict(district);
	        existing.setCity(city);
	        existing.setIsActive(dto.getIsActive());
	        return AreaMapper.toDto(areaRepository.save(existing));
		}).orElse(null);
	}
	
	public AreaDto getById(Long id) {
		Optional<Area> optional = areaRepository.findById(id);
		return optional.map(AreaMapper::toDto).orElse(null);
	}
}

