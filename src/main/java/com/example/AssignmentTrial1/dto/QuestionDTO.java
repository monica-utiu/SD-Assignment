package com.example.AssignmentTrial1.dto;


import java.time.LocalDateTime;

public class QuestionDTO extends ContentDTO {
    private String title;

    public QuestionDTO(String text, LocalDateTime creation, String author,String title) {
        super(text,creation,author);
        this.title = title;
    }
}
