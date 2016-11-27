package net.bizarrerus.training_diary.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TrainingTestController {

    @RequestMapping("/training")
    public String training(Model model){
        return "training";
    }

    @RequestMapping(value = "/addTraining", method = RequestMethod.POST)
    public String createTraining(@RequestParam("trainingDay")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        if (date != null){
            System.out.println("y " + date.getYear() + ", m " + date.getMonth() + ", d " + date.getDayOfMonth());
        } else {
            System.out.println("null");
        }
        return "redirect:/training";
    }
}
