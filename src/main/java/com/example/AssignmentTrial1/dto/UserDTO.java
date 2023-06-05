package com.example.AssignmentTrial1.dto;

import com.example.AssignmentTrial1.entity.User;

public class UserDTO {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private byte[] picture;
    private String phone;
    private Float rating;
    private boolean banned;

    public UserDTO() {

    }

    public UserDTO(Long userId, String email, String firstName, String lastName, byte[] picture, String phone, Float rating) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.phone = phone;
        this.rating = rating;

        System.out.println(this.rating);
    }

    public UserDTO(Long id, String firstName, String lastName, byte[] picture) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
    }

    public UserDTO(Long id, String firstName, String lastName) {
        this.userId =id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDTO(Long userId, String email, String firstName, String lastName, byte[] picture, String phone, Float rating, boolean banned) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.phone = phone;
        this.rating = rating;
        this.banned = banned;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
