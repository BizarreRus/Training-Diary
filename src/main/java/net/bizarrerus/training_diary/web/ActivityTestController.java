package net.bizarrerus.training_diary.web;

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
                              @RequestParam(value = "exerciseId", required = false) int exerciseId,
                              @RequestParam(value = "trainingId", required = false) int trainingId) {
        System.out.println("test msg");
        activityService.save(activity, exerciseId, trainingId);
        return "redirect:/training";
    }

//    @RequestMapping(value = "/createActivity", method = RequestMethod.POST)
//    public String createActivity(@RequestParam(value = "reps", required = false) int reps,
//                                 @RequestParam(value = "weight", required = false) int weight,
//                                 @RequestParam(value = "exerciseId", required = false) int exerciseId,
//                                 @RequestParam(value = "trainingId", required = false) int trainingId) {
//        System.out.println("reps = " + reps + ". weight = " + weight
//                + "exerciseId= " + exerciseId + ". trainingId = " + trainingId);
//        Activity activity = new Activity();
//        activity.setReps(reps);
//        activity.setWeight(weight);
//        activityService.save(activity, exerciseId, trainingId);
//        return "redirect:/training";
//    }
}
