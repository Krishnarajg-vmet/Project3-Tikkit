package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.DistrictDto;
import com.kay.Tikkit.service.DistrictService;

@RestController
@RequestMapping("/api/districts")
public class DistrictRestController {

    private final DistrictService districtService;

    public DistrictRestController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PreAuthorize("hasAuthority('READ_DISTRICT')")
    @GetMapping
    public List<DistrictDto> getAllDistricts() {
        return districtService.getAllActiveDistricts();
    }

    @PreAuthorize("hasAuthority('READ_DISTRICT')")
    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> getDistrictById(@PathVariable Long id) {
    	DistrictDto district = districtService.getById(id);
        return district != null ? ResponseEntity.ok(district) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('CREATE_DISTRICT')")
    @PostMapping
    public DistrictDto createDistrict(@RequestBody DistrictDto districtDTO) {
        return districtService.createDistrict(districtDTO);
    }

    @PreAuthorize("hasAuthority('UPDATE_DISTRICT')")
    @PutMapping("/{id}")
    public ResponseEntity<DistrictDto> updateDistrict(@PathVariable Long id, @RequestBody DistrictDto districtDTO) {
    	DistrictDto updated = districtService.updateDistrict(id, districtDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('DELETE_DISTRICT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
        return ResponseEntity.noContent().build();
    }
    
    @PreAuthorize("hasAuthority('READ_DISTRICT')")
    @GetMapping("/by-state/{stateId}")
    public ResponseEntity<List<DistrictDto>> getDistrictByStates(@PathVariable Long stateId) {
        List<DistrictDto> districts = districtService.getDistrictByStateId(stateId);
        return ResponseEntity.ok(districts);
    }
}
