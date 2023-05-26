package com.example.AssignmentTrial1.dto;
import java.sql.Timestamp;
import java.util.List;

public class QuestionDTO extends ContentDTO {
    private String title;
    private List<String> answersList;

    public QuestionDTO(Integer id, String text, Timestamp creation, UserDTO author, String title, List<String> answers) {
        super(id, text,creation,author);
        this.title = title;
        this.answersList = answers;
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

    public List<String> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<String> answersList) {
        this.answersList = answersList;
    }
}
