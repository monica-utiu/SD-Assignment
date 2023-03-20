package com.example.AssignmentTrial1.entity.votes;

import com.example.AssignmentTrial1.entity.votes.VotePKQ;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="vote_question")
public class VoteQuestion {
    @EmbeddedId
    private VotePKQ id;
    @Column
    private Integer vote;

    public VotePKQ getId() {
        return id;
    }

    public void setId(VotePKQ id) {
        this.id = id;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
