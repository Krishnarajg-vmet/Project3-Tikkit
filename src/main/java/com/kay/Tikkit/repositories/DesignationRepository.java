package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{
	
	Optional<Designation> findByDesignationName(String designationName);
	List<Designation> findByIsActiveTrue();
	boolean existsByIsActiveTrue();

}
