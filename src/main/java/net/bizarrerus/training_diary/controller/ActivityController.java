package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.service.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/createActivity", method = RequestMethod.POST)
    public String createActivity(@RequestParam("reps") int reps,
                                 @RequestParam("weight") int weight,
                                 @RequestParam("trainingId") int trainingId,
                                 @RequestParam("exerciseId") int exerciseId) {
        Activity activity = new Activity(reps, weight);
        activityService.save(activity, exerciseId, trainingId);
        return "redirect:/trainings";
    }
}
