package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.EducationRepository;
import com.example.javaspringdemo.repositories.ExperienceRepository;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.eloquents.EducationImplService;
import com.example.javaspringdemo.services.eloquents.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping({"/login", ""})
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "index";
        }
        return "redirect:/my-portfolio";
    }

    @GetMapping("/my-portfolio")
    public String view(Model model, Authentication authentication, HttpSession session) {
        String email = authentication.getName();
        Optional<User> getUserByEmail = userRepository.findUserByEmail(email);
        if (getUserByEmail.isPresent()) {
            User user = getUserByEmail.get();
            List<Education> educations = educationRepository.findEducationsByUserId(user.getId());
            List<Experience> experiences = experienceRepository.findExperiencesByUserId(user.getId());
            session.setAttribute("userId", user.getId());
            model.addAttribute("user", user);
            model.addAttribute("educations", educations);
            model.addAttribute("experiences", experiences);
            model.addAttribute("pageTitle", "My Portfolio");
            return "home/index";
        }
        return "index";
    }
}
