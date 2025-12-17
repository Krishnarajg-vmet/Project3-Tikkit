package com.kay.Tikkit.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.kay.Tikkit.entity.User;
import com.kay.Tikkit.repositories.UserRepository;

import java.util.Optional;

@Component
public class SecurityUtil {

    private final UserRepository userRepository;

    public SecurityUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : null;
    }

    public Long getCurrentUserId() {
        String username = getCurrentUserName();

        if (username != null) {
            Optional<User> optionalUser = userRepository.findByUserName(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                return user.getUserId();
            }
        }
        return null;
    }

    public User getCurrentUser() {
        String username = getCurrentUserName();

        if (username != null) {
            Optional<User> optionalUser = userRepository.findByUserName(username);
            return optionalUser.orElse(null);
        }
        return null;
    }
}
