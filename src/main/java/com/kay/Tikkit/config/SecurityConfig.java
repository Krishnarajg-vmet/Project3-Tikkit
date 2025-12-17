package com.kay.Tikkit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kay.Tikkit.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http,
	                                               JwtAuthenticationFilter jwtFilter) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())
	        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        )
	        	.authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/auth/**").permitAll()
	                .requestMatchers("/error").permitAll()
	                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**").permitAll()
	                .requestMatchers(HttpMethod.POST, "/api/auth/reset-password").permitAll()
	                .requestMatchers("/api/auth/check-reset/{username}").permitAll()
	                .requestMatchers("/login").permitAll()
	                

	                .requestMatchers("/view/home").permitAll()
	                .requestMatchers("/view/ticket/**").hasAuthority("VIEW_TICKET")
	                .requestMatchers("/view/ticket/dashboard").hasAuthority("VIEW_TICKET")
	                
	                // User Permisison
	                .requestMatchers("/api/users/{id}").hasAuthority("READ_USER")
	                .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasAuthority("UPDATE_USER")
	                .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasAuthority("DELETE_USER")
	                .requestMatchers("/api/users").hasAuthority("READ_USER")
	                .requestMatchers(HttpMethod.POST, "/api/users").hasAuthority("CREATE_USER")
	                .requestMatchers("/api/users/department/{departmentId}").hasAuthority("READ_USER")
	                .requestMatchers("/api/users/by-username/{username}").hasAuthority("READ_USER")
	                
	                // Ticket Permission
	                .requestMatchers("/api/tickets/{ticketId}").hasAuthority("READ_TICKETS")
	                .requestMatchers(HttpMethod.PUT, "/api/tickets/{ticketId}").hasAuthority("UPDATE_TICKET")
	                .requestMatchers("/api/tickets").hasAuthority("READ_TICKETS")
	                .requestMatchers(HttpMethod.POST, "/api/tickets").hasAuthority("CREATE_TICKET")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/resolve").hasAuthority("MODIFY_TICKET")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/reopen").hasAuthority("MODIFY_TICKET")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/inprogress").hasAuthority("MODIFY_TICKET")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/close").hasAuthority("UPDATE_TICKET")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/assign").hasAuthority("MODIFY_TICKET")
	                .requestMatchers("/api/tickets/paged").hasAuthority("READ_TICKETS")
	                
	                // Comment Permissions
	                .requestMatchers("/api/tickets/{ticketId}/comments/{commentId}").hasAuthority("READ_COMMENT")
	                .requestMatchers(HttpMethod.PUT, "/api/tickets/{ticketId}/comments/{commentId}").hasAuthority("UPDATE_COMMENT")
	                .requestMatchers(HttpMethod.DELETE, "/api/tickets/{ticketId}/comments/{commentId}").hasAuthority("DELETE_COMMENT")
	                .requestMatchers("/api/tickets/{ticketId}/comments").hasAuthority("READ_COMMENT")
	                .requestMatchers(HttpMethod.POST, "/api/tickets/{ticketId}/comments").hasAuthority("CREATE_COMMENT")
	                
	                // State Permissions
	                .requestMatchers("/api/states/{id}").hasAuthority("READ_STATE")
	                .requestMatchers(HttpMethod.PUT, "/api/states/{id}").hasAuthority("UPDATE_STATE")
	                .requestMatchers(HttpMethod.DELETE, "/api/states/{id}").hasAuthority("DELETE_STATE")
	                .requestMatchers("/api/states").hasAuthority("READ_STATE")
	                .requestMatchers(HttpMethod.POST, "/api/states").hasAuthority("CREATE_STATE")
	                .requestMatchers("/api/states/by-country/{countryId}").hasAuthority("READ_STATE")
	                
	                // Role Permissions
	                .requestMatchers("/api/roles/{id}").hasAuthority("READ_ROLE")
	                .requestMatchers(HttpMethod.PUT, "/api/roles/{id}").hasAuthority("UPDATE_ROLE")
	                .requestMatchers(HttpMethod.DELETE, "/api/roles/{id}").hasAuthority("DELETE_ROLE")
	                .requestMatchers("/api/roles").hasAuthority("READ_ROLE")
	                .requestMatchers(HttpMethod.POST, "/api/roles").hasAuthority("CREATE_ROLE")
	                .requestMatchers(HttpMethod.POST, "/api/roles/{roleId}/permissions/{permissionId}").hasAuthority("ASSIGN_PERMISSION_TO_ROLE")
	                .requestMatchers(HttpMethod.DELETE, "/api/roles/{roleId}/permissions/{permissionId}").hasAuthority("ASSIGN_PERMISSION_TO_ROLE")
	                
	                // Permission Permissions
	                .requestMatchers("/api/permissions/{id}").hasAuthority("READ_PERMISSION")
	                .requestMatchers(HttpMethod.PUT, "/api/permissions/{id}").hasAuthority("UPDATE_PERMISSION")
	                .requestMatchers(HttpMethod.DELETE, "/api/permissions/{id}").hasAuthority("DELETE_PERMISSION")
	                .requestMatchers("/api/permissions").hasAuthority("READ_PERMISSION")
	                .requestMatchers(HttpMethod.POST, "/api/permissions").hasAuthority("CREATE_PERMISSION")
	                
	                // Employee Permissions
	                .requestMatchers("/api/employees/{id}").hasAuthority("READ_EMPLOYEE")
	                .requestMatchers(HttpMethod.PUT, "/api/employees/{id}").hasAuthority("UPDATE_EMPLOYEE")
	                .requestMatchers(HttpMethod.DELETE, "/api/employees/{id}").hasAuthority("DELETE_EMPLOYEE")
	                .requestMatchers("/api/employees").hasAuthority("READ_EMPLOYEE")
	                .requestMatchers(HttpMethod.POST, "/api/employees").hasAuthority("CREATE_EMPLOYEE")
	                
	                // District Permissions
	                .requestMatchers("/api/districts/{id}").hasAuthority("READ_DISTRICT")
	                .requestMatchers(HttpMethod.PUT, "/api/districts/{id}").hasAuthority("UPDATE_DISTRICT")
	                .requestMatchers(HttpMethod.DELETE, "/api/districts/{id}").hasAuthority("DELETE_DISTRICT")
	                .requestMatchers("/api/districts").hasAuthority("READ_DISTRICT")
	                .requestMatchers(HttpMethod.POST, "/api/districts").hasAuthority("CREATE_DISTRICT")
	                .requestMatchers("/api/districts/by-state/{stateId}").hasAuthority("READ_DISTRICT")
	                
	                // Designation Permissions
	                .requestMatchers("/api/designations/{id}").hasAuthority("READ_DESIGNATION")
	                .requestMatchers(HttpMethod.PUT, "/api/designations/{id}").hasAuthority("UPDATE_DESIGNATION")
	                .requestMatchers(HttpMethod.DELETE, "/api/designations/{id}").hasAuthority("DELETE_DESIGNATION")
	                .requestMatchers("/api/designations").hasAuthority("READ_DESIGNATION")
	                .requestMatchers(HttpMethod.POST, "/api/designations").hasAuthority("CREATE_DESIGNATION")
	                
	                // Department Permissions
	                .requestMatchers("/api/departments/{id}").hasAuthority("READ_DEPARTMENT")
	                .requestMatchers(HttpMethod.PUT, "/api/departments/{id}").hasAuthority("UPDATE_DEPARTMENT")
	                .requestMatchers(HttpMethod.DELETE, "/api/departments/{id}").hasAuthority("DELETE_DEPARTMENT")
	                .requestMatchers("/api/departments").hasAuthority("READ_DEPARTMENT")
	                .requestMatchers(HttpMethod.POST, "/api/departments").hasAuthority("CREATE_DEPARTMENT")
	                
	                // Country Permissions
	                .requestMatchers(HttpMethod.PUT, "/api/countries/update/{id}").hasAuthority("UPDATE_COUNTRY")
	                .requestMatchers("/api/countries").hasAuthority("READ_COUNTRY")
	                .requestMatchers(HttpMethod.POST, "/api/countries").hasAuthority("CREATE_COUNTRY")
	                .requestMatchers("/api/countries/{id}").hasAuthority("READ_COUNTRY")
	                .requestMatchers(HttpMethod.DELETE, "/api/countries/delete/{id}").hasAuthority("DELETE_COUNTRY")
	                
	                // Complaint Permissions
	                .requestMatchers("/api/complaints/{id}").hasAuthority("READ_COMPLAINT")
	                .requestMatchers(HttpMethod.PUT, "/api/complaints/{id}").hasAuthority("UPDATE_COMPLAINT")
	                .requestMatchers(HttpMethod.DELETE, "/api/complaints/{id}").hasAuthority("DELETE_COMPLAINT")
	                .requestMatchers("/api/complaints").hasAuthority("READ_COMPLAINT")
	                .requestMatchers(HttpMethod.POST, "/api/complaints").hasAuthority("CREATE_COMPLAINT")
	                
	                // Company Permissions
	                .requestMatchers("/api/companies/{id}").hasAuthority("READ_COMPANY")
	                .requestMatchers(HttpMethod.PUT, "/api/companies/{id}").hasAuthority("UPDATE_COMPANY")
	                .requestMatchers(HttpMethod.DELETE, "/api/companies/{id}").hasAuthority("DELETE_COMPANY")
	                .requestMatchers("/api/companies").hasAuthority("READ_COMPANY")
	                .requestMatchers(HttpMethod.POST, "/api/companies").hasAuthority("CREATE_COMPANY")
	                
	                // City Permissions
	                .requestMatchers("/api/cities/{id}").hasAuthority("READ_CITY")
	                .requestMatchers(HttpMethod.PUT, "/api/cities/{id}").hasAuthority("UPDATE_CITY")
	                .requestMatchers(HttpMethod.DELETE, "/api/cities/{id}").hasAuthority("DELETE_CITY")
	                .requestMatchers("/api/cities").hasAuthority("READ_CITY")
	                .requestMatchers(HttpMethod.POST, "/api/cities").hasAuthority("CREATE_CITY")
	                .requestMatchers("/api/cities/by-district/{districtId}").hasAuthority("READ_CITY")
	                
	                // Branch Permissions
	                .requestMatchers("/api/branches/{id}").hasAuthority("READ_BRANCH")
	                .requestMatchers(HttpMethod.PUT, "/api/branches/{id}").hasAuthority("UPDATE_BRANCH")
	                .requestMatchers(HttpMethod.DELETE, "/api/branches/{id}").hasAuthority("DELETE_BRANCH")
	                .requestMatchers("/api/branches").hasAuthority("READ_BRANCH")
	                .requestMatchers(HttpMethod.POST, "/api/branches").hasAuthority("CREATE_BRANCH")
	                
	                // Area Permissions
	                .requestMatchers("/api/areas/{id}").hasAuthority("READ_AREA")
	                .requestMatchers(HttpMethod.PUT, "/api/areas/{id}").hasAuthority("UPDATE_AREA")
	                .requestMatchers(HttpMethod.DELETE, "/api/areas/{id}").hasAuthority("DELETE_AREA")
	                .requestMatchers("/api/areas").hasAuthority("READ_AREA")
	                .requestMatchers(HttpMethod.POST, "/api/areas").hasAuthority("CREATE_AREA")
	                
	                // Report Permissions
	                .requestMatchers("/api/reports/user-wise-tickets/detailed-report").hasAuthority("VIEW_USER_WISE_TICKETS_REPORT")
	                .requestMatchers("/api/reports/user-wise-tickets/consolidated-report").hasAuthority("VIEW_CONSOLIDATED_TICKET_REPORT")
	                
	                // Enum Permissions
	                .requestMatchers("/api/enums/title").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/ticketType").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/ticketStatus").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/ticketPriority").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/ticketCategory").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/products").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/maritalStatus").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/gender").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/employeeType").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/employeeCategory").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/departmentType").hasAuthority("READ_ENUMS")
	                .requestMatchers("/api/enums/bloodGroup").hasAuthority("READ_ENUMS")
	                
	                // Ticket History
	                .requestMatchers("/api/tickets/history/{ticketId}").hasAuthority("TICKET_HISTORY")
	                
	                .anyRequest().authenticated()
	        		    )
	        		    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	        		    .formLogin(form -> form
	        		    	    .loginPage("/login")
	        		    	    .loginProcessingUrl("/login")
	        		    	    .defaultSuccessUrl("/view/home", true)
	        		    	    .permitAll()
	        		    	).logout(logout -> logout
	        		    	        .logoutUrl("/logout")          // default is /logout
	        		    	        .logoutSuccessUrl("/login?logout") // redirect after logout
	        		    	        .invalidateHttpSession(true)
	        		    	        .deleteCookies("JSESSIONID")
	        		    	        .permitAll()
	        		    	    );
	    		
	        		return http.build();
	}


	
	@Bean 
	public PasswordEncoder passEncode() { 
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http,
	                                                   CustomUserDetailsService userDetailsService,
	                                                   PasswordEncoder passwordEncoder) throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .userDetailsService(userDetailsService)
	            .passwordEncoder(passwordEncoder)
	            .and()
	            .build();
	}
	
	

}
