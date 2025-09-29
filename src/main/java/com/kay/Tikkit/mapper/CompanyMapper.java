package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.CompanyDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Company;

public class CompanyMapper {

	public static CompanyDto toDto(Company company) {
		if(company==null) return null;
		
		CompanyDto dto = new CompanyDto();
		dto.setCompanyId(company.getCompanyId());
		dto.setCompanyName(company.getCompanyName());
		dto.setIsActive(company.getIsActive());
		dto.setCreatedDt(company.getCreatedDt());
		dto.setModifiedDt(company.getModifiedDt());
		
		if (company.getArea() != null) {
			dto.setAreaId(company.getArea().getAreaId());
	        dto.setAreaName(company.getArea().getAreaName());
	        dto.setPincode(company.getArea().getPincode());

	        if (company.getArea().getCity() != null)
	            dto.setCityName(company.getArea().getCity().getCityName());

	        if (company.getArea().getDistrict() != null)
	            dto.setDistrictName(company.getArea().getDistrict().getDistrictName());

	        if (company.getArea().getState() != null)
	            dto.setStateName(company.getArea().getState().getStateName());

	        if (company.getArea().getCountry() != null)
	            dto.setCountryName(company.getArea().getCountry().getCountryName());
	    }
		
		return dto;
		
	}
	
	public static Company toEntity(CompanyDto dto, Area area) {
		if(dto==null) return null;
		
		Company company = new Company();
		if (dto.getCompanyId() != null && dto.getCompanyId() > 0) {
	        company.setCompanyId(dto.getCompanyId());
	    }
		company.setCompanyName(dto.getCompanyName());
		company.setIsActive(dto.getIsActive());
		company.setCreatedDt(dto.getCreatedDt());
		company.setModifiedDt(dto.getModifiedDt());
		company.setArea(area);
		return company;
	}
}
