package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    static Long lastId = 1L;
    @Autowired
    UserRepository userRepository;
    public UserServiceImpl() {
    }

    @Override
    public User createUser(User user) {
        Long userId = lastId++;
        user.setUserId(userId);
        userRepository.save(user);
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User readUser(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
