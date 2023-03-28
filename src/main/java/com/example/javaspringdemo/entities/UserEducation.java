package com.example.javaspringdemo.entities;

import javax.persistence.*;

@Entity(name = "user_education")
public class UserEducation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int user_id;
    @Basic
    @Column(name = "education_id")
    private int education_id;

    public UserEducation() {
    }

    public UserEducation(int id, int user_id, int education_id) {
        this.id = id;
        this.user_id = user_id;
        this.education_id = education_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }
}
