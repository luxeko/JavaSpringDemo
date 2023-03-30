package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.eloquents.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/my-portfolio")
public class UserController {
    @Autowired
    private UserImplService userImplService;
    @Autowired
    UserRepository userRepository;
    @PostMapping(value = "/create")
    public String create(RedirectAttributes redirectAttributes, @RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password) {
        Optional<User> userFindByEmail = userRepository.findUserByEmail(email);
        if (userFindByEmail.isPresent()) {
            redirectAttributes.addFlashAttribute("emailExists", "Email already exists");
            return "redirect:/login";
        }
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        userImplService.save(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<User> op = userImplService.getOneUserById(id);
        if (op.isPresent()) {
            User user = op.get();
            model.addAttribute("user", user);
            return "home/me";
        }
        return "redirect:/my-portfolio";
    }
    @PostMapping(value = "/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "home/me";
        }
        userImplService.save(user);
        return "redirect:/my-portfolio";
    }
}
