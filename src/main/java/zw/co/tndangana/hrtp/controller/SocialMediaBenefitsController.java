package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaBenefits;
import zw.co.tndangana.hrtp.service.SocialMediaBenefitsService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 7/5/17.
 */
@Controller
@RequestMapping("/socialMediaBenefits")
public class SocialMediaBenefitsController {

    @Resource
    private SocialMediaBenefitsService socialMediaBenefitsService;
    @GetMapping({"add.socialMediaBenefits"})
    public String createForm(Model model){
        model.addAttribute("socialMediaBenefits",new SocialMediaBenefits());
        return "administration/socialMediaBenefits/add";
    }
    @PostMapping("submit.form")
    public String submitForm(@Valid @ModelAttribute("socialMediaBenefits") SocialMediaBenefits socialMediaBenefits, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors())
        {
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/socialMediaBenefits/add";
        }else
        {if(socialMediaBenefits.isNew()) {
            redirectAttributes.addFlashAttribute("msg", "social Media Application added successfully");
        }else{
            redirectAttributes.addFlashAttribute("msg","social Media Application updated successfully");
        }
            socialMediaBenefitsService.save(socialMediaBenefits);
        }
        return "redirect:/socialMediaBenefits/list.socialMediaBenefits";
    }
    @GetMapping("/update.form/{socialMediaBenefitsId}")
    public String updateForm(@PathVariable("socialMediaBenefitsId") Long socialMediaBenefitsId, Model model){
        model.addAttribute("socialMediaBenefits",socialMediaBenefitsService.findOne(socialMediaBenefitsId));
        return "administration/socialMediaBenefits/edit";
    }
    @PostMapping("submit.update/{socialMediaBenefitsId}/update")
    public String postUpdate(@PathVariable("socialMediaBenefitsId") Long socialMediaBenefitsId, @Validated @ModelAttribute("socialMediaBenefits") SocialMediaBenefits socialMediaBenefits, BindingResult result){
        socialMediaBenefits.setId(socialMediaBenefitsId);
        if(result.hasErrors()){
            return "administration/socialMediaBenefits/edit";
        }
        else{ socialMediaBenefitsService.save(socialMediaBenefits);}

        return "redirect:/socialMediaBenefits/list.socialMediaBenefits";
    }
    @GetMapping("list.socialMediaBenefits")
    public String ListSocialMediaBenefits(Model model){
        model.addAttribute("socialMediaBenefitslist",socialMediaBenefitsService.findAll());
        return "administration/socialMediaBenefits/list";
    }


}
