package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.User;

import java.util.List;

public interface UserService{
    User createUser(User userDetails);
    List<User> getAllUsers();
    UserDTO readUser(Long id);
    User updateUser(Long id,User user);
    void deleteUser(Long id);


}
