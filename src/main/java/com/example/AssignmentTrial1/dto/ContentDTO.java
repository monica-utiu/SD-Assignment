package com.example.AssignmentTrial1.dto;

import java.time.LocalDateTime;

public class ContentDTO {
    private String text;
    private LocalDateTime creation;
    private String author;

    public ContentDTO(String text, LocalDateTime creation, String author) {
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

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
