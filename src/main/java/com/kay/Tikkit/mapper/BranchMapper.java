package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.BranchDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Company;

public class BranchMapper {
	
	public static BranchDto toDto(Branch branch) {
		if(branch == null) return null;
		
		BranchDto dto = new BranchDto();
		dto.setBranchId(branch.getBranchId());
		dto.setBranchName(branch.getBranchName());
		dto.setIsActive(branch.getIsActive());
		dto.setCreatedDt(branch.getCreatedDt());
		dto.setModifiedDt(branch.getModifiedDt());
		
		if(branch.getCompany() != null) {
			dto.setCompanyId(branch.getCompany().getCompanyId());
			dto.setCompanyName(branch.getCompany().getCompanyName());
		}
		
		if(branch.getArea() != null) {
			dto.setAreaId(branch.getArea().getAreaId());
			dto.setAreaName(branch.getArea().getAreaName());
			dto.setPincode(branch.getArea().getPincode());
			
			if(branch.getArea().getCity() != null) {
				dto.setCityName(branch.getArea().getCity().getCityName());
			}
			
			if(branch.getArea().getDistrict() != null) {
				dto.setDistrictName(branch.getArea().getDistrict().getDistrictName());
			}
			
			if(branch.getArea().getState() != null) {
				dto.setStateName(branch.getArea().getState().getStateName());
			}
			
			if(branch.getArea().getCountry() != null) {
				dto.setCountryName(branch.getArea().getCountry().getCountryName());
			}
		}
		
		return dto;
	}
	
	public static Branch toEntity(BranchDto dto, Company company, Area area) {
		if(dto == null) return null;
		
		Branch branch = new Branch();
		if(dto.getBranchId() != null && dto.getBranchId()>0) {
			branch.setBranchId(dto.getBranchId());		
		}
		
		branch.setBranchName(dto.getBranchName());
		branch.setCompany(company);
		branch.setArea(area);
		branch.setIsActive(dto.getIsActive());
		branch.setCreatedDt(dto.getCreatedDt());
		branch.setModifiedDt(dto.getModifiedDt());
		
		return branch;
	}

}
