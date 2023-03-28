package com.example.javaspringdemo.entities;

import javax.persistence.*;

@Entity(name = "user_experience")
public class UserExperience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int user_id;
    @Basic
    @Column(name = "experience_id")
    private int experience_id;

    public UserExperience() {
    }

    public UserExperience(int id, int user_id, int experience_id) {
        this.id = id;
        this.user_id = user_id;
        this.experience_id = experience_id;
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

    public int getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(int experience_id) {
        this.experience_id = experience_id;
    }
}
