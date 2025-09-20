package com.kay.Tikkit.mapper;

import com.kay.Tikkit.dto.StateDto;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.State;

public class StateMapper {
	
	public static StateDto toDto(State state) {
        if (state == null) return null;

        StateDto dto = new StateDto();
        dto.setStateId(state.getStateId());
        dto.setStateName(state.getStateName());
        dto.setIsActive(state.getIsActive());
        dto.setCreatedDt(state.getCreatedDt());
        dto.setModifiedDt(state.getModifiedDt());

        if (state.getCountry() != null) {
            dto.setCountryId(state.getCountry().getCountryId());
            dto.setCountryName(state.getCountry().getCountryName());
        }

        return dto;
    }

    public static State toEntity(StateDto dto, Country country) {
        if (dto == null) return null;

        State state = new State();
        state.setStateId(dto.getStateId());
        state.setStateName(dto.getStateName());
        state.setIsActive(dto.getIsActive());
        state.setCreatedDt(dto.getCreatedDt());
        state.setModifiedDt(dto.getModifiedDt());
        state.setCountry(country);
        return state;
    }

}
