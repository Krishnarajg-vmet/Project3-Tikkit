package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kay.Tikkit.entity.City;
import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.District;
import com.kay.Tikkit.entity.State;

public interface CityRepository extends JpaRepository<City, Long> {

	Optional<City> findByCityName(String cityName);

    List<City> findByDistrict(District district);

    List<City> findByDistrictAndIsActiveTrue(District district);

    List<City> findByState(State state);

    List<City> findByCountry(Country country);

    List<City> findByIsActiveTrue();

    boolean existsByCityName(String cityName);

    boolean existsByDistrict(District district);

	List<City> findByDistrictDistrictIdAndIsActiveTrue(Long districtId);
}
