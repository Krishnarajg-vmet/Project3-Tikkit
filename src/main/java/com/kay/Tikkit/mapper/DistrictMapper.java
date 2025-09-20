package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.DistrictDto;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public class DistrictMapper {

	public static DistrictDto toDto(District district) {
        if (district == null) return null;

        DistrictDto dto = new DistrictDto();
        dto.setDistrictId(district.getDistrictId());
        dto.setDistrictName(district.getDistrictName());
        dto.setIsActive(district.getIsActive());
        dto.setCreatedDt(district.getCreatedDt());
        dto.setModifiedDt(district.getModifiedDt());

        if (district.getCountry() != null) {
            dto.setCountryId(district.getCountry().getCountryId());
            dto.setCountryName(district.getCountry().getCountryName());
        }

        if (district.getState() != null) {
            dto.setStateId(district.getState().getStateId());
            dto.setStateName(district.getState().getStateName());
        }

        return dto;
    }

    public static District toEntity(DistrictDto dto, Country country, State state) {
        if (dto == null) return null;

        District district = new District();
        district.setDistrictId(dto.getDistrictId());
        district.setDistrictName(dto.getDistrictName());
        district.setIsActive(dto.getIsActive());
        district.setCreatedDt(dto.getCreatedDt());
        district.setModifiedDt(dto.getModifiedDt());
        district.setCountry(country);
        district.setState(state);
        return district;
    }
}
