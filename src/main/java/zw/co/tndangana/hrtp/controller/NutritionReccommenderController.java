package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.nutrition.NutritionReccommender;
import zw.co.tndangana.hrtp.service.NutritionReccommenderService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tndangana on 7/15/17.
 */
@Controller
@RequestMapping("/nutritionReccommender/")
public class NutritionReccommenderController {

    @Resource
    private NutritionReccommenderService nutritionReccommenderService;

    @GetMapping({"/add.form"})
    public String createNutritionReccommenderForm(Model model) {
        model.addAttribute("nutritionReccommender", new NutritionReccommender());
        return "administration/nutritionReccommender/add";
    }

    @GetMapping("/update.form/{nutritionReccommenderId}")
    public String editForm(Model model, @PathVariable("nutritionReccommenderId") Long maritalstatusId) {
        model.addAttribute("nutritionReccommender", nutritionReccommenderService.findOne(maritalstatusId));
        return "administration/nutritionReccommender/edit";
    }

    @PostMapping("/submit.form")
    public String postRecord(@Validated @ModelAttribute("nutritionReccommender") NutritionReccommender nutritionReccommender, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Something is not right!!");
            return "administration/nutritionReccommender/add";
        } else {
            if (nutritionReccommender.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "record added successfully");
            } else {
                redirectAttributes.addFlashAttribute("msg", "record updated successfully");


            }
            nutritionReccommenderService.save(nutritionReccommender);
        }
        return "redirect:/nutritionReccommender/list";
    }

    @PostMapping("/update.form/{nutritionReccommenderId}/update")
    public String updateForm(@PathVariable("nutritionReccommenderId") Long nutritionReccommenderId, Model model, @Valid @ModelAttribute("nutritionReccommender") NutritionReccommender nutritionReccommender, BindingResult result) {
        nutritionReccommender.setId(nutritionReccommenderId);
        if (result.hasErrors()) {
            return "administration/nutritionReccommender/edit";
        }
        nutritionReccommenderService.save(nutritionReccommender);
        return "redirect:/nutritionReccommender/list";
    }


    @GetMapping("list")
    public String listMS(Model model) {
        model.addAttribute("nutritionReccommenderList", nutritionReccommenderService.findAll());
        return "administration/nutritionReccommender/list";
    }
}
