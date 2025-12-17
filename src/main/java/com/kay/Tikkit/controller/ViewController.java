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
    @PreAuthorize("hasAuthority('READ_COUNTRY')") // Permission-based security
    public String countryPage() {
        return "countries-list";
    }

    @GetMapping("/create/countries")
    @PreAuthorize("hasAuthority('CREATE_COUNTRY')") // Permission-based security
    public String countryCreationPage() {
        return "countries-create";
    }

    @GetMapping("/update/countries")
    @PreAuthorize("hasAuthority('UPDATE_COUNTRY')") // Permission-based security
    public String countryUpdatePage() {
        return "countries-update";
    }

    @GetMapping("/states")
    @PreAuthorize("hasAuthority('READ_STATE')") // Permission-based security
    public String statePage() {
        return "states-list";
    }

    @GetMapping("/create/states")
    @PreAuthorize("hasAuthority('CREATE_STATE')") // Permission-based security
    public String stateCreationPage() {
        return "states-create";
    }

    @GetMapping("/update/states")
    @PreAuthorize("hasAuthority('UPDATE_STATE')") // Permission-based security
    public String stateUpdatePage() {
        return "states-update";
    }

    @GetMapping("/view/companies")
    @PreAuthorize("hasAuthority('READ_COMPANY')") // Permission-based security
    public String companyPage() {
        return "companies";
    }

    @GetMapping("/view/branches")
    @PreAuthorize("hasAuthority('READ_BRANCH')") // Permission-based security
    public String branchPage() {
        return "branches";
    }

    @GetMapping("/view/departments")
    @PreAuthorize("hasAuthority('READ_DEPARTMENT')") // Permission-based security
    public String departmentPage() {
        return "departments";
    }

    @GetMapping("/view/designations")
    @PreAuthorize("hasAuthority('READ_DESIGNATION')") // Permission-based security
    public String designationPage() {
        return "designations";
    }

    @GetMapping("/view/employees")
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')") // Permission-based security
    public String employeePage() {
        return "employees";
    }

    @GetMapping("/employees")
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')") // Permission-based security
    public String employeeListPage() {
        return "employees-list";
    }

    @GetMapping("/view/roles")
    @PreAuthorize("hasAuthority('READ_ROLE')") // Permission-based security
    public String rolePage() {
        return "roles";
    }

    @GetMapping("/view/users")
    @PreAuthorize("hasAuthority('READ_USER')") // Permission-based security
    public String userPage() {
        return "users";
    }

    @GetMapping("/view/ticket/dashboard")
    @PreAuthorize("hasAuthority('VIEW_TICKET')") // Permission-based security
    public String ticketDashboardPage() {
        return "ticket-dashboard";
    }

    @GetMapping("/view/complaints")
    @PreAuthorize("hasAuthority('READ_COMPLAINT')") // Permission-based security
    public String complaintPage() {
        return "complaints";
    }

    @GetMapping("/view/ticket/create")
    @PreAuthorize("hasAuthority('CREATE_TICKET')") // Permission-based security
    public String ticketCreatePage() {
        return "ticket-create";
    }

    @GetMapping("/view/ticket")
    @PreAuthorize("hasAuthority('VIEW_TICKET')") // Permission-based security
    public String ticketViewPage(@RequestParam Long ticketId, Model model) {
        TicketResponseDto ticketDto = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticketDto);
        return "ticket-view";
    }

    @GetMapping("/ticket/report")
    @PreAuthorize("hasAuthority('VIEW_TICKET')") // Permission-based security
    public String reportPage() {
        return "report";
    }

}
