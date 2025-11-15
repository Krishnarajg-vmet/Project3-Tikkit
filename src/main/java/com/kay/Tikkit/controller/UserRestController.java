package com.kay.Tikkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private final UserService userService;
	
	 @Autowired
	    private ObjectMapper objectMapper;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		UserDto user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
		 try {
	            String jsonBody = objectMapper.writeValueAsString(dto);
	            System.out.println("Raw request body: " + jsonBody);  // Log the raw JSON request
	            System.out.println("Received UserDto: " + dto.getEmployeeId());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		System.out.println("Received UserDto: " + dto.getEmployeeId());
		UserDto created = userService.createUser(dto);
		return ResponseEntity.ok(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
		UserDto updated = userService.editUser(userDto, id);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
