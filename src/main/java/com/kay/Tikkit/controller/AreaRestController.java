package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.AreaDto;
import com.kay.Tikkit.service.AreaService;

@RestController
@RequestMapping("/api/areas")
public class AreaRestController {

    private final AreaService areaService;

    public AreaRestController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PreAuthorize("hasAuthority('READ_AREA')")
    @GetMapping
    public List<AreaDto> getAllAreas() {
        return areaService.getAllActiveAreas();
    }

    @PreAuthorize("hasAuthority('READ_AREA')")
    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getAreaById(@PathVariable Long id) {
    	AreaDto area = areaService.getById(id);
        return area != null ? ResponseEntity.ok(area) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('CREATE_AREA')")
    @PostMapping
    public AreaDto createArea(@RequestBody AreaDto areaDTO) {
        return areaService.createArea(areaDTO);
    }

    @PreAuthorize("hasAuthority('UPDATE_AREA')")
    @PutMapping("/{id}")
    public ResponseEntity<AreaDto> updateArea(@PathVariable Long id, @RequestBody AreaDto areaDTO) {
    	AreaDto updated = areaService.updateArea(id, areaDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('DELETE_AREA')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
        return ResponseEntity.noContent().build();
    }
}
