package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ExerciseTestContoller {
    @Autowired
    MuscleGroupService muscleGroupService;
    @Autowired
    ExerciseService exerciseService;

    @RequestMapping("/exercise")
    public String exercises(Model model) {
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("groupNames", muscleGroupService.getGroupNames());
        model.addAttribute("groupList", muscleGroupService.getAll());
        model.addAttribute("exercise", new Exercise());
        return "exercise";
    }

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addExercise(@ModelAttribute("exercise") Exercise exercise, @RequestParam("groupName") String groupName) {
        exerciseService.saveOrUpdate(exercise, groupName);
        return "redirect:/exercises";
    }

    @RequestMapping(value = "/removeExerciseById/{id}")
    public String removeExercise(@PathVariable("id") int id) {
        exerciseService.delete(id);
        return "redirect:/exercises";
    }

    @RequestMapping(value = "/createExercise", method = RequestMethod.POST)
    public String createExercise(@ModelAttribute("exercise") @Valid Exercise exercise, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("has errors!");
            for (String s : result.getSuppressedFields()) {
                System.out.println(s);
            }
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println("field = > " + fieldError.getField());
                System.out.println("default message => " + fieldError.getDefaultMessage());
                System.out.println("rejected value => " + fieldError.getRejectedValue());
                System.out.println("code => " + fieldError.getCode());
                System.out.println("obj name => " + fieldError.getObjectName());
            }

        }
        if (exercise.getMuscleGroup() == null) {
            System.out.println("is null");
        }
        exerciseService.save(exercise);
        return "redirect:/exercises";
    }
}
