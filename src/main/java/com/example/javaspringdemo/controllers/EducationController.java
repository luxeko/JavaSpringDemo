package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.EducationEntity;
import com.example.javaspringdemo.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @GetMapping(value = "/education")
    public String index(Model model) {
        List<EducationEntity> listEducation = this.educationRepository.findAll();
        model.addAttribute("listEducation", listEducation);
        return "education/index";
    }

    @GetMapping(value = "/education/create")
    public String create(Model model) {
        EducationEntity educationEntity = new EducationEntity();
        model.addAttribute("education", educationEntity);
        return "education/create";
    }

    @PostMapping(value = "/education/save")
    public String save(Model model, EducationEntity educationEntity) {
        educationRepository.save(educationEntity);
        return "redirect:/education";
    }
}
