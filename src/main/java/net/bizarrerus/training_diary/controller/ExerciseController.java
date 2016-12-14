package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    MuscleGroupService muscleGroupService;

    @RequestMapping("/exercises")
    public String exercises(Model model) {
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("exerciseList", exerciseService.getAll());
        model.addAttribute("muscleGroupList", muscleGroupService.getAll());
        return "exercises";
    }

    @RequestMapping(value = "/createExercise", method = RequestMethod.POST)
    public String createExercise(@ModelAttribute("exercise") Exercise exercise,
                                 @RequestParam(value = "groupId") int groupId) {
        exerciseService.saveOrUpdate(exercise, groupId);
        return "redirect:/exercises";
    }

    @RequestMapping("/deleteExercise{id}")
    public String deleteExercise(@PathVariable("id") int id) {
        exerciseService.delete(id);
        return "redirect:/exercises";
    }


}
