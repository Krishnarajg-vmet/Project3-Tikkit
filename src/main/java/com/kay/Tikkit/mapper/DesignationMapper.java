package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.DesignationDto;
import com.kay.Tikkit.entity.Designation;

public class DesignationMapper {
	
	public static DesignationDto toDto(Designation designation) {
		if(designation == null) return null;
		
		DesignationDto dto = new DesignationDto();
		dto.setDesignationId(designation.getDesignationId());
		dto.setDesignationName(designation.getDesignationName());
		dto.setIsActive(designation.getIsActive());
		return dto;
	}
	
	public static Designation toEntity(DesignationDto dto) {
		if(dto == null) return null;
		
		Designation designation = new Designation();
		if(dto.getDesignationId() != null && dto.getDesignationId() > 0) {
			designation.setDesignationId(dto.getDesignationId());
		}
		
		designation.setDesignationName(dto.getDesignationName());
		designation.setIsActive(dto.getIsActive());
		
		return designation;
	}

}
