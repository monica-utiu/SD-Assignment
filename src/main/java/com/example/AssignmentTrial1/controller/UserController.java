package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.service.UserService;
import com.example.AssignmentTrial1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    Map<String, User> users;
    @Autowired
    UserService userService;

    @GetMapping(path="/{userId}")
    @ResponseBody
    public User getUser(@PathVariable Integer userId) {
        return userService.readUser(userId);
    }

    @PostMapping
    public String createUser() {
        return "post";
    }

    @PutMapping
    public String updateUser() {
        return "put";
    }
    @DeleteMapping
    public String deleteUser() {
        return "delete";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUsers() {
       return userService.getAllUsers();
    }
}
