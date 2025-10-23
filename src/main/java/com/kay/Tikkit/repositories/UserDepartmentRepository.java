package com.kay.Tikkit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Department;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserDepartment;

@Repository
public interface UserDepartmentRepository extends JpaRepository<UserDepartment, Long> {
	
	List<UserDepartment> findByUser(User user);

    List<UserDepartment> findByDepartment(Department department);

    boolean existsByUserAndDepartment(User user, Department department);
    
    List<UserDepartment> findByUserUserName(String userName);
    
    List<UserDepartment> findByDepartmentDepartmentCode(String departmentCode);

}
