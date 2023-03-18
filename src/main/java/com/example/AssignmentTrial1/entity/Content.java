package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

@MappedSuperclass
public abstract class Content {
    @Id
    @Column(name="content_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="to_content_id")
    private Question contentId;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "user_id")
    private User author;
    @Column
    private String title;
    @Column(name="text_content")
    private String text;
    @Column(name="creation")
    private LocalDateTime timeStamp;
    // idk ce se pune la imagini
    @Column(name="picture")
    private String image;
    @OneToMany()
    @JoinColumn(name="content_id")
    private ArrayList<Vote> votes;

    public Content(Integer id, User author, String title, String text, LocalDateTime timeStamp, String image, ArrayList<Vote> votes) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.timeStamp = timeStamp;
        this.image = image;
        this.votes = votes;
    }

    public Content() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Question getContentId() {
        return contentId;
    }

    public void setContentId(Question contentId) {
        this.contentId = contentId;
    }
}
