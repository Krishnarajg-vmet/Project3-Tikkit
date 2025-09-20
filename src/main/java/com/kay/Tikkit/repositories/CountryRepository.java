package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kay.Tikkit.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	
	Optional<Country> findByCountryName(String countryName);
	List<Country> findByIsActiveTrue();
	Optional<Country> findByNationality(String nationality);
	boolean existsByCountryName(String countryName);

}
