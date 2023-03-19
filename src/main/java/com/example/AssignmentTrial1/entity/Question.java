package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name="question")
public class Question{
    @Id
    @Column(name="question_id")
    private Integer id;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn
    private User author;
    @Column
    private String title;
    @Column(name="text_question")
    private String text;
    @Column(name="creation")
    private LocalDateTime timeStamp;
    // idk ce se pune la imagini
    @Column(name="picture")
    private String image;
//    @OneToMany(mappedBy = "question")
//    private ArrayList<VoteQuestion> votes;
//    @ManyToMany()
//    @JoinTable(name="question_tag",
//    joinColumns = @JoinColumn(name = "question_id"),
//    inverseJoinColumns = @JoinColumn(name="tag"))
//    private ArrayList<Tags> tags;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "questionId")
    private ArrayList<Answer> answers = new ArrayList<>();

//    public ArrayList<Tags> getTags() {
//        return tags;
//    }
//
//    public void setTags(ArrayList<Tags> tags) {
//        this.tags = tags;
//    }

    public Question() {

    }
    public Question(Integer id, User author, String title, String text, LocalDateTime timeStamp, String image, ArrayList<Answer> answers) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.timeStamp = timeStamp;
        this.image = image;
        this.answers = answers;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


//    public ArrayList<VoteQuestion> getVotes() {
//        return votes;
//    }
//
//    public void setVotes(ArrayList<VoteQuestion> votes) {
//        this.votes = votes;
//    }
}
