package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.CityMapper;
import com.kay.Tikkit.repositories.*;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public CityDto createCity(CityDto dto) {
        Country country = countryRepository.findById(dto.getCountryId()).orElseThrow();
        State state = stateRepository.findById(dto.getStateId()).orElseThrow();
        District district = districtRepository.findById(dto.getDistrictId()).orElseThrow();

        City city = CityMapper.toEntity(dto, country, state, district);
        city.setIsActive(true);
        return CityMapper.toDto(cityRepository.save(city));
    }

    public List<CityDto> getAllActiveCities() {
        return cityRepository.findByIsActiveTrue()
                .stream()
                .map(CityMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteCity(Long id) {
        cityRepository.findById(id).ifPresent(city -> {
            city.setIsActive(false);
            cityRepository.save(city);
        });
    }

	public CityDto updateCity(Long id, CityDto dto) {
		
		return cityRepository.findById(id).map(existing->{
			Country country = countryRepository.findById(dto.getCountryId()).orElseThrow();
	        State state = stateRepository.findById(dto.getStateId()).orElseThrow();
	        District district = districtRepository.findById(dto.getDistrictId()).orElseThrow();
	        existing.setCityName(dto.getCityName());
	        existing.setCountry(country);
	        existing.setState(state);
	        existing.setDistrict(district);
	        existing.setIsActive(dto.getIsActive());
			return CityMapper.toDto(cityRepository.save(existing));
		}).orElse(null);
	}
	
	public CityDto getbyId(Long id) {
		Optional<City> optional = cityRepository.findById(id);
		return optional.map(CityMapper::toDto).orElse(null);
	}
}
