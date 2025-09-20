package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.CityDto;
import com.kay.Tikkit.entity.City;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public class CityMapper {

	public static CityDto toDto(City city) {
        if (city == null) return null;

        CityDto dto = new CityDto();
        dto.setCityId(city.getCityId());
        dto.setCityName(city.getCityName());
        dto.setIsActive(city.getIsActive());
        dto.setCreatedDt(city.getCreatedDt());
        dto.setModifiedDt(city.getModifiedDt());

        if (city.getCountry() != null) {
            dto.setCountryId(city.getCountry().getCountryId());
            dto.setCountryName(city.getCountry().getCountryName());
        }

        if (city.getState() != null) {
            dto.setStateId(city.getState().getStateId());
            dto.setStateName(city.getState().getStateName());
        }

        if (city.getDistrict() != null) {
            dto.setDistrictId(city.getDistrict().getDistrictId());
            dto.setDistrictName(city.getDistrict().getDistrictName());
        }

        return dto;
    }

    public static City toEntity(CityDto dto, Country country, State state, District district) {
        if (dto == null) return null;

        City city = new City();
        city.setCityId(dto.getCityId());
        city.setCityName(dto.getCityName());
        city.setIsActive(dto.getIsActive());
        city.setCreatedDt(dto.getCreatedDt());
        city.setModifiedDt(dto.getModifiedDt());
        city.setCountry(country);
        city.setState(state);
        city.setDistrict(district);
        return city;
    }
}
