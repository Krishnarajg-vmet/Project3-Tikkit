package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.enums.DepartmentType;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Optional<Department> findByDepartmentName(String departmentName);
	List<Department> findByDepartmentType(DepartmentType departmentType);
	List<Department> findAll();
	List<Department> findByBranchBranchName(String branchName);
	List<Department> findByBranchBranchId(Long id);
	List<Department> findByIsActiveTrue();
	boolean existsByIsActiveTrue();

}
