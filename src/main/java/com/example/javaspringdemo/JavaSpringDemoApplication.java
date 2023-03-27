package com.example.javaspringdemo;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
