package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaGeneratingMethods;
import zw.co.tndangana.hrtp.service.SocialMediaGeneratingMethodsService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/5/17.
 */
@Controller
@RequestMapping("/socialMediaGeneratingMethods/")
public class socialMediaGeneratingMethodsController {
    @Resource
    private SocialMediaGeneratingMethodsService socialMediaGeneratingMethodsService;
    @GetMapping("add.form")
    public String createForm(Model model){
        model.addAttribute("socialMediaGeneratingMethods",new SocialMediaGeneratingMethods());

        return "socialMediaGeneratingMethods/add";
    }
    @PostMapping("submit.form")
    public String submitForm(@Validated @ModelAttribute("socialMediaGeneratingMethods") SocialMediaGeneratingMethods socialMediaGeneratingMethods, BindingResult bindingResult
    , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right");
            return "socialMediaGeneratingMethods/add";

        }else{
            socialMediaGeneratingMethodsService.save(socialMediaGeneratingMethods);
        }
     return "redirect:list.socialMediaGeneratingMethods";
    }
    @GetMapping("update.form")
    public String updateForm(@PathVariable("smgmId") Long smgmId,Model model){
        model.addAttribute("socialMediaGeneratingMethods",socialMediaGeneratingMethodsService.findOne(smgmId));
       return "socialMediaGeneratingMethods/edit";
    }
    @PostMapping("submit.update/{smgmId}/updated")
    public String submitUpdate(@PathVariable("smgmId") Long smgmId,@Validated @ModelAttribute SocialMediaGeneratingMethods socialMediaGeneratingMethods
    ,BindingResult bindingResult){
        socialMediaGeneratingMethods.setId(smgmId);
        if(bindingResult.hasErrors()){

            return "socialMediaGeneratingMethods/edit";
        }else {
            socialMediaGeneratingMethodsService.save(socialMediaGeneratingMethods);
        }

        return "redirect:list.socialMediaGeneratingMethods";
    }
    @GetMapping("list.form")
    public String listForm(Model model){
        model.addAttribute("socialMediaGeneratingMethodsList",socialMediaGeneratingMethodsService.findAll());
        return "socialMediaGeneratingMethods/list";
    }
}
