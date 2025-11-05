package com.kay.Tikkit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.TicketDto;
import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.TicketMapper;
import com.kay.Tikkit.repositories.DepartmentRepository;
import com.kay.Tikkit.repositories.TicketRepository;
import com.kay.Tikkit.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketDto createTicket(TicketDto dto) {
        Department raisedTo = departmentRepository.findById(dto.getRaisedToDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("RaisedTo Department not found"));
        Department raisedBy = departmentRepository.findById(dto.getRaisedByDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("RaisedBy Department not found"));
        User createdBy = userRepository.findById(dto.getCreatedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("CreatedBy User not found"));
        User modifiedBy = dto.getModifiedByUserId() != null 
                ? userRepository.findById(dto.getModifiedByUserId())
                    .orElseThrow(() -> new EntityNotFoundException("ModifiedBy User not found")) 
                : null;
        User assignedTo = dto.getAssignedToUserId() != null 
                ? userRepository.findById(dto.getAssignedToUserId())
                    .orElseThrow(() -> new EntityNotFoundException("AssignedTo User not found")) 
                : null;
        Ticket parentTicket = dto.getParentTicketId() != null
                ? ticketRepository.findById(dto.getParentTicketId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent Ticket not found"))
                : null;

        dto.setCreatedAt(LocalDateTime.now());

        Ticket ticket = TicketMapper.toEntity(dto, raisedTo, raisedBy, createdBy, modifiedBy, assignedTo, parentTicket);
        ticket = ticketRepository.save(ticket);

        return TicketMapper.toDto(ticket);
    }

    public TicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        return TicketMapper.toDto(ticket);
    }

    public TicketDto updateTicket(TicketDto dto, Long id) {
        return ticketRepository.findById(id).map(existing -> {
            Department raisedTo = departmentRepository.findById(dto.getRaisedToDepartmentId())
                    .orElseThrow(() -> new EntityNotFoundException("RaisedTo Department not found"));
            Department raisedBy = departmentRepository.findById(dto.getRaisedByDepartmentId())
                    .orElseThrow(() -> new EntityNotFoundException("RaisedBy Department not found"));
            User modifiedBy = dto.getModifiedByUserId() != null 
                    ? userRepository.findById(dto.getModifiedByUserId())
                        .orElseThrow(() -> new EntityNotFoundException("ModifiedBy User not found")) 
                    : null;
            User assignedTo = dto.getAssignedToUserId() != null 
                    ? userRepository.findById(dto.getAssignedToUserId())
                        .orElseThrow(() -> new EntityNotFoundException("AssignedTo User not found")) 
                    : null;
            Ticket parentTicket = dto.getParentTicketId() != null
                    ? ticketRepository.findById(dto.getParentTicketId())
                        .orElseThrow(() -> new EntityNotFoundException("Parent Ticket not found"))
                    : null;

            existing.setUpdatedAt(LocalDateTime.now());
            TicketMapper.toEntity(dto, raisedTo, raisedBy, existing.getCreatedBy(), modifiedBy, assignedTo, parentTicket);
            return TicketMapper.toDto(ticketRepository.save(existing));
        }).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::toDto)
                .collect(Collectors.toList());
    }

}
