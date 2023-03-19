package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.repository.QuestionRepository;
import com.example.AssignmentTrial1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question questionDetails) {
        return null;
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return null;
    }

    @Override
    public QuestionDTO readQuestion(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question question1 = question.get();
            return new QuestionDTO( question1.getText(),question1.getTimeStamp(),question1.getAuthor().getFirstName()+question1.getAuthor().getLastName(),question1.getTitle());
        }
        return null;
    }

    @Override
    public Question updateQuestion(Integer id, Question newQuestion) {
        return null;
    }

    @Override
    public void deleteQuestion(Integer id) {

    }
}
