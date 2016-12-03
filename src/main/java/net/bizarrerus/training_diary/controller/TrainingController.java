package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
public class TrainingController {
    @Autowired
    TrainingService trainingService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ComplexService complexService;

    @RequestMapping("/trainings")
    public String trainings(Model model){
        model.addAttribute("training", new Training());
        model.addAttribute("trainingList", trainingService.getAll());
        model.addAttribute("exerciseList", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        return "trainings";
    }

    @RequestMapping(value = "/createTraining", method = RequestMethod.POST)
    public String createTraining(@ModelAttribute("training") Training training,
                                 @RequestParam(value = "complexId", required = false) int complexId){
        if (complexId != 0){
            if (training.getExercises() == null){
                training.setExercises(new HashSet<>());
            }
            training.getExercises().addAll(complexService.get(complexId).getExercises());
        }
        trainingService.save(training);
        return "redirect:/trainings";
    }
}
