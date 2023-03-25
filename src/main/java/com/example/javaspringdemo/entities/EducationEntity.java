package com.example.javaspringdemo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "educations")
public class EducationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "school")
    private String school;
    @Basic
    @Column(name = "course")
    private String course;
    @Basic
    @Column(name = "level")
    private String level;

    @Basic
    @Column(name = "start_time")
    private Date start_time;
    @Basic
    @Column(name = "end_time")
    private Date end_time;
    @Basic
    @Column(name = "GPA")
    private float GPA;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
