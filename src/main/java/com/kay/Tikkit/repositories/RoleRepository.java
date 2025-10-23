package com.kay.Tikkit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByRoleName(String roleName);
	
	boolean existsByRoleName(String roleName);

}
