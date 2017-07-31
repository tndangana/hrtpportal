package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.MaritalStatus;
import zw.co.tndangana.hrtp.service.MaritalStatusService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tndangana on 6/21/17.
 */
@Controller
@RequestMapping("/maritalstatus/")
public class MaritalStatusController {
    @Resource
    private MaritalStatusService maritalStatusService;

    @GetMapping({"/add.form"})
    public String createMaritalStatusForm(Model model)
    {
        model.addAttribute("maritalstatus",new MaritalStatus());
       return "administration/maritalstatus/add";
    }
    @GetMapping("/update.form/{maritalstatusId}")
    public String editForm(Model model,@PathVariable("maritalstatusId") Long maritalstatusId){
        model.addAttribute("maritalstatus",maritalStatusService.findOne(maritalstatusId));
        return "administration/maritalstatus/edit";
    }
    @PostMapping("/submit.form")
    public String postRecord(@Validated @ModelAttribute("maritalstatus") MaritalStatus maritalStatus, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/maritalstatus/add";
        }else{
            if(maritalStatus.isNew()){
                redirectAttributes.addFlashAttribute("msg","record added successfully");
            }else{ redirectAttributes.addFlashAttribute("msg","record updated successfully");


            }
            maritalStatusService.save(maritalStatus);
        }
     return "redirect:/maritalstatus/list.maritalstatus";
    }

    @PostMapping("/update.form/{maritalstatusId}/update")
    public String updateForm(@PathVariable("maritalstatusId") Long maritalstatusId, Model model, @Valid @ModelAttribute("maritalstatus") MaritalStatus maritalStatus, BindingResult result) {

        maritalStatus.setId(maritalstatusId);
        if (result.hasErrors()) {
            return "administration/maritalstatus/edit";
        }
        maritalStatusService.save(maritalStatus);
        return "redirect:/maritalstatus/list.maritalstatus";
    }



@GetMapping("/list.maritalstatus")
public String listMS(Model model){
        List<MaritalStatus> maritalStatusList = maritalStatusService.findAll();
        model.addAttribute("maritalStatusList",maritalStatusService.findAll());
        return "administration/maritalstatus/list";
}
}
