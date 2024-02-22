package com.example.boran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.example.boran.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.boran.model.User;
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
/*
    @PostMapping("/users")
    public ResponseEntity<User> createTutorial(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getLogin(), user.getDescription(), false));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 */
}
