package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExerciseTestContoller {

    @Autowired
    MuscleGroupService muscleGroupService;

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping("/exercises")
    public String exercises(Model model){
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("groupNames", muscleGroupService.getGroupNames());
        model.addAttribute("exercise", new Exercise());
        return "exercise";
    }

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addExercise(@ModelAttribute ("exercise") Exercise exercise, @RequestParam ("groupName") String groupName){
        exerciseService.saveOrUpdate(exercise, groupName);
        return "redirect:/exercises";
    }

    @RequestMapping(value = "/removeExerciseById/{id}")
    public String removeExercise(@PathVariable("id") int id){
        exerciseService.delete(id);
        return "redirect:/exercises";
    }
}
