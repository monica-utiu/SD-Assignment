package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {
    @Autowired
    AnswerServiceImpl answerService;

    @GetMapping(path="/get/{a_id}")
    @ResponseBody
    public AnswerDTO getAnswer(@PathVariable Integer a_id) {
        return answerService.readAnswer(a_id);
    }
    @GetMapping(path="/getAll")
    @ResponseBody
    public List<AnswerDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }
    @GetMapping(path="getQuestionsAnswers/{q_id}")
    @ResponseBody
    public QuestionAnswersDTO getAnswers(@PathVariable Integer q_id) {
        return answerService.getQuestionsAnswer(q_id);
    }
    @PostMapping(path = "create/user/{u_id}/question/{q_id}")
    @ResponseBody
    public ResponseEntity<Answer> createAnswer(@PathVariable Long u_id,@PathVariable Integer q_id,@RequestBody Answer newAnswer) {
        Answer answer = answerService.createAnswer(u_id,q_id,newAnswer);
        if(answer==null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(answer,HttpStatus.CREATED);
    }

    @PutMapping(path="update/{a_id}")
    @ResponseBody
    public ResponseEntity<Answer> updateAnswer(@PathVariable Integer a_id,@RequestBody Answer answer) {
        Answer answer1 = answerService.updateAnswer(a_id,answer);
        if(answer1!=null)
            return new ResponseEntity<>(answer1,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(path="delete/{a_id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteAnswer(@PathVariable Integer a_id) {
        answerService.deleteAnswer(a_id);
        return new ResponseEntity<>(a_id,HttpStatus.OK);
    }


}

