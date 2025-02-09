package com.example.customerorders.service;

import com.example.customerorders.model.User;
import com.example.customerorders.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(String email, String password, String role) {
        logger.info("Register user with email: {}", email);


        if (userRepository.findByEmail(email).isPresent()) {
            logger.error("User with email {} already exists.", email);
            throw new IllegalArgumentException("User with this email already exists.");
        }


        User.Role userRole;
        try {
            userRole = User.Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Invalid role provided: {}. Allowed values: ADMIN, USER.", role);
            throw new IllegalArgumentException("Invalid role. Allowed values: ADMIN, USER.");
        }


        User user = new User(email, password, userRole);


        userRepository.save(user);
		logger.info("Register successful for user with email: {}", email);
		return user;
    }


    public Optional<User> loginUser(String email, String password) {
        logger.info("Login user with email: {}", email);

        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (password.equals(user.getPassword())) {
                logger.info("Login successful for user with email: {}", email);
                return Optional.of(user);
            } else {
                logger.warn("Incorrect password for user with email: {}", email);
            }
        } else {
            logger.warn("No user found with email: {}", email);
        }

        return Optional.empty();
    }
}
