package com.example.javaspringdemo.services.interfaces;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.User;

import java.util.Optional;

public interface IUserService {
    public User save(User user);

    public Optional<User> getOneUserById(int id);
}
