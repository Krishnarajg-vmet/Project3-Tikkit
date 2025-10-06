package com.kay.Tikkit.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.enums.BloodGroup;
import com.kay.Tikkit.enums.DepartmentType;
import com.kay.Tikkit.enums.EmployeeCategory;
import com.kay.Tikkit.enums.EmployeeType;
import com.kay.Tikkit.enums.Gender;
import com.kay.Tikkit.enums.MaritalStatus;
import com.kay.Tikkit.enums.Title;

@RestController
@RequestMapping("/api/enums")
public class EnumRestController {
	
	@GetMapping("/title")
	public List<Map<String, String>> getTitles() {
		return Arrays.stream(Title.values())
				.map(t -> Map.of("name", t.name(), "label", t.getLabel()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/maritalStatus")
	public List<Map<String, String>> getMaritalStatus() {
		return Arrays.stream(MaritalStatus.values())
				.map(ms -> Map.of("name", ms.name(), "label", ms.getLabel()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/gender")
	public List<Map<String, String>> getGenders() {
		return Arrays.stream(Gender.values())
				.map(g -> Map.of("name", g.name(), "label", g.getLabel()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/bloodGroup")
	public List<Map<String, String>> getBloodGroups() {
	    return Arrays.stream(BloodGroup.values())
	        .map(bg -> Map.of("name", bg.name(), "label", bg.getLabel()))
	        .collect(Collectors.toList());
	}
	
	@GetMapping("/employeeType")
	public List<Map<String, String>> getEmployeeTypes() {
		return Arrays.stream(EmployeeType.values())
				.map(et -> Map.of("name", et.name(), "label", et.getLabel()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/employeeCategory")
	public List<Map<String, String>> getEmployeeCategories() {
		return Arrays.stream(EmployeeCategory.values())
				.map(ec -> Map.of("name", ec.name(), "label", ec.getLabel()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/departmentType")
    public List<Map<String, String>> getDepartmentTypes() {
        return Arrays.stream(DepartmentType.values())
            .map(dt -> Map.of("name", dt.name(), "label", dt.getLabel()))
            .collect(Collectors.toList());
    }

}
