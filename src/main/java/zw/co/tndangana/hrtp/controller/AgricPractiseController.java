package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.psycho.AgricPractise;
import zw.co.tndangana.hrtp.service.AgricPractiseService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/13/17.
 */
@RequestMapping("/agricPractise/")
@Controller
public class AgricPractiseController {
    
    @Resource
    private AgricPractiseService agricPractiseService;
    @GetMapping("add.form")
    public  String createForm(Model model){
        model.addAttribute("agricPractise",new AgricPractise());
        return "administration/agricPractise/add";
    }
    @PostMapping("submit.form")
    public String submitForm(Model model, @ModelAttribute("agricPractise") AgricPractise agricPractise, BindingResult result){
        if(result.hasErrors()){

            return "administration/agricPractise/add";
        }else{

            agricPractiseService.save(agricPractise);
        }
        return "redirect:/agricPractise/list";

    }
    @GetMapping("update.form/{agricPractiseId}")
    public String updateForm(Model model, @PathVariable("agricPractiseId") Long agricPractiseId){
        model.addAttribute("agricPractise",agricPractiseService.findOne(agricPractiseId));
        return "administration/agricPractise/edit";
    }

    @PostMapping("submit.update/{agricPractiseId}")
    public String submitUpdate(@PathVariable("agricPractiseId") Long agricPractiseId,@ModelAttribute("agricPractise") AgricPractise agricPractise,BindingResult result,Model model){
        agricPractise.setId(agricPractiseId);
        if(result.hasErrors()){

            return "administration/agricPractise/edit";
        }else {

            agricPractiseService.save(agricPractise);
        }

        return "redirect:/agricPractise/list";
    }
    @GetMapping("list")
    public String ListForm(Model model){
        model.addAttribute("agricPractiseList",agricPractiseService.findAll());
        return "administration/agricPractise/list";
    }
}
