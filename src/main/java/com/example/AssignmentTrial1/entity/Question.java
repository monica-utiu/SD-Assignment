package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name="content")
public class Question extends Content{

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="question_tag",
    joinColumns = @JoinColumn(name = "content_id"),
    inverseJoinColumns = @JoinColumn(name="tag_id"))
    private ArrayList<Tags> tags;
    @OneToMany(mappedBy = "content_id")
    // modificat pk la content ca nu pot s afac selfrefrencing
    @Column(name="question_id")
    private ArrayList<Answer> answers ;

}
