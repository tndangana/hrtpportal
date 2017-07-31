package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaApplication;
import zw.co.tndangana.hrtp.service.SocialMediaApplicationService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 7/5/17.
 */
@Controller
@RequestMapping("/socialMediaApplication/")
public class SocialMediaApplicationController {
    @Resource
    private SocialMediaApplicationService socialMediaApplicationService;
    @GetMapping({"add.socialMediaApplication"})
    public String createForm(Model model){
        model.addAttribute("socialMediaApplication",new SocialMediaApplication());
        return "administration/socialMediaApplication/add";
    }
    @PostMapping("submit.form")
    public String submitForm(@Valid @ModelAttribute("socialMediaApplication") SocialMediaApplication socialMediaApplication, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors())
        {
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/socialMediaApplication/add";
        }else
        {if(socialMediaApplication.isNew()) {
            redirectAttributes.addFlashAttribute("msg", "social Media Application added successfully");
        }else{
            redirectAttributes.addFlashAttribute("msg","social Media Application updated successfully");
        }
            socialMediaApplicationService.save(socialMediaApplication);
        }
        return "redirect:/socialMediaApplication/list.socialMediaApplication";
    }
    @GetMapping("/update.form/{socialMediaApplicationId}")
    public String updateForm(@PathVariable("socialMediaApplicationId") Long socialMediaApplicationId, Model model){
        model.addAttribute("socialMediaApplication",socialMediaApplicationService.findOne(socialMediaApplicationId));
        return "administration/socialMediaApplication/edit";
    }
    @PostMapping("submit.update/{socialMediaApplicationId}/update")
    public String postUpdate(@PathVariable("socialMediaApplicationId") Long socialMediaApplicationId, @Validated @ModelAttribute("socialMediaApplication") SocialMediaApplication socialMediaApplication, BindingResult result){
        socialMediaApplication.setId(socialMediaApplicationId);
        if(result.hasErrors()){
            return "administration/socialMediaApplication/edit";
        }
        else{ socialMediaApplicationService.save(socialMediaApplication);}

        return "redirect:/socialMediaApplication/list.socialMediaApplication";
    }
    @GetMapping("list.socialMediaApplication")
    public String ListSocialMediaApplication(Model model){
        model.addAttribute("socialMediaApplicationlist",socialMediaApplicationService.findAll());
        return "administration/socialMediaApplication/list";
    }



}
