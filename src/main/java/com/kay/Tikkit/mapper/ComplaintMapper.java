package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.ComplaintDto;
import com.kay.Tikkit.entity.Complaint;

public class ComplaintMapper {

    public static ComplaintDto toDto(Complaint complaint) {
        if (complaint == null) return null;

        ComplaintDto dto = new ComplaintDto();
        dto.setComplaintId(complaint.getComplaintId());
        dto.setComplaintName(complaint.getComplaintName());
        dto.setIsActive(complaint.getIsActive());
        
        if (complaint.getCreatedBy() != null) {
            dto.setCreatedById(complaint.getCreatedBy().getUserId());
            dto.setCreatedByName(complaint.getCreatedBy().getUserName());
        }
        dto.setCreatedDt(complaint.getCreatedDt());

        if (complaint.getModifiedBy() != null) {
            dto.setModifiedById(complaint.getModifiedBy().getUserId());
            dto.setModifiedByName(complaint.getModifiedBy().getUserName());
        }
        dto.setModifiedDt(complaint.getModifiedDt());

        if (complaint.getTickets() != null) {
            dto.setTickets(
                complaint.getTickets().stream()
                        .map(TicketMapper::toListDto)
                        .toList()
            );
        }

        return dto;
    }

    public static Complaint toEntity(ComplaintDto dto) {
        if (dto == null) return null;

        Complaint complaint = new Complaint();
        complaint.setComplaintId(dto.getComplaintId());
        complaint.setComplaintName(dto.getComplaintName());
        complaint.setIsActive(dto.getIsActive());
        complaint.setCreatedDt(dto.getCreatedDt());
        complaint.setModifiedDt(dto.getModifiedDt());

        return complaint;
    }
}

