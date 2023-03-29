package com.example.javaspringdemo.repositories;

import com.example.javaspringdemo.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    List<Education> findEducationsByUserId(int userId);
}
