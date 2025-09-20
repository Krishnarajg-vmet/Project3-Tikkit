package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kay.Tikkit.entity.Area;
import com.kay.Tikkit.entity.City;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public interface AreaRepository extends JpaRepository<Area, Long> {

    Optional<Area> findByAreaName(String areaName);

    Optional<Area> findByPincode(String pincode);

    List<Area> findByCity(City city);

    List<Area> findByDistrict(District district);

    List<Area> findByState(State state);

    List<Area> findByCountry(Country country);

    List<Area> findByIsActiveTrue();

    boolean existsByAreaName(String areaName);

    boolean existsByPincode(String pincode);
}
