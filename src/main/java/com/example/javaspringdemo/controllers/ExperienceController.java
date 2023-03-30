package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.services.eloquents.ExperienceImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/my-portfolio/experience")
public class ExperienceController {
    @Autowired
    private ExperienceImplService experienceImplService;

    @GetMapping(value = "")
    public String index(Model model) {
        int userId = 1;
        List<Experience> listExperiences = this.experienceImplService.getAllExperience(userId);
        model.addAttribute("listExperiences", listExperiences);
        model.addAttribute("pageTitle", "My Experience");
        return "experience/index";
    }
}
