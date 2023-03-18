package com.example.AssignmentTrial1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {
    @EmbeddedId
    private VotePK id;
    @Column
    private Integer vote;

    public VotePK getId() {
        return id;
    }

    public void setId(VotePK id) {
        this.id = id;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
