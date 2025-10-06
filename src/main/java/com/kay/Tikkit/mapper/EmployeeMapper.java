package com.kay.Tikkit.mapper;

import java.time.LocalDateTime;

import com.kay.Tikkit.dto.EmployeeDto;
import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.Branch;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Designation;
import com.kay.Tikkit.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto toDto(Employee employee) {
		if(employee == null) return null;
		
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmployeeCode(employee.getEmployeeCode());
		dto.setTitle(employee.getTitle());
		
		dto.setDob(employee.getDob());
		dto.setAge(employee.getAge());
		dto.setJoiningDate(employee.getJoiningDate());
		
		dto.setGender(employee.getGender());
		dto.setMaritalStatus(employee.getMaritalStatus());
		dto.setBloodGroup(employee.getBloodGroup());
		dto.setEmployeeType(employee.getEmployeeType());
		dto.setEmployeeCategory(employee.getEmployeeCategory());
		
		if(employee.getLocation() !=null) {
			dto.setBranchId(employee.getLocation().getBranchId());
			dto.setBranchName(employee.getLocation().getBranchName());
		}
		
		if(employee.getDesignation() != null) {
			dto.setDesignationId(employee.getDesignation().getDesignationId());
			dto.setDesignationName(employee.getDesignation().getDesignationName());
		}
		
		if(employee.getDepartment() != null) {
			dto.setDepartmentId(employee.getDepartment().getDepartmentId());
			dto.setDepartmentName(employee.getDepartment().getDepartmentName());
		}
		
		dto.setQualification(employee.getQualification());
		
		dto.setAddress1(employee.getAddress1());
		dto.setAddress2(employee.getAddress2());
		
		if(employee.getArea() != null) {
			dto.setAreaId(employee.getArea().getAreaId());
			dto.setAreaName(employee.getArea().getAreaName());
		}
		
		dto.setMobileNumber(employee.getMobileNumber());
		dto.setAlternatenumber(employee.getAlternateNumber());
		dto.setEmail(employee.getEmail());
		
		dto.setReportingTo(employee.getReportingTo());
		dto.setReportingDepartment(employee.getReportingDepartment());
		dto.setReportingDesignation(employee.getReportingDesignation());
		dto.setResignationDate(employee.getResignationDate());
		
		dto.setIsActive(employee.getIsActive());
		dto.setCreatedDt(employee.getCreatedDt());
		dto.setModifiedDt(employee.getModifiedDt());
		
		return dto;
	}
	
	public static Employee toEntity(EmployeeDto dto, Branch branch, Department department, Designation designation, Area area) {
		if(dto == null) return null;
		
		Employee employee = new Employee();
		if(dto.getEmployeeId() != null && dto.getEmployeeId() > 0) {
			employee.setEmployeeId(dto.getEmployeeId());
		}
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmployeeCode(dto.getEmployeeCode());
		employee.setTitle(dto.getTitle());
		employee.setGender(dto.getGender());
		employee.setMaritalStatus(dto.getMaritalStatus());
		employee.setBloodGroup(dto.getBloodGroup());
		employee.setEmployeeType(dto.getEmployeeType());
		employee.setEmployeeCategory(dto.getEmployeeCategory());
		employee.setDob(dto.getDob());
		employee.setAge(dto.getAge());
		employee.setQualification(dto.getQualification());
		employee.setAddress1(dto.getAddress1());
		employee.setAddress2(dto.getAddress2());
		employee.setMobileNumber(dto.getMobileNumber());
		employee.setAlternateNumber(dto.getAlternatenumber());
		employee.setEmail(dto.getEmail());
		employee.setReportingTo(dto.getReportingTo());
		employee.setReportingDepartment(dto.getReportingDepartment());
		employee.setReportingDesignation(dto.getReportingDesignation());
		employee.setResignationDate(dto.getResignationDate());
		employee.setJoiningDate(dto.getJoiningDate());
		
		employee.setIsActive(dto.getIsActive());
		employee.setCreatedDt(dto.getCreatedDt());
		employee.setModifiedDt(dto.getModifiedDt());
		
		employee.setLocation(branch);
		employee.setDepartment(department);
		employee.setDesignation(designation);
		employee.setArea(area);
		
		return employee;
	}
	
	public static void updateEntity(Employee employee, EmployeeDto dto, Branch branch, Department department, Designation designation, Area area) {
	    employee.setFirstName(dto.getFirstName());
	    employee.setLastName(dto.getLastName());
	    employee.setEmployeeCode(dto.getEmployeeCode());
	    employee.setTitle(dto.getTitle());
	    employee.setGender(dto.getGender());
	    employee.setMaritalStatus(dto.getMaritalStatus());
	    employee.setBloodGroup(dto.getBloodGroup());
	    employee.setEmployeeType(dto.getEmployeeType());
	    employee.setEmployeeCategory(dto.getEmployeeCategory());
	    employee.setDob(dto.getDob());
	    employee.setAge(dto.getAge());
	    employee.setQualification(dto.getQualification());
	    employee.setAddress1(dto.getAddress1());
	    employee.setAddress2(dto.getAddress2());
	    employee.setMobileNumber(dto.getMobileNumber());
	    employee.setAlternateNumber(dto.getAlternatenumber());
	    employee.setEmail(dto.getEmail());
	    employee.setReportingTo(dto.getReportingTo());
	    employee.setReportingDepartment(dto.getReportingDepartment());
	    employee.setReportingDesignation(dto.getReportingDesignation());
	    employee.setResignationDate(dto.getResignationDate());
	    employee.setJoiningDate(dto.getJoiningDate());
	    employee.setIsActive(dto.getIsActive());
	    employee.setModifiedDt(LocalDateTime.now());

	    employee.setLocation(branch);
	    employee.setDepartment(department);
	    employee.setDesignation(designation);
	    employee.setArea(area);
	}


}
