package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.ict.MobileOperatingSystem;
import zw.co.tndangana.hrtp.service.MobileOperatingSystemService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Controller
@RequestMapping("/mobileoperatingsystem/")
public class MobileOperatingSystemController {


    @Resource
    private MobileOperatingSystemService mobileOperatingSystemService;

    @GetMapping({"/add.form"})
    public String createMobileOperatingSystemForm(Model model)
    {
        model.addAttribute("mobileoperatingsystem",new MobileOperatingSystem());
        return "administration/mobileoperatingsystem/add";
    }
    @GetMapping("/update.form/{mobileoperatingsystemId}")
    public String editForm(Model model,@PathVariable("mobileoperatingsystemId") Long mobileoperatingsystemId){
        model.addAttribute("mobileoperatingsystem",mobileOperatingSystemService.findOne(mobileoperatingsystemId));
        return "administration/mobileoperatingsystem/edit";
    }
    @PostMapping("/submit.form")
    public String postRecord(@Validated @ModelAttribute("mobileoperatingsystem") MobileOperatingSystem mobileOperatingSystem, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/mobileoperatingsystem/add";
        }else{
            if(mobileOperatingSystem.isNew()){
                redirectAttributes.addFlashAttribute("msg","record added successfully");
            }else{ redirectAttributes.addFlashAttribute("msg","record updated successfully");


            }
            mobileOperatingSystemService.save(mobileOperatingSystem);
        }
        return "redirect:/mobileoperatingsystem/list.mobileoperatingsystem";
    }

    @PostMapping("/update.form/{mobileoperatingsystemId}/update")
    public String updateForm(@PathVariable("mobileoperatingsystemId") Long mobileoperatingsystemId, Model model, @Valid @ModelAttribute("mobileoperatingsystem") MobileOperatingSystem mobileOperatingSystem, BindingResult result) {
        mobileOperatingSystem.setId(mobileoperatingsystemId);
        if (result.hasErrors()) {
            return "administration/mobileoperatingsystem/edit";
        }
        mobileOperatingSystemService.save(mobileOperatingSystem);
        return "redirect:/mobileoperatingsystem/list.mobileoperatingsystem";
    }



    @GetMapping("/list.mobileoperatingsystem")
    public String listMS(Model model){
        List<MobileOperatingSystem> mobileOperatingList = mobileOperatingSystemService.findAll();
        model.addAttribute("mobileOperatingList",mobileOperatingSystemService.findAll());
        return "administration/mobileoperatingsystem/list";
    }
}
