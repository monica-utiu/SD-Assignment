package com.example.AssignmentTrial1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tag_id")
    private Integer tagId;
    @Column
    private String title;
    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<Question> questions = new ArrayList<>();

    public Tags() {
    }

    public Tags(Integer tagId, String title, List<Question> questions) {
        this.tagId = tagId;
        this.title = title;
        this.questions = questions;
    }


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
