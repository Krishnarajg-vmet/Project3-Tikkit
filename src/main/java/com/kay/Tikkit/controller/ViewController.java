package com.kay.Tikkit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kay.Tikkit.dto.TicketResponseDto;
import com.kay.Tikkit.service.TicketService;

@Controller
public class ViewController {

    private final TicketService ticketService;

    public ViewController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/view/home")
    @PreAuthorize("hasAuthority('VIEW_HOME')") // Specific permission
    public String homePage() {
        return "index";
    }

    @PreAuthorize("hasAuthority('VIEW_HOME')")
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/countries")
    @PreAuthorize("hasAuthority('READ_COUNTRY')")
    public String countryPage() {
        return "countries-list";
    }

    @GetMapping("/create/countries")
    @PreAuthorize("hasAuthority('CREATE_COUNTRY')")
    public String countryCreationPage() {
        return "countries-create";
    }

    @GetMapping("/update/countries")
    @PreAuthorize("hasAuthority('UPDATE_COUNTRY')")
    public String countryUpdatePage() {
        return "countries-update";
    }

    @GetMapping("/states")
    @PreAuthorize("hasAuthority('READ_STATE')")
    public String statePage() {
        return "states-list";
    }

    @GetMapping("/create/states")
    @PreAuthorize("hasAuthority('CREATE_STATE')")
    public String stateCreationPage() {
        return "states-create";
    }

    @GetMapping("/update/states")
    @PreAuthorize("hasAuthority('UPDATE_STATE')")
    public String stateUpdatePage() {
        return "states-update";
    }
    
    @GetMapping("/districts")
    @PreAuthorize("hasAuthority('READ_STATE')")
    public String districtPage() {
        return "districts-list";
    }

    @GetMapping("/create/districts")
    @PreAuthorize("hasAuthority('CREATE_STATE')")
    public String districtCreationPage() {
        return "districts-create";
    }

    @GetMapping("/update/districts")
    @PreAuthorize("hasAuthority('UPDATE_STATE')")
    public String districtUpdatePage() {
        return "districts-update";
    }
    
    @GetMapping("/cities")
    @PreAuthorize("hasAuthority('READ_STATE')")
    public String cityPage() {
        return "cities-list";
    }

    @GetMapping("/create/cities")
    @PreAuthorize("hasAuthority('CREATE_STATE')")
    public String cityCreationPage() {
        return "cities-create";
    }

    @GetMapping("/update/cities")
    @PreAuthorize("hasAuthority('UPDATE_STATE')")
    public String cityUpdatePage() {
        return "cities-update";
    }
    
    @GetMapping("/areas")
    @PreAuthorize("hasAuthority('READ_STATE')")
    public String areaPage() {
        return "areas-list";
    }

    @GetMapping("/create/areas")
    @PreAuthorize("hasAuthority('CREATE_STATE')")
    public String areaCreationPage() {
        return "areas-create";
    }

    @GetMapping("/update/areas")
    @PreAuthorize("hasAuthority('UPDATE_STATE')")
    public String areaUpdatePage() {
        return "areas-update";
    }

    @GetMapping("/view/companies")
    @PreAuthorize("hasAuthority('READ_COMPANY')")
    public String companyPage() {
        return "companies";
    }

    @GetMapping("/view/branches")
    @PreAuthorize("hasAuthority('READ_BRANCH')")
    public String branchPage() {
        return "branches";
    }

    @GetMapping("/view/departments")
    @PreAuthorize("hasAuthority('READ_DEPARTMENT')")
    public String departmentPage() {
        return "departments";
    }

    @GetMapping("/view/designations")
    @PreAuthorize("hasAuthority('READ_DESIGNATION')")
    public String designationPage() {
        return "designations";
    }

    @GetMapping("/view/employees")
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')")
    public String employeePage() {
        return "employees";
    }

    @GetMapping("/employees")
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')")
    public String employeeListPage() {
        return "employees-list";
    }

    @GetMapping("/view/roles")
    @PreAuthorize("hasAuthority('READ_ROLE')")
    public String rolePage() {
        return "roles";
    }

    @GetMapping("/view/users")
    @PreAuthorize("hasAuthority('READ_USER')")
    public String userPage() {
        return "users";
    }

    @GetMapping("/view/ticket/dashboard")
    @PreAuthorize("hasAuthority('VIEW_TICKET')")
    public String ticketDashboardPage() {
        return "ticket-dashboard";
    }

    @GetMapping("/view/complaints")
    @PreAuthorize("hasAuthority('READ_COMPLAINT')")
    public String complaintPage() {
        return "complaints";
    }

    @GetMapping("/view/ticket/create")
    @PreAuthorize("hasAuthority('CREATE_TICKET')")
    public String ticketCreatePage() {
        return "ticket-create";
    }

    @GetMapping("/view/ticket")
    @PreAuthorize("hasAuthority('VIEW_TICKET')")
    public String ticketViewPage(@RequestParam Long ticketId, Model model) {
        TicketResponseDto ticketDto = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticketDto);
        return "ticket-view";
    }

    @GetMapping("/ticket/report")
    @PreAuthorize("hasAuthority('VIEW_TICKET')")
    public String reportPage() {
        return "report";
    }

}
