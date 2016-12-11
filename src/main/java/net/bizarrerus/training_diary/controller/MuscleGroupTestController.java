package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MuscleGroupTestController {

    @Autowired
    MuscleGroupService muscleGroupService;

    @RequestMapping("/")
    public String testContoller(Model model){
        model.addAttribute("muscleGroup", new MuscleGroup());
        return "index";
    }

    @RequestMapping("/getGroups")
    public String getGroups(Model model){
        model.addAttribute("list", muscleGroupService.getAll());
        model.addAttribute("muscleGroup", new MuscleGroup());
        return "index";
    }

    @RequestMapping("/getGroup")
    public String getGroupById(@RequestParam("groupName") String name, Model model){
        model.addAttribute("muscleGroup", muscleGroupService.getByName(name));
        return "index";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("muscleGroup") MuscleGroup muscleGroup){
        muscleGroupService.saveOrUpdate(muscleGroup);
        return "redirect:/";
    }

    @RequestMapping("/removeGroup")
    public String removeGroup(@RequestParam("groupName") String name){
        muscleGroupService.delete(muscleGroupService.getByName(name));
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String removeGroup(@PathVariable("id") int id){
        muscleGroupService.delete(id);
        return "redirect:/";
    }
}
