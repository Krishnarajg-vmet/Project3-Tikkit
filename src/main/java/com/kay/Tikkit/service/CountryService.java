package com.kay.Tikkit.service;

import com.kay.Tikkit.dto.CountryDto;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.mapper.CountryMapper;
import com.kay.Tikkit.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryDto createCountry(CountryDto dto) {
        Country country = CountryMapper.toEntity(dto);
        country.setIsActive(true);
        return CountryMapper.toDto(countryRepository.save(country));
    }

    public List<CountryDto> getAllActiveCountries() {
        return countryRepository.findByIsActiveTrue()
                .stream()
                .map(CountryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CountryDto getById(Long id) {
        Optional<Country> optional = countryRepository.findById(id);
        return optional.map(CountryMapper::toDto).orElse(null);
    }

    public CountryDto updateCountry(Long id, CountryDto dto) {
        Optional<Country> optional = countryRepository.findById(id);
        if (optional.isPresent()) {
            Country country = optional.get();
            country.setCountryName(dto.getCountryName());
            country.setNationality(dto.getNationality());
            country.setIsActive(dto.getIsActive());
            return CountryMapper.toDto(countryRepository.save(country));
        }
        return null;
    }

    public void deleteCountry(Long id) {
        countryRepository.findById(id).ifPresent(country -> {
            country.setIsActive(false);
            countryRepository.save(country);
        });
    }
}
