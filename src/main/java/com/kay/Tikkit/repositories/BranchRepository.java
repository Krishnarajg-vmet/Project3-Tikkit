package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
	
	Optional<Branch> findById(Long id);
	List<Branch> findByIsActiveTrue();
	Optional<Branch> findByBranchName(String branchName);
	List<Branch> findByCompanyCompanyName(String companyName);
	List<Branch> findByCompanyCompanyId(Long companyId);
	Optional<Branch> findByAreaAreaName(String areaName);
	boolean existsByBranchName(String branchName);
	boolean existsByAreaAreaName(String areaName);
	boolean existsByCompanyCompanyName(String companyName);

}
