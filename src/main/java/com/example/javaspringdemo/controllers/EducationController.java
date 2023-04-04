package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.eloquents.EducationImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/my-portfolio/education")
public class EducationController {
    @Autowired
    private EducationImplService educationImplService;

    @GetMapping(value = "")
    public String index(Model model, HttpSession session) {
        int userId = (int) session.getAttribute("userId");
        List<Education> listEducation = this.educationImplService.getAllEducation(userId);
        model.addAttribute("listEducation", listEducation);
        model.addAttribute("pageTitle", "My Education");
        return "education/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        Education education = new Education();
        model.addAttribute("education", education);
        return "education/create";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Optional<Education> op = educationImplService.getOneEducation(id);
        if (op.isPresent()) {
            educationImplService.deleteEducation(id);
        }
        redirectAttributes.addFlashAttribute("success", "Delete experience success");
        return "redirect:/my-portfolio/education";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Education> op = educationImplService.getOneEducation(id);
        if (op.isPresent()) {
            Education education = op.get();
            model.addAttribute("education", education);
            return "education/edit";
        }
        return "redirect:/my-portfolio/education";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute("education") @Valid Education education, BindingResult result,
                      HttpSession session, RedirectAttributes redirectAttributes) {
        int userId = (int) session.getAttribute("userId");
        if (result.hasErrors()) {
            return "education/create";
        }
        education.setUserId(userId);
        educationImplService.save(education);
        redirectAttributes.addFlashAttribute("success", "Create new education success");
        return "redirect:/my-portfolio/education";
    }

    @PostMapping(value = "/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("education") @Valid Education education,
                         BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
        int userId = (int) session.getAttribute("userId");
        if (result.hasErrors()) {
            return "education/edit";
        }
        education.setUserId(userId);
        educationImplService.save(education);
        redirectAttributes.addFlashAttribute("success", "Update education success");
        return "redirect:/my-portfolio/education";
    }
}
