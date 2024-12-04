package org.com.practice.controller;

import org.com.practice.entity.Users;
import org.com.practice.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    public UserController(UserRepo userRepo, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.userRepo = userRepo;
    }

    @GetMapping("/getAllUsers")
    public List<Users> getUsers(){
        logger.info("Fetching all users");
        return  userRepo.findAll();
    }
}
