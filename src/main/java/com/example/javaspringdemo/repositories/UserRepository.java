package com.example.javaspringdemo.repositories;

import com.example.javaspringdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT edu from educations edu where ")
}
