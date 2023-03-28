package com.example.javaspringdemo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "experiences")
public class Experience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "company")
    @NotEmpty(message = "Company cannot be empty")
    @Size(min = 2, max = 255, message = "Size must be between 2 and 255")
    private String company;
    @Basic
    @Column(name = "position")
    @NotEmpty(message = "Position cannot be empty")
    @Size(min = 2, max = 255, message = "Size must be between 2 and 255")
    private String position;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_time;
    @Basic
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_time;

    public Experience() {
    }

    public Experience(int id, String company, String position, String description, Date start_time, Date end_time) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.description = description;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
