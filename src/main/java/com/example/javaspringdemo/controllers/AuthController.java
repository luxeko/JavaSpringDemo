package com.example.javaspringdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @RequestMapping("/login")
    public String login() {
        return "index";
    }
    @RequestMapping("logout")
    public String logout() {
        return "index";
    }

    @RequestMapping("my-portfolio")
    public String view() {
        return "home/index";
    }
}
