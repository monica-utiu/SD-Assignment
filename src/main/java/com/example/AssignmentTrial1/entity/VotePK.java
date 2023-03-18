package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class VotePK implements Serializable {
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
//    @ManyToOne
//    @Column(name="content_id")
    //private Content content;


}
