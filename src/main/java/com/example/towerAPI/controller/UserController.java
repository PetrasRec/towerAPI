package com.example.towerAPI.controller;

import com.example.towerAPI.Service.UserService;
import com.example.towerAPI.exeption.ResourceNotFoundException;
import com.example.towerAPI.model.User;
import com.example.towerAPI.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name="id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLogin user, HttpServletResponse response) throws ResourceNotFoundException {
        var userID = userService.logIn(user);
        Cookie cookie = new Cookie("user_id", String.valueOf(userID));
        response.addCookie(cookie);
        return ResponseEntity.ok().body(Collections.singletonMap("id", userID));
    }
}
