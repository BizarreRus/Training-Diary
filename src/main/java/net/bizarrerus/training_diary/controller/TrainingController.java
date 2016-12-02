package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingController {
    @Autowired
    TrainingService trainingService;

    @RequestMapping("/trainings")
    public String trainings(Model model){
        model.addAttribute("trainingList", trainingService.getAll());
        return "trainings";
    }
}
