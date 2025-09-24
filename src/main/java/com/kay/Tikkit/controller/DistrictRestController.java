package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<DistrictDto> getAllDistricts() {
        return districtService.getAllActiveDistricts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> getDistrictById(@PathVariable Long id) {
    	DistrictDto district = districtService.getById(id);
        return district != null ? ResponseEntity.ok(district) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DistrictDto createDistrict(@RequestBody DistrictDto districtDTO) {
        return districtService.createDistrict(districtDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictDto> updateDistrict(@PathVariable Long id, @RequestBody DistrictDto districtDTO) {
    	DistrictDto updated = districtService.updateDistrict(id, districtDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/by-state/{stateId}")
    public ResponseEntity<List<DistrictDto>> getDistrictByStates(@PathVariable Long stateId) {
        List<DistrictDto> districts = districtService.getDistrictByStateId(stateId);
        return ResponseEntity.ok(districts);
    }
}
