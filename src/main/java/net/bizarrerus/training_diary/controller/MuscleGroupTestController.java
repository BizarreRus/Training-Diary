package net.bizarrerus.training_diary.controller;

import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MuscleGroupTestController {

    @Autowired
    MuscleGroupDao muscleGroupDao;

    @RequestMapping("/")
    public String testContoller(Model model){
        model.addAttribute("muscleGroup", new MuscleGroup());
        return "index";
    }

    @RequestMapping("/getGroups")
    public String getGroups(Model model){
        model.addAttribute("list", muscleGroupDao.getMuscleGroupList());
        model.addAttribute("muscleGroup", new MuscleGroup());
        return "index";
    }

    @RequestMapping("/getGroup")
    public String getGroupById(@RequestParam("groupName") String name, Model model){
        model.addAttribute("muscleGroup", muscleGroupDao.getByName(name));
        return "index";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("muscleGroup") MuscleGroup muscleGroup, Model model){
        muscleGroupDao.saveOrUpdate(muscleGroup);
        model.addAttribute("muscleGroup", muscleGroup);
        return "index";
    }

    @RequestMapping("/removeGroup")
    public String getGroups(@RequestParam("groupName") String name, Model model){
        muscleGroupDao.deleteByName(muscleGroupDao.getByName(name));
        model.addAttribute("muscleGroup", new MuscleGroup());
        return "index";
    }
}
