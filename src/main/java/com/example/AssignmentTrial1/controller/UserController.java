package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.service.UserService;
import com.example.AssignmentTrial1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    // Map<String, User> users;
    @Autowired
    UserServiceImpl userService;

    @GetMapping(path="/get/{user_id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable Long user_id) {
        return userService.readUser(user_id);
    }

    @PostMapping(path = "create")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User user = userService.createUser(newUser);
        if (user == null) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

    @PutMapping(path="update/{user_id}")
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable Long user_id, @RequestBody User userDetails) {
        User user = userService.updateUser(user_id, userDetails);
        if( user!= null)
            return new ResponseEntity<>(user,HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(path="delete/{user_id}")
    @ResponseBody
    public ResponseEntity<Long> deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return new ResponseEntity<>(user_id, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<UserDTO> getAllUsers() {
       return userService.getAllUsers();
    }
}
