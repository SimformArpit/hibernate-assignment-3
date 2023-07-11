package com.simform.assignment.controller;

import com.simform.assignment.entity.User;
import com.simform.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User userById = userService.getById(id);
        return new ResponseEntity<>(userById, HttpStatus.FOUND);
    }
}
