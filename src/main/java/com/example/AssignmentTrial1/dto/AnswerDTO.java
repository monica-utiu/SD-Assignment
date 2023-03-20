package com.example.AssignmentTrial1.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class AnswerDTO extends ContentDTO{
    private String question;


    public AnswerDTO(String text, Date creation, String author, String question) {
        super(text, creation, author);
        this.question = question;
    }

    public AnswerDTO(String text, Date creation, String author) {
        super(text,creation,author);
    }
}
