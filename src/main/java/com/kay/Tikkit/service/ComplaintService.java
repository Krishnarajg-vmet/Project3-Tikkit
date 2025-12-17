package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.config.SecurityUtil;
import com.kay.Tikkit.dto.ComplaintDto;
import com.kay.Tikkit.entity.Complaint;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.ComplaintMapper;
import com.kay.Tikkit.repositories.ComplaintRepository;

import jakarta.transaction.Transactional;

@Service
public class ComplaintService {

	private final ComplaintRepository complaintRepository;
    private final SecurityUtil securityUtil;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository, SecurityUtil securityUtil) {
        this.complaintRepository = complaintRepository;
        this.securityUtil = securityUtil;
    }

    @Transactional
    public List<ComplaintDto> getAllComplaints() {
        return complaintRepository.findAll().stream()
                .map(ComplaintMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ComplaintDto getComplaintById(Long id) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        return ComplaintMapper.toDto(complaint);
    }

    @Transactional
    public ComplaintDto createComplaint(ComplaintDto dto) {
        User currentUser = securityUtil.getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("No user is currently authenticated.");
        }

        if (dto.getComplaintName() == null || dto.getComplaintName().isBlank()) {
            throw new RuntimeException("Complaint name cannot be empty");
        }

        if (complaintRepository.existsByComplaintName(dto.getComplaintName())) {
            throw new RuntimeException("Complaint with this name already exists");
        }

        Complaint complaint = new Complaint();
        complaint.setComplaintName(dto.getComplaintName());
        complaint.setIsActive(true);
        complaint.setCreatedBy(currentUser);
        complaint.setModifiedBy(currentUser);
        complaint.setCreatedDt(LocalDateTime.now());
        complaint.setModifiedDt(LocalDateTime.now());

        complaintRepository.save(complaint);
        return ComplaintMapper.toDto(complaint);
    }

    @Transactional
    public ComplaintDto updateComplaint(Long id, ComplaintDto dto) {
        User currentUser = securityUtil.getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("No user is currently authenticated.");
        }

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        if (dto.getComplaintName() != null && !dto.getComplaintName().isBlank()) {
            complaint.setComplaintName(dto.getComplaintName());
        }

        if (dto.getIsActive() != null) {
            complaint.setIsActive(dto.getIsActive());
        }

        complaint.setModifiedBy(currentUser);
        complaint.setModifiedDt(LocalDateTime.now());

        complaintRepository.save(complaint);
        return ComplaintMapper.toDto(complaint);
    }

    @Transactional
    public void deleteComplaint(Long id) {
    	User currentUser = securityUtil.getCurrentUser();
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setModifiedBy(currentUser);
        complaintRepository.delete(complaint);
    }
}
