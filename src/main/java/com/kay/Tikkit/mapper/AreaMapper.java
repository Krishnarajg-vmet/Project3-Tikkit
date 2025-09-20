package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.AreaDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.City;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public class AreaMapper {

	public static AreaDto toDto(Area area) {
        if (area == null) return null;

        AreaDto dto = new AreaDto();
        dto.setAreaId(area.getAreaId());
        dto.setAreaName(area.getAreaName());
        dto.setPincode(area.getPincode());
        dto.setIsActive(area.getIsActive());
        dto.setCreatedDt(area.getCreatedDt());
        dto.setModifiedDt(area.getModifiedDt());

        if (area.getCountry() != null) {
            dto.setCountryId(area.getCountry().getCountryId());
            dto.setCountryName(area.getCountry().getCountryName());
        }

        if (area.getState() != null) {
            dto.setStateId(area.getState().getStateId());
            dto.setStateName(area.getState().getStateName());
        }

        if (area.getDistrict() != null) {
            dto.setDistrictId(area.getDistrict().getDistrictId());
            dto.setDistrictName(area.getDistrict().getDistrictName());
        }

        if (area.getCity() != null) {
            dto.setCityId(area.getCity().getCityId());
            dto.setCityName(area.getCity().getCityName());
        }

        return dto;
    }

    public static Area toEntity(AreaDto dto, Country country, State state, District district, City city) {
        if (dto == null) return null;

        Area area = new Area();
        area.setAreaId(dto.getAreaId());
        area.setAreaName(dto.getAreaName());
        area.setPincode(dto.getPincode());
        area.setIsActive(dto.getIsActive());
        area.setCreatedDt(dto.getCreatedDt());
        area.setModifiedDt(dto.getModifiedDt());
        area.setCountry(country);
        area.setState(state);
        area.setDistrict(district);
        area.setCity(city);
        return area;
    }

}
