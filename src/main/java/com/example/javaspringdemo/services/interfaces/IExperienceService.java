package com.example.javaspringdemo.services.interfaces;

import com.example.javaspringdemo.entities.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {
    public void save(Experience experience);
    public void deleteExperience(int id);
    public List<Experience> getAllExperience(int userId);
    public Optional<Experience> getOneExperience(int id);
}
