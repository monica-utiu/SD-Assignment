package com.example.AssignmentTrial1.dto;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.User;
import java.sql.Timestamp;

public class AnswerDTO extends ContentDTO{
    private String question;

    public AnswerDTO(Integer id,String text, Timestamp creation, UserDTO author, String question, Integer vote) {
        super(id, text, creation, author, vote);
        this.question = question;
    }

    public AnswerDTO(Integer id, String text, Timestamp creation, UserDTO author) {
        super(id,text,creation,author);
    }

    public AnswerDTO(Answer answer) {
        super(answer.getId(), answer.getText(), answer.getTimeStamp(),
                new UserDTO(answer.getAuthor().getUserId(), answer.getAuthor().getFirstName(), answer.getAuthor().getLastName()));
        this.question = answer.getQuestionId().getText();
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
