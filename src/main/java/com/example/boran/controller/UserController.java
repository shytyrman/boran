package com.example.boran.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.boran.model.Currency;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.example.boran.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.example.boran.model.User;
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        System.out.println("Phone number: " + user.getPhoneNumber());
        Optional<User> findUser = userRepository.findUserByPhoneNumber(user.getPhoneNumber());
        System.out.println("User: " + findUser);
        if (findUser.isPresent()) {
            return new ResponseEntity<String>("User with this phone number exist", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPhoneNumber());
        userRepository.save(user);
        return new ResponseEntity<String>("Succesfully registered", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<User>();
            userRepository.findAll().forEach(users::add);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/current_user")
    public ResponseEntity<String> fetchUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println(username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

}
