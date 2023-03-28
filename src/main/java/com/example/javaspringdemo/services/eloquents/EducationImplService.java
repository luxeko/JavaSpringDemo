package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.repositories.EducationRepository;
import com.example.javaspringdemo.services.interfaces.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationImplService implements IEducationService {
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public void save(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(int id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> getOneEducation(int id) {
        return educationRepository.findById(id);
    }
}
