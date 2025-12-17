package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.CityDto;
import com.kay.Tikkit.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

    private final CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @PreAuthorize("hasAuthority('READ_CITIY')")
    @GetMapping
    public List<CityDto> getAllCities() {
        return cityService.getAllActiveCities();
    }

    @PreAuthorize("hasAuthority('READ_CITY')")
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
    	CityDto city = cityService.getbyId(id);
        return city != null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('CREATE_CITY')")
    @PostMapping
    public CityDto createCity(@RequestBody CityDto cityDTO) {
        return cityService.createCity(cityDTO);
    }

    @PreAuthorize("hasAuthority('UPDATE_CITY')")
    @PutMapping("/{id}")
    public ResponseEntity<CityDto> updateCity(@PathVariable Long id, @RequestBody CityDto cityDTO) {
    	CityDto updated = cityService.updateCity(id, cityDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('DELETE_CITY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
    
    @PreAuthorize("hasAuthority('READ_CITY')")
    @GetMapping("/by-district/{districtId}")
    public ResponseEntity<List<CityDto>> getCityByDistrict(@PathVariable Long districtId) {
    	List<CityDto> cities = cityService.getCityByDistrictId(districtId);
    	return ResponseEntity.ok(cities);
    }
}
