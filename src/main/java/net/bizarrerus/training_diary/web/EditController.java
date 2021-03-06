package net.bizarrerus.training_diary.web;

import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EditController {

    @Autowired
    MuscleGroupService muscleGroupService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ComplexService complexService;
    @Autowired
    TrainingService trainingService;

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editGroup(@ModelAttribute("group") MuscleGroup muscleGroup) {
        muscleGroupService.update(muscleGroup);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", muscleGroupService.get(id));
        return "editAll";
    }

    @RequestMapping("/editExercise")
    public String editExercise(@ModelAttribute("exercise")Exercise exercise) {
//        exerciseService.update(exercise);
        return "redirect:/exercises";
    }

    @RequestMapping("/editExercise/{id}")
    public String editExercise(@PathVariable("id") int id, Model model) {
        model.addAttribute("exercise", exerciseService.get(id));
        return "editAll";
    }

    @RequestMapping(value = "/editComplex", method = RequestMethod.POST)
    public String editComplex(@ModelAttribute("complex")Complex complex, @RequestParam(value = "exercisesId",required = false)List<Integer> exercisesId) {
        if (exercisesId == null) {
            complexService.update(complex);
        } else {
            complexService.saveOrUpdate(complex, exercisesId);
        }
        return "redirect:/complex";
    }

    @RequestMapping("/editComplex/{id}")
    public String editComplex(@PathVariable("id") int id, Model model) {
        model.addAttribute("complex", complexService.get(id));
        model.addAttribute("exerciseList", exerciseService.getAll());
        return "editAll";
    }
}
