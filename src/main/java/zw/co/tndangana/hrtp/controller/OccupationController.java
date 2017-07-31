package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Occupation;
import zw.co.tndangana.hrtp.service.OccupationService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 6/22/17.
 */
@Controller
@RequestMapping("/occupation")
public class OccupationController {

    @Resource
    private OccupationService occupationService;
    @GetMapping({"/add.form"})
    public String createUpdateForm(Model model)
    {

        model.addAttribute("occupation",new Occupation());
        return "administration/occupation/add";
    }
    @PostMapping("/submit.form")
    public String submitForm(@Valid @ModelAttribute("occupation") Occupation occupation, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
        return "administration/occupation/add";
        }
        else{if (occupation.isNew()){redirectAttributes.addFlashAttribute("msg","Record successfully updated");}
        else{redirectAttributes.addFlashAttribute("msg","Record successfully updated");}}
        occupationService.save(occupation);
        return "redirect:/occupation/list";//should redirect page in future
    }
    @GetMapping("/update.form/{occupationId}")
    public String updateForm(Model model,@PathVariable("occupationId") Long occupationId){
        model.addAttribute("occupation",occupationService.findOne(occupationId));
        return "administration/occupation/edit";
    }

    @PostMapping("submit.update/{occupationId}/update")
    public String submitUpdate(@PathVariable("occupationId") Long occupationId, @Validated @ModelAttribute("occupation") Occupation occupation,BindingResult result, RedirectAttributes redirectAttributes){
        occupation.setId(occupationId);
        if (result.hasErrors()) {
            return "administration/occupation/edit";
        } else{occupationService.save(occupation);}
        return "redirect:/occupation/list";

    }
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("occupationlist",occupationService.findAll());
        return "administration/occupation/list";}
}
