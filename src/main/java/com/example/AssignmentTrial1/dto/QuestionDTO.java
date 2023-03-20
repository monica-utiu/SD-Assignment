package com.example.AssignmentTrial1.dto;


import java.time.LocalDateTime;
import java.sql.Date;

public class QuestionDTO extends ContentDTO {
    private String title;

    public QuestionDTO(String text, Date creation, String author, String title) {
        super(text,creation,author);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
