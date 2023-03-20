package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.repository.AnswerRepository;
import com.example.AssignmentTrial1.repository.QuestionRepository;
import com.example.AssignmentTrial1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService{
    static Integer id=10;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Answer createAnswer(Long userId, Integer q_id, Answer answer) {
        Optional<User> author = userRepository.findById(userId);
        Optional<Question> question = questionRepository.findById(q_id);
        if(author.isPresent() && question.isPresent()) {
            answer.setQuestionId(question.get());
            answer.setAuthor(author.get());
            answer.setId(id++);
            answer.setTimeStamp(new Date(System.currentTimeMillis()));
            answerRepository.save(answer);
            return answer;
        }
        return null;
    }

    @Override
    public List<AnswerDTO> getAllAnswers() {
        List<AnswerDTO> answer = new ArrayList<>();
        answerRepository.findAll().forEach(a->answer.add(new AnswerDTO(a.getText(),a.getTimeStamp(),a.getAuthor().getFirstName()+a.getAuthor().getLastName(),a.getQuestionId().getTitle())));
        return answer;
    }

    @Override
    public AnswerDTO readAnswer(Integer id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()) {
            Answer answer1 = answer.get();
            return new AnswerDTO(answer1.getText(),answer1.getTimeStamp(),answer1.getAuthor().getFirstName()+answer1.getAuthor().getLastName(),answer1.getQuestionId().getTitle() +answer1.getQuestionId().getText());
        }
        return null;
    }
    @Override
    public QuestionAnswersDTO getQuestionsAnswer(Integer q_id) {
        QuestionAnswersDTO result = new QuestionAnswersDTO();
        answerRepository.findAll().forEach(a-> {
            if(Objects.equals(a.getQuestionId().getId(), q_id)) {
                result.getAnswers().add(new AnswerDTO(a.getText(),a.getTimeStamp(),a.getAuthor().getFirstName()+a.getAuthor().getLastName()));
                Question q = a.getQuestionId();
                result.setQuestion(new QuestionDTO(q.getText(),q.getTimeStamp(),q.getAuthor().getFirstName()+q.getAuthor().getLastName(),q.getTitle()));
            }
        });
        return result;
    }
    private void updateTime(Answer answer) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        answer.setUpdated(sqlDate);
    }
    @Override
    public Answer updateAnswer(Integer id, Answer newAnswer) {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()) {
            Answer oldA = answer.get();
            if(newAnswer.getText()!= null) {
                oldA.setText(newAnswer.getText());
                updateTime(oldA);
            }
            if(newAnswer.getImage()!=null) {
                oldA.setImage(newAnswer.getImage());
                updateTime(oldA);
            }
            return answerRepository.save(oldA);
        }
        return null;
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerRepository.deleteById(id);

    }
}
