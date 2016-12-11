package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MuscleGroupController {
    @Autowired
    MuscleGroupService muscleGroupService;

    @RequestMapping(value = "/muscleGroups")
    public String muscleGroups(@ModelAttribute("muscleGroup") MuscleGroup muscleGroup, Model model) {

        model.addAttribute("muscleGroup", muscleGroup);
        model.addAttribute("groupList", muscleGroupService.getAll());
        return "muscleGroups";
    }

    @RequestMapping(value = "/createMuscleGroup", method = RequestMethod.POST)
    public String createMuscleGroup(@ModelAttribute("muscleGroup") MuscleGroup muscleGroup) {
        muscleGroupService.saveOrUpdate(muscleGroup);
        return "redirect:/muscleGroups";
    }

    @RequestMapping(value = "/deleteMuscleGroup{id}")
    public String deleteMuscleGroup(@PathVariable("id") int id) {
        muscleGroupService.delete(id);
        return "redirect:/muscleGroups";
    }
}
