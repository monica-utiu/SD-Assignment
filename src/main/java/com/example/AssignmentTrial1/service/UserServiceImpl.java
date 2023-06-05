package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.Role;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    static Long lastId = 10L;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailSenderService emailSenderService;
    public UserServiceImpl() {
    }

    @Override
    public User createUser(User user) {
        Long userId = lastId++;
        user.setUserId(userId);
        user.setRating(0.0F);
        user.setRol(Role.USER);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDTO readUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return new UserDTO(user.get().getUserId(), user.get().getEmail(),user.get().getFirstName(), user.get().getLastName(),
                    user.get().getPicture(), user.get().getPhone(), user.get().getRating(), user.get().isBanned());
        } else {
            return null;
        }
    }
    // update if id exists, else don't create it
    // you cannot change id, first name or role, my design rule
    @Override
    public User updateUser(Long id, User user) {
        Optional<User> user1 = userRepository.findById(id);
        if(user1.isPresent()) {
            User oldUser = user1.get();
            if(user.getEmail() != null)  oldUser.setEmail(user.getEmail());
            if(user.getPhone() != null)  oldUser.setPhone(user.getPhone());
            if(user.getRating() != null) oldUser.setRating(user.getRating());
            if(user.getLastName() != null) oldUser.setLastName(user.getLastName());
            if(user.getRating() != null) oldUser.setRating(user.getRating());
            if(user.isBanned() != oldUser.isBanned()) {
                oldUser.setBanned(user.isBanned());
                String body = oldUser.isBanned() ? "We are sorry, you have been banned from our site. Please check our policies." : "You have been unbanned!";
                emailSenderService.sendEmail(user.getEmail(),"Ban from stackoverflow",body);
            }
            return userRepository.save(oldUser);
        } else {
            return null; // ? save new data or not?
        }

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
