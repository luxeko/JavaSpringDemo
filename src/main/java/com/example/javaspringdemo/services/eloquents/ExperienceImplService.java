package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.repositories.ExperienceRepository;
import com.example.javaspringdemo.services.interfaces.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienceImplService implements IExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Override
    public void save(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(int id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public List<Experience> getAllExperience(int userId) {
        return experienceRepository.findExperiencesByUserId(userId);
    }

    @Override
    public Optional<Experience> getOneExperience(int id) {
        return experienceRepository.findById(id);
    }
}
