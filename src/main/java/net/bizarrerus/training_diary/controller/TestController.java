package net.bizarrerus.training_diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public static String testContoller(Model model){
        model.addAttribute("name", "name");
        model.addAttribute("obj");
        return "index";
    }
}
