package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.CountryDto;
import com.kay.Tikkit.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAllActiveCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        CountryDto country = countryService.getById(id);
        return country != null ? ResponseEntity.ok(country) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody CountryDto countryDTO) {
        try {
            CountryDto created = countryService.createCountry(countryDTO);
            return ResponseEntity.ok(created);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                .status(409)
                .body("Country already exists.");
        } catch (Exception e) {
            return ResponseEntity
                .status(500)
                .body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable Long id, @RequestBody CountryDto countryDTO) {
        CountryDto updated = countryService.updateCountry(id, countryDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
