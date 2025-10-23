package com.kay.Tikkit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Role;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	List<UserRole> findByUser(User user);

    List<UserRole> findByRole(Role role);
    
    List<UserRole> findByRoleRoleName(String roleName);
    
    boolean existsByUserAndRole(User user, Role role);

}
