package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.dao.ExerciseDao;
import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExerciseTestContoller {

    @Autowired
    ExerciseDao exerciseDao;

    @Autowired
    MuscleGroupDao muscleGroupDao;

    @Autowired
    MuscleGroupService muscleGroupService;

    @RequestMapping("/exercises")
    public String exercises(Model model){
        model.addAttribute("exercises", exerciseDao.exercises());
        model.addAttribute("groupNames", muscleGroupDao.getGroupNames());
        model.addAttribute("exercise", new Exercise());
        return "exercise";
    }

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addExercise(@ModelAttribute ("exercise") Exercise exercise, @RequestParam ("groupName") String groupName){
        muscleGroupService.updateGroup(exercise, groupName);
        return "redirect:/exercises";
    }
}
