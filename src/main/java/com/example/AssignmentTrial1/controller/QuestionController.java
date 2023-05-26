package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping(path="/getQuestion/{q_id}")
    @ResponseBody
    public QuestionDTO getQuestion(@PathVariable Integer q_id) {
        return questionService.readQuestion(q_id);
    }

    @GetMapping(path="/getQuestionAndAnswers/{q_id}")
    @ResponseBody
    public QuestionAnswersDTO getQuestionWithAnswer(@PathVariable Integer q_id) {
        return questionService.readQuestionAndAnswer(q_id);
    }

    @GetMapping(path="/getAllQuestions")
    @ResponseBody
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @PostMapping(path="create/user/{u_id}")
    @ResponseBody
    public ResponseEntity<Question> createQuestion(@PathVariable Long u_id, @RequestBody Question newQuestion) {
        Question question = questionService.createQuestion(u_id,newQuestion);
        if(question==null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(question,HttpStatus.CREATED);
    }
    @PutMapping(path="update/{q_id}")
    @ResponseBody
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer q_id,@RequestBody Question questionDetails) {
        Question question = questionService.updateQuestion(q_id,questionDetails);
        if( question!= null)
            return new ResponseEntity<>(question,HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(path="delete/{q_id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteQuestion(@PathVariable Integer q_id) {
        questionService.deleteQuestion(q_id);
        return new ResponseEntity<>(q_id,HttpStatus.OK);
    }
    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }
}