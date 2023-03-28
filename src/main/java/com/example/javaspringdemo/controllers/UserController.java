package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.services.eloquents.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserImplService userImplService;

    @GetMapping(value = "/create")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        userImplService.save(user);
        return "redirect:/login";
    }
}
