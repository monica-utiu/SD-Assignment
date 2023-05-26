package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="question")
public class Question{
    @Id
    @Column(name="question_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="author")
    private User author;
    @Column
    private String title;
    @Column(name="text_question")
    private String text;
    @Column(name="creation")
    private Timestamp timeStamp;
    @Column(name="updated")
    private Timestamp updated;
    @Column(name="picture")
    private String image;
//    @OneToMany(mappedBy = "question")
//    private ArrayList<VoteQuestion> votes;
//    @ManyToMany()
//    @JoinTable(name="question_tag",
//    joinColumns = @JoinColumn(name = "question_id"),
//    inverseJoinColumns = @JoinColumn(name="tag"))
//    private ArrayList<Tags> tags;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "questionId",cascade = CascadeType.ALL)
    private List<Answer> answers;

//    public ArrayList<Tags> getTags() {
//        return tags;
//    }
//
//    public void setTags(ArrayList<Tags> tags) {
//        this.tags = tags;
//    }

    public Question() {

    }
    public Question(Integer id, User author, String title, String text, Timestamp timeStamp, String image, List<Answer> answers) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.timeStamp = timeStamp;
        this.image = image;
        this.answers = answers;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
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


//    public ArrayList<VoteQuestion> getVotes() {
//        return votes;
//    }
//
//    public void setVotes(ArrayList<VoteQuestion> votes) {
//        this.votes = votes;
//    }
}
