package com.kay.Tikkit.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.dto.UserDto;
import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.config.JwtUtil;
import com.kay.Tikkit.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/check-reset/{username}")
    public boolean checkResetRequired(@PathVariable String username) {
        return userService.isPasswordResetRequired(username);
    }
    
    @PostMapping("/reset-password")
    public UserDto resetPassword(@RequestParam Long userId,
                                 @RequestParam String newPassword) {
        return userService.resetPassword(userId, newPassword);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password, HttpServletRequest httpRequest) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            if (userService.isPasswordResetRequired(username)) {
                User user = userService.getUserByUsername(username);
                return ResponseEntity.ok(Map.of(
                    "status", "RESET_REQUIRED",
                    "userId", user.getUserId(),
                    "username", user.getUserName()
                ));
            }


            User user = userService.getUserByUsername(username);
            String token = jwtUtil.generateToken(user);
            
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(auth);
            SecurityContextHolder.setContext(context);
            
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                context
            );

            return ResponseEntity.ok(Map.of(
                    "status", "LOGIN_SUCCESS",
                    "token", token
            ));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("INVALID_CREDENTIALS");
        }
    }
}
