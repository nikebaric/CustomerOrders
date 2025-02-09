package com.example.customerorders.controller;

import com.example.customerorders.model.User;
import com.example.customerorders.security.JWTtoken;
import com.example.customerorders.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final JWTtoken jwtToken;

    public UserController(UserService userService, JWTtoken jwtToken) {
        this.userService = userService;
        this.jwtToken = jwtToken;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        String role = request.get("role");

        if (email == null || password == null || role == null) {
            return ResponseEntity.badRequest().body("Missing required fields.");
        }


        User.Role userRole = (role.equalsIgnoreCase("ADMIN")) ? User.Role.ADMIN : User.Role.USER;


        User newUser = new User(email, password, userRole);


        User savedUser = userService.registerUser(newUser.getEmail(), newUser.getPassword(), newUser.getRole().toString());


        logger.info("User registered successfully with email: {}", savedUser.getEmail());


        return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", savedUser.getId()));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request, HttpSession session) {
        String email = request.get("email");
        String password = request.get("password");


        Optional<User> userOptional = userService.loginUser(email, password);

        if (userOptional.isPresent()) {

            User user = userOptional.get();
            String token = jwtToken.generateToken(user.getEmail(), user.getRole().name());


            session.setAttribute("token", token);


            logger.info("User logged in successfully with email: {}", user.getEmail());


            return ResponseEntity.ok(Map.of("message", "Login successful", "token", token));
        } else {

            logger.warn("Invalid login attempt for email: {}", email);
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }
}
