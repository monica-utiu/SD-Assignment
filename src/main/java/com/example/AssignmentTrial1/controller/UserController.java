package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.entity.votes.VoteAnswer;
import com.example.AssignmentTrial1.service.UserService;
import com.example.AssignmentTrial1.service.UserServiceImpl;
import com.example.AssignmentTrial1.service.VoteAnswerService;
import com.example.AssignmentTrial1.service.VoteQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    VoteQuestionService voteQuestionService;
    @Autowired
    VoteAnswerService voteAnswerService;

    @GetMapping(path="/getUser/{user_id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable Long user_id) {
        return userService.readUser(user_id);
    }

//    @GetMapping(path="getUserScore/{u_id}")
//    @ResponseBody
//    public Float getScore(@PathVariable Long u_id) {
//        float answerScore = this.voteAnswerService.getAllAnswerVotesTowardsUser(u_id) == null ? 0 :
//                this.voteAnswerService.getAllVotesTowardsUser(u_id).stream().map(vote -> {
//            int voteValue = vote.getVote();
//            if (voteValue == 1) {
//                return 5f;
//            } else if (voteValue == -1) {
//                return -2.5f;
//            } else {
//                return 0f;
//            }
//        }).reduce(0f,Float::sum);
//
//        float questionScore = this.voteQuestionService.getAllVotesTowardsUser(u_id) == null ? 0:
//            this.voteQuestionService.getAllVotesTowardsUser(u_id).stream().map(vote -> {
//            int voteValue = vote.getVote();
//            if (voteValue == 1) {
//                return 2.5f;
//            } else if (voteValue == -1) {
//                return -1.5f;
//            } else {
//                return 0f;
//            }
//        }).reduce(0f,Float::sum);
//
//        float userAnswerScore = this.voteAnswerService.getAllVotesOfUser(u_id) == null ? 0 :
//                this.voteAnswerService.getAllVotesOfUser(u_id).stream().map(vote -> {
//            int voteValue = vote.getVote();
//            if(voteValue == -1)
//                return -1.5f;
//            else return 0f;
//        }).reduce(0f,Float::sum);
//        Float finalScore = answerScore+questionScore+userAnswerScore;
//        User updateUser = new User();
//        updateUser.setRating(finalScore);
//        updateUser(u_id, updateUser);
//        return finalScore;
//    }

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

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers() {
       return userService.getAllUsers();
    }
}
