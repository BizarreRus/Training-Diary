package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.service.interfaces.ActivityService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivityTestController {
    @Autowired
    ActivityService activityService;
    @Autowired
    TrainingService trainingService;
    @Autowired
    ExerciseService exerciseService;

    @RequestMapping("/activity/trainingID/{trainingID}/exerciseID/{exerciseID}")
    public String activity(@PathVariable("trainingID") int trainingID,
                           @PathVariable("exerciseID") int exerciseID,
                           Model model) {
        model.addAttribute("trainingID", trainingID);
        model.addAttribute("exerciseID", exerciseID);
        model.addAttribute("activity", new Activity());
        return "activity";
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("activity") Activity activity,
                              @RequestParam("exerciseID")int exerciseID,
                              @RequestParam("trainingID")int trainingID) {
        System.out.println("exerciseID => " +exerciseID
                + ", trainingID => " + trainingID
                + ", reps and weight => " + activity.getReps() + "/" + activity.getWeight());
        activityService.save(activity, exerciseID, trainingID);
        return "redirect:/training";
    }
}
