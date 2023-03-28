package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    User _userBean;
    @RequestMapping("/login")
    public String login1() {
        return "index";
    }
    @RequestMapping("/")
    public String login2() {
        return "index";
    }
    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

    @PostMapping("my-portfolio")
    public String view(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (_userBean.getUsername().equals(username) && _userBean.getPassword().equals(password)) {
            System.out.println("Login thanh cong");
            return "home/index";
        } else {
            System.out.println("Login that bai");
        }
        return "index";
    }
}
