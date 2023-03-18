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
}
