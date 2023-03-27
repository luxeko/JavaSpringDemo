package com.example.javaspringdemo.services;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;

    public List<Education> listAll(){
        return educationRepository.findAll();
    }
    public void save(Education education) {
        educationRepository.save(education);
    }
    public Optional<Education> getById(int id) {
        return educationRepository.findById(id);
    }

    public void delete(int id) {
        educationRepository.deleteById(id);
    }
}
