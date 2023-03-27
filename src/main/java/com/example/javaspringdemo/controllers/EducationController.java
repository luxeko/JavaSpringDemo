package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.services.eloquents.EducationImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/education")
public class EducationController {
    @Autowired
    private EducationImplService educationImplService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Education> listEducation = this.educationImplService.getAllEducation();
        model.addAttribute("listEducation", listEducation);
        return "education/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        Education education = new Education();
        model.addAttribute("education", education);
        return "education/create";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, BindingResult result) {
        Optional<Education> op = educationImplService.getOneEducation(id);
        if (op.isPresent()) {
            educationImplService.deleteEducation(id);
        } else {
            ObjectError error = new ObjectError("globalError", "Id not found");
            result.addError(error);
        }
        return "redirect:/education";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Education> op = educationImplService.getOneEducation(id);
        if (op.isPresent()) {
            Education education = op.get();
            model.addAttribute("education", education);
            return "education/edit";
        }
        return "redirect:/education";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("education") @Valid Education education, BindingResult result) {
        if (result.hasErrors()) {
            return "education/create";
        }
        educationImplService.save(education);
        return "redirect:/education";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") int id, @ModelAttribute("education") @Valid Education education,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "education/edit";
        }
        educationImplService.save(education);
        return "redirect:/education";
    }


    //    @GetMapping(value = "/delete")
//    public String delete2(@RequestParam("id") int id) {
//        return "redirect:/education";
//    }
}
