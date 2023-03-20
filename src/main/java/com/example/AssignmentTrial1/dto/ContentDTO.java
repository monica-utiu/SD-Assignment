package com.example.AssignmentTrial1.dto;

import java.time.LocalDateTime;
import java.sql.Date;

public class ContentDTO {
    private String text;
    private Date creation;
    private String author;

    public ContentDTO(String text, Date creation, String author) {
        this.text = text;
        this.creation = creation;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
