package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplexController {

    @Autowired
    ComplexService complexService;
    @Autowired
    ExerciseService exerciseService;

    @RequestMapping("/complex")
    public String complex(Model model){
        model.addAttribute("complex", new Complex());
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        return "complex";
    }

    //todo realise validation. new complex must have 1 exercise minimum!
    @RequestMapping(value = "/addComplex", method = RequestMethod.POST)
    public String addComplex(@RequestParam("exercisesID")List<Integer> exercisesID,
                             @ModelAttribute("complex") Complex complex){
        complexService.save(complex, exercisesID);
        return "redirect:/complex";
    }

    @RequestMapping(value = "/deleteComplex/{id}")
    public String deleteComplex(@PathVariable("id") int id){
        complexService.delete(id);
        return "redirect:/complex";
    }
}
