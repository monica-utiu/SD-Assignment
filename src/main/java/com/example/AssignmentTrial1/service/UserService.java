package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.User;

import java.util.List;

public interface UserService{
    User createUser(User userDetails);
    List<User> getAllUsers();
    User readUser(Integer id);
    User updateUser(User user);
    void deleteUser(int id);


}
