package com.example.javaspringdemo.services.interfaces;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.User;

import java.util.Optional;

public interface IUserService {
    public void save(User user);
    public Optional<User> getOneUser(int id);
}
