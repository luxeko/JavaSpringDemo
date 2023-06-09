package com.example.javaspringdemo.repositories;

import com.example.javaspringdemo.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findExperiencesByUserId(int userId);
}
