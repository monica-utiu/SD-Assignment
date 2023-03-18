package com.example.AssignmentTrial1.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class ContentPK implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
