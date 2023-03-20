package com.example.AssignmentTrial1.entity.votes;

import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.entity.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class VotePKQ implements Serializable {
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;


}
