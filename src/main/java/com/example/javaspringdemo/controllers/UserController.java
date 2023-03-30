package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.eloquents.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserImplService userImplService;
    @Autowired
    UserRepository userRepository;
    @PostMapping(value = "/create")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        Optional<User> userFindByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userFindByEmail.isPresent()) {
            redirectAttributes.addFlashAttribute("emailExists", "Email already exists");
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        userImplService.save(user);
        return "redirect:/login";
    }
}
