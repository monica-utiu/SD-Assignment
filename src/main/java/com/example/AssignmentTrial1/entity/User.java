package com.example.AssignmentTrial1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    private Long userId;
    @Column(name="f_name")
    private String firstName;
    @Column(name="l_name")
    private String lastName;
    @Column(name="e_mail")
    private String email;
    @Column
    private String phone;
    @Column
    private Float rating;
    @Column
    @Enumerated(EnumType.STRING)
    private Role rol;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Question> questions;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Answer> answer;
    //private String password;
//    @OneToMany(mappedBy = "user")
//    private List<VoteAnswer> voteAnswers;
//    @OneToMany(mappedBy = "user")
//    private List<VoteQuestion> voteQuestions;

    public User() {

    }

    public User(Long userId, String firstName, String lastName, String email, String phone, Float rating, Role rol) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.rating = rating;
        this.rol = rol;
    }

    public User(Long userId, String firstName, String lastName, String email, String phone, Float rating, Role rol, List<Question> questions, List<Answer> answer) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.rating = rating;
        this.rol = rol;
        this.questions = questions;
        this.answer = answer;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
