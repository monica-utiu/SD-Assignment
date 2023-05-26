package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name="answer")
public class Answer{
    @Id
    @Column(name="answer_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question questionId;
    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
    @Column(name="text_answer")
    private String text;
    @Column(name="creation")
    private Timestamp timeStamp;
    // idk ce se pune la imagini
    @Column(name="updated")
    private Timestamp updated;
    @Column(name="picture")
    private String image;
//    @OneToMany(mappedBy = "answer")
//    private ArrayList<VoteAnswer> votes = new ArrayList<>();

    public Answer() {

    }
    public Answer(Integer id, Question questionId, User author, String text, Timestamp timeStamp, String image) {
        this.id = id;
        this.questionId = questionId;
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
        this.image = image;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
