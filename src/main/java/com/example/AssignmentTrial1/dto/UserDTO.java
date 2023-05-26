package com.example.AssignmentTrial1.dto;

import com.example.AssignmentTrial1.entity.User;

public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String picture="";

    public UserDTO() {

    }

    public UserDTO(Long id, String firstName, String lastName, String picture) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture ="";
    }

    public UserDTO(Long id, String firstName, String lastName) {
        this.userId =id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
