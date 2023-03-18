package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name="content")
public class Question extends Content{

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="question_tag",
    joinColumns = @JoinColumn(name = "content_id"),
    inverseJoinColumns = @JoinColumn(name="tag_id"))
    private ArrayList<Tags> tags;
    @OneToMany(mappedBy = "to_content_id")
    private ArrayList<Answer> answers ;

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
