package com.example.AssignmentTrial1.entity.votes;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="vote_answer")
public class VoteAnswer {
    @EmbeddedId
    private VotePKA id;
    @Column
    private Integer vote;

    public VotePKA getId() {
        return id;
    }

    public void setId(VotePKA id) {
        this.id = id;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
