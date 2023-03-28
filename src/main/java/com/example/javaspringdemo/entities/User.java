package com.example.javaspringdemo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 2, max = 255, message = "Size must be between 2 and 255")
    private String username;
    @Basic
    @Column(name = "email")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 2, max = 255, message = "Size must be between 2 and 255")
    @Email
    private String email;
    @Basic
    @Column(name = "password")
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Enumerated
    @Column(name = "gender")
    private String gender;
}
