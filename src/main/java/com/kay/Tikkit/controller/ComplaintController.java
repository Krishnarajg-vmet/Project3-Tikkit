package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.ComplaintDto;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.service.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PreAuthorize("hasAuthority('READ_COMPLAINT')")
    @GetMapping
    public List<ComplaintDto> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @PreAuthorize("hasAuthority('READ_COMPLAINT')")
    @GetMapping("/{id}")
    public ComplaintDto getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_COMPLAINT')")
    @PostMapping
    public ComplaintDto createComplaint(@RequestBody ComplaintDto dto) {
        return complaintService.createComplaint(dto);
    }

    @PreAuthorize("hasAuthority('UPDATE_COMPLAINT')")
    @PutMapping("/{id}")
    public ComplaintDto updateComplaint(@PathVariable Long id, @RequestBody ComplaintDto dto) {
        return complaintService.updateComplaint(id, dto);
    }

    @PreAuthorize("hasAuthority('DELETE_COMPLAINT')")
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
