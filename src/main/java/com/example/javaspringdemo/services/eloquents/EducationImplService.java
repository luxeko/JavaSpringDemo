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
    public Education addEducation(Education education) {
        if (education != null) {
            return educationRepository.save(education);
        }
        return null;
    }

    @Override
    public Optional<Education> updateEducation(int id, Education education) {
        if (education != null) {
            Optional<Education> education1 = educationRepository.findById(id);
            if (education1.isPresent()) {

            }
        }
        return null;
    }

    @Override
    public boolean deleteEducation(int id) {
        return false;
    }

    @Override
    public List<Education> getAllEducation() {
        return null;
    }

    @Override
    public Education getOneEducation(int id) {
        return null;
    }
}
