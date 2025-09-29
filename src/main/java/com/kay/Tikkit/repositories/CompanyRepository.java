package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Optional<Company> findByCompanyName(String companyName);
	List<Company> findByAreaCityCityIdAndIsActiveTrue(Long cityId);
	List<Company> findByAreaCityCityName(String cityName);
	List<Company> findByAreaAreaId(Long areaId);
	List<Company> findByAreaAreaName(String areaName);
	List<Company> findByIsActiveTrue();
	
}
