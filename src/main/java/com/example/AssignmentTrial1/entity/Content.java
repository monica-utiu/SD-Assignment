package com.example.AssignmentTrial1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

@Table(name="content")
public abstract class Content {
    @Id
    private int id;

    private User author;
    private String title;
    private String text;
    private Date timeStamp;
    // idk ce se pune la imagini
    private String image;
    //private ArrayList<Vote> votes;

    public Content(int id, User author, String title, String text, Date timeStamp, String image, ArrayList<Vote> votes) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.timeStamp = timeStamp;
        this.image = image;
        //this.votes = votes;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public ArrayList<Vote> getVotes() {
//        return votes;
//    }
//
//    public void setVotes(ArrayList<Vote> votes) {
//        this.votes = votes;
//    }
}
