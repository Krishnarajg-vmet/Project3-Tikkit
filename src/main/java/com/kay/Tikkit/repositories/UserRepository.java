package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);
	
	Optional<User> findByUserId(Long userId);
	
	List<User> findByRoleRoleId(Long roleId);
	
	List<User> findByDepartmentDepartmentId(Long departmentId);
	
	boolean existsByUserName(String userName);

}
