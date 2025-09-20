package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public interface DistrictRepository extends JpaRepository<District, Long> {

    Optional<District> findByDistrictName(String districtName);

    List<District> findByState(State state);

    List<District> findByStateAndIsActiveTrue(State state);

    List<District> findByCountry(Country country);

    List<District> findByCountryAndIsActiveTrue(Country country);

    List<District> findByIsActiveTrue();

    boolean existsByDistrictName(String districtName);

    boolean existsByState(State state);
}
