package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.UserDepartmentDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserDepartment;

public class UserDepartmentMapper {
	
	public static UserDepartmentDto toDto(UserDepartment userDepartment) {
		if(userDepartment==null) return null;
		
		UserDepartmentDto dto = new UserDepartmentDto();
		dto.setUserDepartmentId(userDepartment.getUserDepartmentId());
		dto.setUserId(userDepartment.getUser().getUserId());
		dto.setUserName(userDepartment.getUser().getUserName());
		dto.setDepartmentId(userDepartment.getDepartment().getDepartmentId());
		dto.setDepartmentName(userDepartment.getDepartment().getDepartmentName());
		dto.setIsActive(userDepartment.getIsActive());
		
		return dto;
		
	}
	
	public static UserDepartment toEntity(UserDepartmentDto dto, User user, Department department) {
		
		UserDepartment userDepartment = new UserDepartment();
		
		userDepartment.setUser(user);
		userDepartment.setDepartment(department);
		userDepartment.setIsActive(dto.getIsActive());
		
		return userDepartment;
	}

}
