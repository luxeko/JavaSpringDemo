package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.EducationEntity;
import com.example.javaspringdemo.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class HelloController {
    // Dùng Autowired thì ko cần Contractor
    @Autowired
    private EducationRepository educationRepository;

//    public HelloController(EducationRepository educationRepository) {
//        this.educationRepository = educationRepository;
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String helloWorld(Model model) {
        List<EducationEntity> listEducation = this.educationRepository.findAll();
        System.out.println("Test size() = " + listEducation.size());
        return "index";
    }
}
