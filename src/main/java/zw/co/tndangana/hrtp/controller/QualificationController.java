package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Qualification;
import zw.co.tndangana.hrtp.domain.Qualification;
import zw.co.tndangana.hrtp.service.QualificationService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 6/22/17.
 */
@Controller
@RequestMapping("/qualification/")
public class QualificationController {

    @Resource
    private QualificationService qualificationService;
    @GetMapping({"add.form"})
    public String createForm(Model model){
        model.addAttribute("qualification",new Qualification());
        return "administration/qualification/add";
    }

    @PostMapping("submit.form")
    public String submitForm(@Valid @ModelAttribute("qualification") Qualification qualification, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors())
        {
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/qualification/add";
        }else
        {if(qualification.isNew()) {
            redirectAttributes.addFlashAttribute("msg", "qualification added successfully");
        }else{
            redirectAttributes.addFlashAttribute("msg","qualification updated successfully");
        }
            qualificationService.save(qualification);
        }
        return "redirect:/qualification/list.qualification";
    }
    @GetMapping("update.form/{qualificationId}")
    public String updateForm(@PathVariable("qualificationId") Long qualificationId,Model model){
        model.addAttribute("qualification",qualificationService.findOne(qualificationId));
        return "administration/qualification/edit";
    }
    @PostMapping("submit.update/{qualificationId}/update")
    public String postUpdate(@PathVariable("qualificationId") Long qualificationId, @Validated @ModelAttribute("qualification") Qualification qualification, BindingResult result){
        qualification.setId(qualificationId);
        if(result.hasErrors()){
            return "administration/qualification/edit";
        }
        else{ qualificationService.save(qualification);}

        return "redirect:/qualification/list.qualification";
    }
    @GetMapping("list.qualification")
    public String ListQualification(Model model){
        model.addAttribute("qualificationlist",qualificationService.findAll());
        return "administration/qualification/list";
    }
}
