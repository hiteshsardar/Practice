package org.com.practice.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.com.practice.entity.Users;
import org.com.practice.repo.UserRepo;
import org.com.practice.service.JWTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUser {
    private final Logger logger = LoggerFactory.getLogger(AuthUser.class);
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JWTService jwtService;

    public AuthUser(UserRepo userRepo, AuthenticationManager authenticationManager, PasswordEncoder encoder, JWTService jwtService) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/createUser")
    public Users saveUser(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Users savedUser = userRepo.save(user);
        logger.info("User saved successfully");
        return savedUser;
    }

    @PostMapping("/login")
    public String login(@RequestBody ObjectNode node) {
        String email = node.get("email").asText();
        String pass = node.get("password").asText();

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, pass));
        if (auth.isAuthenticated()) {
            logger.info("User logged in successfully");
            return jwtService.generateToken(email);
        }
        return null;
    }
}
