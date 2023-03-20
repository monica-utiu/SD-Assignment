//package com.example.AssignmentTrial1.service;
//
//import com.example.AssignmentTrial1.dto.AnswerDTO;
//import com.example.AssignmentTrial1.dto.ContentDTO;
//import com.example.AssignmentTrial1.dto.QuestionDTO;
//import com.example.AssignmentTrial1.dto.UserDTO;
//import com.example.AssignmentTrial1.entity.Answer;
//import com.example.AssignmentTrial1.entity.Content;
//import com.example.AssignmentTrial1.entity.Question;
//import com.example.AssignmentTrial1.entity.User;
//
//import java.util.List;
//
//public interface ContentService {
//    Content createQuestion(Question questionDetails);
//    List<QuestionDTO> getAllQuestions();
//    QuestionDTO readQuestion(Integer id);
//    Question updateQuestion(Integer id,Question newQuestion);
//    void deleteQuestion(Integer id);
//    Content createAnswer(Answer answerDetails);
//    List<AnswerDTO> getAllAnswers();
//    AnswerDTO readAnswer(Integer id);
//    Answer updateAnswer(Integer id,Answer newAnswer);
//    void deleteAnswer(Integer id);
//    List<ContentDTO> getAllQuestionsWithAnswers();
//    List<ContentDTO> getQuestionWithAnswer(Integer id);
//
//}
