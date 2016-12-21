package net.bizarrerus.training_diary.web;

import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplexTestController {

    @Autowired
    ComplexService complexService;
    @Autowired
    ExerciseService exerciseService;

    @RequestMapping("/complex")
    public String complex(Model model) {
        model.addAttribute("complex", new Complex());
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        return "complex";
    }

    @RequestMapping(value = "/addComplex", method = RequestMethod.POST)
    public String addComplex(@RequestParam("exercisesID") List<Integer> exercisesID,
                             @ModelAttribute("complex") Complex complex) {
//        complexService.save(complex, exercisesID);
        return "redirect:/complex";
    }

    @RequestMapping(value = "/deleteComplex/{id}")
    public String deleteComplex(@PathVariable("id") int id) {
        complexService.delete(id);
        return "redirect:/complex";
    }

//    @RequestMapping(value = "/createComplex", method = RequestMethod.POST)
//    public String createComplex(@ModelAttribute("complex") @Valid Complex complex, BindingResult result) {
//
//        for (String s : result.getSuppressedFields()) {
//            System.out.println(s);
//        }
//        for (FieldError fieldError : result.getFieldErrors()) {
//            System.out.println("field = > " + fieldError.getField());
//            System.out.println("default message => " + fieldError.getDefaultMessage());
//            System.out.println("rejected value => " + fieldError.getRejectedValue());
//            System.out.println("code => " + fieldError.getCode());
//            System.out.println("obj name => " + fieldError.getObjectName());
//        }
//
//        if (!result.hasErrors()) {
//            complexService.save(complex);
//        }
//        if (result.hasErrors()){
//            System.out.println("Tere is some error!");
//        }
//        return "redirect:/complex";
//    }
}
