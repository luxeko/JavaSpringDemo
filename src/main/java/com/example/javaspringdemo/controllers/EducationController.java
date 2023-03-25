package com.example.javaspringdemo.controllers;

import com.example.javaspringdemo.entities.EducationEntity;
import com.example.javaspringdemo.repositories.EducationRepository;
import com.example.javaspringdemo.services.EducationService;
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
@RequestMapping(path = "education")
public class EducationController {
    @Autowired
    EducationService educationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<EducationEntity> listEducation = this.educationService.listAll();
        model.addAttribute("listEducation", listEducation);
        return "education/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        EducationEntity educationEntity = new EducationEntity();
        model.addAttribute("education", educationEntity);
        return "education/create";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, BindingResult result) {
        Optional<EducationEntity> op = educationService.getById(id);
        if (op.isPresent()) {
            educationService.delete(id);
        } else {
            ObjectError error = new ObjectError("globalError", "Id not found");
            result.addError(error);
        }
        return "redirect:/education";
    }

    //    @GetMapping(value = "/delete")
//    public String delete2(@RequestParam("id") int id) {
//        return "redirect:/education";
//    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<EducationEntity> op = educationService.getById(id);
        if (op.isPresent()) {
            EducationEntity educationEntity = op.get();
            model.addAttribute("education", educationEntity);
            return "education/edit";
        }
        return "redirect:/education";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("education") @Valid EducationEntity educationEntity, BindingResult result) {
        if (result.hasErrors()) {
            return "education/create";
        } else if (result.hasErrors() && educationEntity.getId() != 0) {
            return "education/edit/" + educationEntity.getId();
        }
        educationService.save(educationEntity);
        return "redirect:/education";
    }
}
