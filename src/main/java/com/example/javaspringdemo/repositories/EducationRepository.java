package com.example.javaspringdemo.repositories;

import com.example.javaspringdemo.entities.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {

}
