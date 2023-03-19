package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping(path="/getQuestion/{q_id}")
    public QuestionDTO getQuestion(@PathVariable Integer q_id) {
        return questionService.readQuestion(q_id);
    }

    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }
}
