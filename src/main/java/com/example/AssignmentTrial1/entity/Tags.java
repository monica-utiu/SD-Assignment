package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tags {
    @Id
    private int id;
    @Column
    private String tag;
    @Column(name="question_id")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "tags")
    private List<Question> question = new ArrayList<>();

}
