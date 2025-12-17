package com.kay.Tikkit.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.enums.BloodGroup;
import com.kay.Tikkit.enums.DepartmentType;
import com.kay.Tikkit.enums.EmployeeCategory;
import com.kay.Tikkit.enums.EmployeeType;
import com.kay.Tikkit.enums.Gender;
import com.kay.Tikkit.enums.MaritalStatus;
import com.kay.Tikkit.enums.Product;
import com.kay.Tikkit.enums.Title;
import com.kay.Tikkit.enums.TicketCategory;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

@RestController
@RequestMapping("/api/enums")
public class EnumRestController {

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/title")
    public List<Map<String, String>> getTitles() {
        return Arrays.stream(Title.values())
                .map(t -> Map.of("name", t.name(), "label", t.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/maritalStatus")
    public List<Map<String, String>> getMaritalStatus() {
        return Arrays.stream(MaritalStatus.values())
                .map(ms -> Map.of("name", ms.name(), "label", ms.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/gender")
    public List<Map<String, String>> getGenders() {
        return Arrays.stream(Gender.values())
                .map(g -> Map.of("name", g.name(), "label", g.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/bloodGroup")
    public List<Map<String, String>> getBloodGroups() {
        return Arrays.stream(BloodGroup.values())
                .map(bg -> Map.of("name", bg.name(), "label", bg.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/employeeType")
    public List<Map<String, String>> getEmployeeTypes() {
        return Arrays.stream(EmployeeType.values())
                .map(et -> Map.of("name", et.name(), "label", et.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/employeeCategory")
    public List<Map<String, String>> getEmployeeCategories() {
        return Arrays.stream(EmployeeCategory.values())
                .map(ec -> Map.of("name", ec.name(), "label", ec.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/departmentType")
    public List<Map<String, String>> getDepartmentTypes() {
        return Arrays.stream(DepartmentType.values())
                .map(dt -> Map.of("name", dt.name(), "label", dt.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/ticketCategory")
    public List<Map<String, String>> getTicketCategories() {
        return Arrays.stream(TicketCategory.values())
                .map(tc -> Map.of("name", tc.name(), "label", tc.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/ticketPriority")
    public List<Map<String, String>> getTicketPriorities() {
        return Arrays.stream(TicketPriority.values())
                .map(tp -> Map.of("name", tp.name(), "label", tp.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/ticketStatus")
    public List<Map<String, String>> getTicketStatuses() {
        return Arrays.stream(TicketStatus.values())
                .map(ts -> Map.of("name", ts.name(), "label", ts.getLabel()))
                .collect(Collectors.toList());
    }

	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/ticketType")
    public List<Map<String, String>> getTicketTypes() {
        return Arrays.stream(TicketType.values())
                .map(tt -> Map.of("name", tt.name(), "label", tt.getLabel()))
                .collect(Collectors.toList());
    }
    
	@PreAuthorize("hasAuthority('READ_ENUMS')")
    @GetMapping("/products")
    public List<Map<String, String>> getProducts() {
    	return Arrays.stream(Product.values())
    			.map(p -> Map.of("name", p.name(), "label", p.getLabel()))
    			.collect(Collectors.toList());
    }
}
