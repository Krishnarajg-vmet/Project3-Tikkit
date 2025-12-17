package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.StateDto;
import com.kay.Tikkit.service.StateService;

@RestController
@RequestMapping("/api/states")
public class StateRestController {

    private final StateService stateService;

    public StateRestController(StateService stateService) {
        this.stateService = stateService;
    }

    @PreAuthorize("hasAuthority('READ_STATE')")
    @GetMapping
    public List<StateDto> getAllStates() {
        return stateService.getAllActiveStates();
    }

    @PreAuthorize("hasAuthority('READ_STATE')")
    @GetMapping("/{id}")
    public ResponseEntity<StateDto> getStateById(@PathVariable Long id) {
        StateDto state = stateService.getById(id);
        return state != null ? ResponseEntity.ok(state) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('CREATE_STATE')")
    @PostMapping
    public StateDto createState(@RequestBody StateDto stateDTO) {
        return stateService.createState(stateDTO);
    }

    @PreAuthorize("hasAuthority('UPDATE_STATE')")
    @PutMapping("/{id}")
    public ResponseEntity<StateDto> updateState(@PathVariable Long id, @RequestBody StateDto stateDTO) {
        StateDto updated = stateService.updateState(id, stateDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('DELETE_STATE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
        return ResponseEntity.noContent().build();
    }
    
    @PreAuthorize("hasAuthority('READ_STATE')")
    @GetMapping("/by-country/{countryId}")
    public ResponseEntity<List<StateDto>> getStatesByCountry(@PathVariable Long countryId) {
        List<StateDto> states = stateService.getStatesByCountryId(countryId);
        return ResponseEntity.ok(states);
    }

}
