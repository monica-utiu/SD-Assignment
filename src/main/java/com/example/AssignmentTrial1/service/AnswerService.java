package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.Question;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Long userId, Integer questionId,Answer answer);

    List<AnswerDTO> getAllAnswers();
    AnswerDTO readAnswer(Integer id);

    QuestionAnswersDTO getQuestionsAnswer(Integer q_id);

    Answer updateAnswer(Integer id, Answer newAnswer);
    void deleteAnswer(Integer id);
}
