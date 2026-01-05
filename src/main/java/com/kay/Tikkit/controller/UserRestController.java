package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kay.Tikkit.config.SecurityUtil;
import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.mapper.UserMapper;
import com.kay.Tikkit.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private final UserService userService;
	
	private final SecurityUtil securityUtil;
	
	 @Autowired
	    private ObjectMapper objectMapper;
	
	public UserRestController(UserService userService, SecurityUtil securityUtil) {
		this.userService = userService;
		this.securityUtil = securityUtil;
	}
	
	@PreAuthorize("hasAuthority('READ_USER')")
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PreAuthorize("hasAuthority('READ_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		UserDto user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasAuthority('CREATE_USER')")
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
		 try {
	            String jsonBody = objectMapper.writeValueAsString(dto);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		System.out.println("Received UserDto: " + dto.getEmployeeId());
		UserDto created = userService.createUser(dto);
		return ResponseEntity.ok(created);
	}
	
	@PreAuthorize("hasAuthority('UPDATE_USER')")
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
		UserDto updated = userService.editUser(userDto, id);
		return ResponseEntity.ok(updated);
	}
	
	@PreAuthorize("hasAuthority('DELETE_USER')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('READ_USER')")
	 @GetMapping("/department/{departmentId}")
	    public ResponseEntity<List<UserDto>> getUsersByDepartment(@PathVariable Long departmentId) {
	        List<UserDto> users = userService.getUsersByDepartment(departmentId);
	        return ResponseEntity.ok(users);
	    }
	
	@PreAuthorize("hasAuthority('READ_USER')")
	 @GetMapping("/by-username/{username}")
	 public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
	     User user = userService.getUserByUsername(username);
	     return ResponseEntity.ok(UserMapper.toDto(user));
	 }
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/current")
	public ResponseEntity<UserDto> getCurrentUser() {
	    User user = securityUtil.getCurrentUser(); // your app User entity
	    if (user != null) {
	        return ResponseEntity.ok(UserMapper.toDto(user)); // map to UserDto with userName, departmentId, etc.
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}


}
