package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.dto.QuestionDTO;
import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.Tags;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.repository.QuestionRepository;
import com.example.AssignmentTrial1.repository.TagRepository;
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
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagRepository tagRepository;

    @Override
    public Question createQuestion(Long userId, Question questionDetails) {
        Optional<User> author = userRepository.findById(userId);
        if(author.isPresent()) {
            System.out.println("In create question" + questionDetails.getTags());
            questionDetails.getTags().forEach( t-> addTagToQuestion(questionDetails.getId(),t.getTitle()));
            questionDetails.setAuthor(author.get());
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
                new QuestionDTO(q.getId(),q.getText(),q.getTimeStamp(),
                        new UserDTO(q.getAuthor().getUserId(), q.getAuthor().getEmail(),q.getAuthor().getFirstName(), q.getAuthor().getLastName(), q.getAuthor().getPicture(), q.getAuthor().getPhone(),q.getAuthor().getRating()),
                        q.getTitle(), q.getAnswersDTO(), q.getTags(), q.getRating())
        ));
        return questions;
    }

    @Override
    public QuestionDTO readQuestion(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question question1 = question.get();
            return new QuestionDTO(question1.getId(), question1.getText(),question1.getTimeStamp(), new UserDTO(question1.getAuthor().getUserId(), question1.getAuthor().getFirstName(),question1.getAuthor().getLastName()), question1.getTitle(), question1.getAnswersDTO(), question1.getTags(), question1.getRating());
        }
        return null;
    }

    @Override
    public QuestionAnswersDTO readQuestionAndAnswer(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            Question question1 = question.get();
            QuestionDTO questionDTO  = new QuestionDTO(question1.getId(), question1.getText(),question1.getTimeStamp(),
                    new UserDTO(question1.getAuthor().getUserId(),question1.getAuthor().getEmail() ,question1.getAuthor().getFirstName(),question1.getAuthor().getLastName(), question1.getAuthor().getPicture(), question1.getAuthor().getPhone(),question1.getAuthor().getRating() ),
                    question1.getTitle(),question1.getAnswersDTO(),question1.getTags(), question1.getRating());
            List<Answer> answers = question1.getAnswers();
            if(answers.isEmpty())
                return new QuestionAnswersDTO(questionDTO,null);
            else {
                List<AnswerDTO> answersDTO = new ArrayList<>();
                answers.forEach(a->answersDTO.add(new AnswerDTO(a.getId(),a.getText(),a.getTimeStamp(),
                        new UserDTO(a.getAuthor().getUserId(), a.getAuthor().getEmail(), a.getAuthor().getFirstName(),a.getAuthor().getLastName(), a.getAuthor().getPicture(), a.getAuthor().getPhone(), a.getAuthor().getRating()),
                        a.getQuestionId().getText(),a.getRating())));
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
            if(newQuestion.getTags()!=null) {
                oldQ.setTags(newQuestion.getTags());
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


    public void addTagToQuestion(Integer questionId, String tagTitle) {
        Optional<Question> question = this.questionRepository.findById(questionId);
        if(question.isPresent()) {
            // Check if the tag already exists
            Tags tag = tagRepository.findByTitle(tagTitle);
            if (tag == null) {
                // Tag does not exist, create a new one
                tag = new Tags();
                tag.setTitle(tagTitle);
                System.out.println("Tag " + tagTitle);
                tagRepository.save(tag);
            }
            Question question1 = question.get();
            List<Tags> tags = question1.getTags();
            tags.add(tag);
            question1.setTags(tags);
            questionRepository.save(question1);
        }
    }
}
