package com.example.AssignmentTrial1.dto;

import com.example.AssignmentTrial1.entity.Tags;

import java.sql.Timestamp;
import java.util.List;

public class QuestionDTO extends ContentDTO {
    private String title;

    private List<AnswerDTO> answers;
    private List<Tags> tags;

    public QuestionDTO(Integer id, String text, Timestamp creation, UserDTO author, String title, List<AnswerDTO> answers, List<Tags> tags, Integer vote) {
        super(id, text,creation,author, vote);
        this.title = title;
        this.answers = answers;
        this.tags   = tags;
    }

    public QuestionDTO(Integer id, String text, Timestamp creation, UserDTO author, String title, List<AnswerDTO> answers) {
        super(id, text,creation,author);
        this.title = title;
        this.answers = answers;
    }

    public QuestionDTO(Integer id, String text, Timestamp creation, UserDTO author, String title) {
        super(id, text,creation,author);
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answersList) {
        this.answers = answersList;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
