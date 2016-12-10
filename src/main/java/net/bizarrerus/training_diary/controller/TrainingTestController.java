package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ActivityService;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TrainingTestController {
    @Autowired
    ComplexService complexService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    TrainingService trainingService;
    @Autowired
    ActivityService activityService;

    @RequestMapping("/training")
    public String training(Model model) {
        model.addAttribute("training", new Training());
        model.addAttribute("activity", new Activity());
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        model.addAttribute("trainingList", trainingService.getAll());
        model.addAttribute("activityList", activityService.getAll());
        return "trainings";
    }

    @RequestMapping(value = "/addTraining", method = RequestMethod.POST)
    public String createTraining(@RequestParam("trainingDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                 @RequestParam(value = "exercisesID", required = false) List<Integer> exercisesID,
                                 @RequestParam(value = "complexID", required = false) Integer complexID) {
        return "redirect:/training";
    }

    @RequestMapping("/deleteTraining/{id}")
    public String deleteTraining(@PathVariable("id") int id) {
        trainingService.delete(id);
        return "redirect:/training";
    }
}
