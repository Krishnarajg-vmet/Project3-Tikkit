package com.kay.Tikkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kay.Tikkit.dto.*;
import com.kay.Tikkit.entity.*;
import com.kay.Tikkit.mapper.*;
import com.kay.Tikkit.repositories.*;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    public StateDto createState(StateDto dto) {
        Country country = countryRepository.findById(dto.getCountryId()).orElseThrow();
        State state = StateMapper.toEntity(dto, country);
        state.setIsActive(true);
        return StateMapper.toDto(stateRepository.save(state));
    }

    public List<StateDto> getAllActiveStates() {
        return stateRepository.findByIsActiveTrue()
                .stream()
                .map(StateMapper::toDto)
                .collect(Collectors.toList());
    }
       
    public StateDto getById(Long id) {
    	Optional<State> optional = stateRepository.findById(id);
    	return optional.map(StateMapper::toDto).orElse(null);
    }

    public StateDto updateState(Long id, StateDto dto) {
        return stateRepository.findById(id).map(existing -> {
            Country country = countryRepository.findById(dto.getCountryId()).orElseThrow();
            existing.setStateName(dto.getStateName());
            existing.setCountry(country);
            existing.setIsActive(dto.getIsActive());
            return StateMapper.toDto(stateRepository.save(existing));
        }).orElse(null);
    }

    public void deleteState(Long id) {
        stateRepository.findById(id).ifPresent(state -> {
            state.setIsActive(false);
            stateRepository.save(state);
        });
    }
    
    public List<StateDto> getStatesByCountryId(Long countryId) {
        List<State> states = stateRepository.findByCountryCountryIdAndIsActiveTrue(countryId);
        return states.stream().map(StateMapper::toDto).collect(Collectors.toList());
    }


}

