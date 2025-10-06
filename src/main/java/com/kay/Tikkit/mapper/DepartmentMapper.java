package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.DepartmentDto;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.enums.DepartmentType;

public class DepartmentMapper {

    public static DepartmentDto toDto(Department department) {
        if (department == null) return null;

        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setDepartmentCode(department.getDepartmentCode());

        if (department.getDepartmentType() != null) {
            dto.setDepartmentType(department.getDepartmentType().toString());
        }

        if (department.getBranch() != null) {
            dto.setBranchId(department.getBranch().getBranchId());
            dto.setBranchName(department.getBranch().getBranchName());
        }

        dto.setIsActive(department.getIsActive());

        return dto;
    }

    public static Department toEntity(DepartmentDto dto, Branch branch) {
        if (dto == null) return null;

        Department department = new Department();
        if (dto.getDepartmentId() != null && dto.getDepartmentId() > 0) {
            department.setDepartmentId(dto.getDepartmentId());
        }
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setDepartmentName(dto.getDepartmentName());

        try {
            department.setDepartmentType(DepartmentType.valueOf(dto.getDepartmentType().toUpperCase()));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid department type: " + dto.getDepartmentType());
        }

        department.setBranch(branch);
        department.setIsActive(dto.getIsActive());
        department.setCreatedDt(dto.getCreatedDt());
        department.setModifiedDt(dto.getModifiedDt());

        return department;
    }
}
