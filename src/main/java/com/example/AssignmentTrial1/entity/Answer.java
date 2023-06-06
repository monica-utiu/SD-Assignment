package com.example.AssignmentTrial1.entity;

import com.example.AssignmentTrial1.entity.votes.VoteAnswer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="answer")
public class Answer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question questionId;
    @JsonIgnore
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
    @Column
    private Integer rating;
    @JsonIgnore
    @OneToMany(mappedBy = "answer",cascade = CascadeType.REMOVE)
    private List<VoteAnswer> votes = new ArrayList<>();


    public Answer(Integer id, Question questionId, User author, String text, Timestamp timeStamp, Timestamp updated, String image, ArrayList<VoteAnswer> votes) {
        this.id = id;
        this.questionId = questionId;
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
        this.updated = updated;
        this.image = image;
        this.votes = votes;
    }

    public List<VoteAnswer> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteAnswer> votes) {
        this.votes = votes;
    }

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

    public Answer(Integer id, Question questionId, User author, String text, Timestamp timeStamp, Timestamp updated, String image) {
        this.id = id;
        this.questionId = questionId;
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
        this.updated = updated;
        this.image = image;
    }

    public Answer(Integer id, Question questionId, User author, String text, Timestamp timeStamp, Timestamp updated, String image, Integer rating, List<VoteAnswer> votes) {
        this.id = id;
        this.questionId = questionId;
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
        this.updated = updated;
        this.image = image;
        this.rating = rating;
        this.votes = votes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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
