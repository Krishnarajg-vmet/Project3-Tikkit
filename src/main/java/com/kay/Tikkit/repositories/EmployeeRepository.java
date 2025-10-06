package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Employee;
import com.kay.Tikkit.enums.EmployeeCategory;
import com.kay.Tikkit.enums.EmployeeType;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findByEmployeeCode(String employeeCode);
    
    Optional<Employee> findByMobileNumber(String mobileNumber);
    
    List<Employee> findByEmployeeType(EmployeeType employeeType);
    
    List<Employee> findByEmployeeCategory(EmployeeCategory employeeCategory);
    
    List<Employee> findByDepartmentDepartmentName(String departmentName);
    
    List<Employee> findByIsActiveTrue();
    
    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    
    Optional<Employee> findByFirstName(String firstName);
    
    List<Employee> findByLocationBranchName(String branchName);
    
    List<Employee> findByDesignationDesignationName(String designationName);
    
    List<Employee> findByAreaAreaName(String areaName);
}
