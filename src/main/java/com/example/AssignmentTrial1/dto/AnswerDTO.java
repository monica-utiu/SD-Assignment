package com.example.AssignmentTrial1.dto;

import java.time.LocalDateTime;

public class AnswerDTO extends ContentDTO{
    private String question;

    public AnswerDTO(String text, LocalDateTime creation, String author,String question) {
        super(text, creation, author);
        this.question = question;
    }
}
