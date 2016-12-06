package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Controller
public class TrainingController {
    @Autowired
    TrainingService trainingService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ComplexService complexService;

    @RequestMapping("/trainings")
    public String trainings(Model model) {
        model.addAttribute("training", new Training());
        model.addAttribute("trainingList", trainingService.getAll());
        model.addAttribute("exerciseList", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        return "trainings";
    }

    @RequestMapping(value = "/createTraining", method = RequestMethod.POST)
    public String createTraining(@RequestParam("trainingDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                 @RequestParam(value = "exercisesId", required = false) List<Integer> exercisesId,
                                 @RequestParam(value = "complexId", required = false) int complexId,
                                 @ModelAttribute("training") Training training) {
        if (date != null) {
            training.setTrainingDate(date);
        }
        if (exercisesId != null) {
            trainingService.save(training, exercisesId);
        }
        if (complexId > 0) {
            trainingService.save(training, complexId);
        } else if (date != null) {
            trainingService.save(training);
        }
        return "redirect:/trainings";
    }

    @RequestMapping("/deleteTraining{id}")
    public String deleteTraining(@PathVariable("id") int id) {
        trainingService.delete(id);
        return "redirect:/trainings";
    }
}
