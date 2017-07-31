package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.psycho.IncomeGeneratingProject;
import zw.co.tndangana.hrtp.service.IncomeGeneratingProjectService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/13/17.
 */
@Controller
@RequestMapping("/incomeGeneratingProject/")
public class IncomeGeneratingProjectController {

    @Resource
    private IncomeGeneratingProjectService incomeGeneratingProjectService;

    @GetMapping("add.form")
    public  String createForm(Model model){
        model.addAttribute("incomeGeneratingProject",new IncomeGeneratingProject());
        return "administration/incomeGeneratingProject/add";
    }
    @PostMapping("submit.form")
    public String submitForm(Model model, @Validated @ModelAttribute("incomeGeneratingProject") IncomeGeneratingProject incomeGeneratingProject, BindingResult result){
        if(result.hasErrors()){

            return "administration/incomeGeneratingProject/add";
        }else{

            incomeGeneratingProjectService.save(incomeGeneratingProject);
        }
        return "redirect:/incomeGeneratingProject/list";

    }
    @GetMapping("update.form/{incomeGeneratingProjectId}")
    public String updateForm(Model model, @PathVariable("incomeGeneratingProjectId") Long incomeGeneratingProjectId){
        model.addAttribute("incomeGeneratingProject",incomeGeneratingProjectService.findOne(incomeGeneratingProjectId));
        return "administration/incomeGeneratingProject/edit";
    }
    @PostMapping("submit.update/{incomeGeneratingProjectId}")
    public String submitUpdate(@PathVariable("incomeGeneratingProjectId") Long incomeGeneratingProjectId, @Validated @ModelAttribute("incomeGeneratingProject") IncomeGeneratingProject incomeGeneratingProject,BindingResult result,Model model){
       incomeGeneratingProject.setId(incomeGeneratingProjectId);
        if(result.hasErrors()){

            return "administration/incomeGeneratingProject/edit";
        }else {

            incomeGeneratingProjectService.save(incomeGeneratingProject);
        }

        return "redirect:/incomeGeneratingProject/list";
    }
    @GetMapping("list")
    public String ListForm(Model model){
        model.addAttribute("incomeGeneratingProjectList",incomeGeneratingProjectService.findAll());
        return "administration/incomeGeneratingProject/list";
    }
}
