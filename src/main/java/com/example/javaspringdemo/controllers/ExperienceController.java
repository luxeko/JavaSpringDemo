package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Experience;
import com.example.javaspringdemo.services.eloquents.ExperienceImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/my-portfolio/experience")
public class ExperienceController {
    @Autowired
    private ExperienceImplService experienceImplService;

    @GetMapping(value = "")
    public String index(Model model, HttpSession session) {
        int userId = (int) session.getAttribute("userId");
        List<Experience> listExperiences = this.experienceImplService.getAllExperience(userId);
        model.addAttribute("listExperiences", listExperiences);
        model.addAttribute("pageTitle", "My Experience");
        return "experience/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        Experience experience = new Experience();
        model.addAttribute("experience", experience);
        return "experience/create";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Optional<Experience> op = experienceImplService.getOneExperience(id);
        if (op.isPresent()) {
            experienceImplService.deleteExperience(id);
        }
        redirectAttributes.addFlashAttribute("success", "Delete experience success");
        return "redirect:/my-portfolio/experience";
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Experience> op = experienceImplService.getOneExperience(id);
        if (op.isPresent()) {
            Experience experience = op.get();
            model.addAttribute("experience", experience);
            return "experience/edit";
        }
        return "redirect:/my-portfolio/experience";
    }
    @PostMapping(value = "/add")
    public String add(@ModelAttribute("experience") @Valid Experience experience, BindingResult result,
                      HttpSession session, RedirectAttributes redirectAttributes) {
        int userId = (int) session.getAttribute("userId");
        if (result.hasErrors()) {
            return "experience/create";
        }
        experience.setUserId(userId);
        experienceImplService.save(experience);
        redirectAttributes.addFlashAttribute("success", "Create new experience success");
        return "redirect:/my-portfolio/experience";
    }
    @PostMapping(value = "/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("experience") @Valid Experience experience,
                         BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
        int userId = (int) session.getAttribute("userId");
        if (result.hasErrors()) {
            return "experience/edit";
        }
        experience.setUserId(userId);

        experienceImplService.save(experience);
        redirectAttributes.addFlashAttribute("success", "Update experience success");
        return "redirect:/my-portfolio/experience";
    }
}
