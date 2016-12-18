package net.bizarrerus.training_diary.web;

import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplexController {
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ComplexService complexService;

    @RequestMapping("/complexes")
    public String complexes(Model model) {
        model.addAttribute("complex", new Complex());
        model.addAttribute("exerciseList", exerciseService.getAll());
        model.addAttribute("complexList", complexService.getAll());
        return "complexes";
    }

    @RequestMapping(value = "/createComplex", method = RequestMethod.POST)
    public String createTraining(@RequestParam(value = "exercisesId", required = false) List<Integer> exercisesId,
                                 @ModelAttribute("complex") Complex complex) {
        complexService.saveOrUpdate(complex, exercisesId);
        return "redirect:/complexes";
    }

    @RequestMapping("/deleteComplex{id}")
    public String deleteTraining(@PathVariable("id") int id) {
        complexService.delete(id);
        return "redirect:/complexes";
    }
}
