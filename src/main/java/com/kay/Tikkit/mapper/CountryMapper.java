package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.CountryDto;
import com.kay.Tikkit.entity.Country;

public class CountryMapper {
	
	public static CountryDto toDto(Country country) {
		if(country == null) return null;
		
		CountryDto dto = new CountryDto();
		dto.setCountryId(country.getCountryId());
		dto.setCountryName(country.getCountryName());
		dto.setNationality(country.getNationality());
		dto.setIsActive(country.getIsActive());
		dto.setCreatedDt(country.getCreatedDt());
		dto.setModifiedDt(country.getModifiedDt());
		
		return dto;
		
	}
	
	public static Country toEntity(CountryDto dto) {
		if(dto == null ) return null;
		
		Country country = new Country();
		country.setCountryId(dto.getCountryId());
		country.setCountryName(dto.getCountryName());
        country.setNationality(dto.getNationality());
        country.setIsActive(dto.getIsActive());
        country.setCreatedDt(dto.getCreatedDt());
        country.setModifiedDt(dto.getModifiedDt());
		
		return country;
	}

}
