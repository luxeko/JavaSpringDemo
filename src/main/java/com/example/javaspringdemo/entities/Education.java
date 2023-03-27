package com.example.javaspringdemo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "educations")
public class Education {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "school")
    @NotEmpty(message = "School cannot be empty")
    @Size(min = 5, max = 255, message = "Size must be between 5 and 255")
    private String school;
    @Basic
    @Column(name = "course")
    @Size(min = 5, max = 255, message = "Size must be between 5 and 255")
    private String course;
    @Basic
    @Column(name = "level")
    private String level;
    @Basic
    @Column(name = "GPA")
    @Max(value = 4, message = "GPA must be less than or equal 4")
    @Min(value = 0, message = "GPA must be more than or equal 0")
    private float GPA;
    @Basic
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_time;
    @Basic
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_time;


    public Education() {
    }

    public Education(int id, String school, String course, String level, float GPA, Date start_time, Date end_time) {
        this.id = id;
        this.school = school;
        this.course = course;
        this.level = level;
        this.GPA = GPA;
        this.start_time = start_time;
        this.end_time = end_time;
    }

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
