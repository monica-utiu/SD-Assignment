//package com.example.AssignmentTrial1.service;
//
//import com.example.AssignmentTrial1.dto.AnswerDTO;
//import com.example.AssignmentTrial1.dto.ContentDTO;
//import com.example.AssignmentTrial1.dto.QuestionDTO;
//import com.example.AssignmentTrial1.entity.Answer;
//import com.example.AssignmentTrial1.entity.Content;
//import com.example.AssignmentTrial1.entity.Question;
//import com.example.AssignmentTrial1.repository.ContentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ContentServiceImpl implements ContentService {
//    @Autowired
//    ContentRepository contentRepository;
//    @Override
//    public Content createQuestion(Question questionDetails) {
//        return null;
//    }
//
//    @Override
//    public List<QuestionDTO> getAllQuestions() {
//        return null;
//    }
//
//    @Override
//    public QuestionDTO readQuestion(Integer id) {
//        Optional<Content> content = contentRepository.findById(id);
//        if(content.isPresent()) {
//            Content content1 = content.get();
//            if(content1.getContentId().getId()==id) {
//                return new QuestionDTO(content1.getText(),content1.getTimeStamp(),content1.getAuthor().getFirstName()+content1.getAuthor().getLastName(),content1.getContentId().getTitle());
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Question updateQuestion(Integer id, Question newQuestion) {
//        return null;
//    }
//
//    @Override
//    public void deleteQuestion(Integer id) {
//
//    }
//
//    @Override
//    public Content createAnswer(Answer answerDetails) {
//        return null;
//    }
//
//    @Override
//    public List<AnswerDTO> getAllAnswers() {
//        return null;
//    }
//
//    @Override
//    public AnswerDTO readAnswer(Integer id) {
//        Optional<Content> content = contentRepository.findById(id);
//        if(content.isPresent()) {
//            Content content1 = content.get();
//            if(content1.getContentId().getId()!=id ) {
//                QuestionDTO questionDTO = readQuestion(content1.getContentId().getId());
//                if(questionDTO!=null)
//                    return new AnswerDTO(content1.getText(),content1.getTimeStamp(),content1.getAuthor().getFirstName()+content1.getAuthor().getLastName(),questionDTO.getText());
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Answer updateAnswer(Integer id, Answer newAnswer) {
//        return null;
//    }
//
//    @Override
//    public void deleteAnswer(Integer id) {
//
//    }
//
//    @Override
//    public List<ContentDTO> getAllQuestionsWithAnswers() {
//        return null;
//    }
//
//    @Override
//    public List<ContentDTO> getQuestionWithAnswer(Integer id) {
//        return null;
//    }
//}
