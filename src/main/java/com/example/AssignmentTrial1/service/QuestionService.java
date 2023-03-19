package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question questionDetails);
    List<QuestionDTO> getAllQuestions();
    QuestionDTO readQuestion(Integer id);
    Question updateQuestion(Integer id,Question newQuestion);
    void deleteQuestion(Integer id);
}
