package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.repository.QuestionRepository;
import com.example.AssignmentTrial1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
    static Integer id = 10;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Question createQuestion(Long userId, Question questionDetails) {
        // if i would have userRepository here i would check for the userId and get it
        Optional<User> author = userRepository.findById(userId);
        if(author.isPresent()) {
            questionDetails.setAuthor(author.get());
            // verify if i dont have to add to author the question to their list
            Integer qID = id++;
            questionDetails.setId(id);
            questionDetails.setTimeStamp(new Timestamp(System.currentTimeMillis()));
            questionRepository.save(questionDetails);
            return questionDetails;
        }
        return null;
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<QuestionDTO> questions = new ArrayList<>();
        questionRepository.findAll().forEach(q->questions.add(
                new QuestionDTO(q.getId(),q.getText(),q.getTimeStamp(),new UserDTO(q.getAuthor().getUserId(), q.getAuthor().getFirstName(), q.getAuthor().getLastName()), q.getTitle(),
                        q.getAnswersDTO())
        ));
        return questions;
    }

    @Override
    public QuestionDTO readQuestion(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question question1 = question.get();
            return new QuestionDTO(question1.getId(), question1.getText(),question1.getTimeStamp(), new UserDTO(question1.getAuthor().getUserId(), question1.getAuthor().getFirstName(),question1.getAuthor().getLastName()), question1.getTitle());
        }
        return null;
    }

    @Override
    public QuestionAnswersDTO readQuestionAndAnswer(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question question1 = question.get();
            QuestionDTO questionDTO  = new QuestionDTO(question1.getId(), question1.getText(),question1.getTimeStamp(),
                    new UserDTO(question1.getAuthor().getUserId(), question1.getAuthor().getFirstName(),question1.getAuthor().getLastName()),
                    question1.getTitle(),question1.getAnswersDTO());
            List<Answer> answers = question1.getAnswers();
            if(answers.isEmpty())
                return new QuestionAnswersDTO(questionDTO,null);
            else {
                List<AnswerDTO> answersDTO = new ArrayList<>();
                answers.forEach(a->answersDTO.add(new AnswerDTO(a.getId(),a.getText(),a.getTimeStamp(),new UserDTO(a.getAuthor().getUserId(), a.getAuthor().getFirstName(),a.getAuthor().getLastName()))));
                return new QuestionAnswersDTO(questionDTO,answersDTO);
            }
        }
        return null;
    }
    private void updateTime(Question question) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        question.setUpdated(date);
    }
    @Override
    public Question updateQuestion(Integer id, Question newQuestion) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question oldQ = question.get();
            if(newQuestion.getText()!=null) {
                oldQ.setText(newQuestion.getText());
                updateTime(oldQ);
            }
            if(newQuestion.getTitle()!=null)
            {
                oldQ.setTitle(newQuestion.getTitle());
                updateTime(oldQ);
            }
            if(newQuestion.getImage()!=null) {
                oldQ.setImage(newQuestion.getImage());
                updateTime(oldQ);
            }
            return questionRepository.save(oldQ);
        }
        return null;
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);

    }
}
