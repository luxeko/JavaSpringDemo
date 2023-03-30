package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.EducationRepository;
import com.example.javaspringdemo.repositories.ExperienceRepository;
import com.example.javaspringdemo.services.eloquents.EducationImplService;
import com.example.javaspringdemo.services.eloquents.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private UserImplService userImplService;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

    @GetMapping("/my-portfolio")
    public String view(Model model) {
        int id = 1;
        Optional<User> op = userImplService.getOneUserById(id);
        List<Education> educations = educationRepository.findEducationsByUserId(id);
        List<Experience> experiences = experienceRepository.findExperiencesByUserId(id);
        if (op.isPresent()) {
            User user = op.get();
            model.addAttribute("user", user);
            model.addAttribute("educations", educations);
            model.addAttribute("experiences", experiences);
            return "home/index";
        }
        return "index";
    }
}
