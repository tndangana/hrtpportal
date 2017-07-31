package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.psycho.SurplusProduceUsage;
import zw.co.tndangana.hrtp.service.SurplusProduceUsageService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/13/17.
 */
@RequestMapping("/surplusProduceUsage/")
@Controller
public class SurplusProduceUsageController {
    
    @Resource
    private SurplusProduceUsageService surplusProduceUsageService;

    @GetMapping("add.form")
    public  String createForm(Model model){
        model.addAttribute("surplusProduceUsage",new SurplusProduceUsage());
        return "administration/surplusProduceUsage/add";
    }
    @PostMapping("submit.form")
    public String submitForm(Model model, @Validated @ModelAttribute("surplusProduceUsage") SurplusProduceUsage surplusProduceUsage, BindingResult result){
        if(result.hasErrors()){

            return "administration/surplusProduceUsage/add";
        }else{

            surplusProduceUsageService.save(surplusProduceUsage);
        }
        return "redirect:/surplusProduceUsage/list";

    }
    @GetMapping("update.form/{surplusProduceUsageId}")
    public String updateForm(Model model, @PathVariable("surplusProduceUsageId") Long surplusProduceUsageId){
        model.addAttribute("surplusProduceUsage",surplusProduceUsageService.findOne(surplusProduceUsageId));
        return "administration/surplusProduceUsage/edit";
    }
    @PostMapping("submit.update/{surplusProduceUsageId}")
    public String submitUpdate(@PathVariable("surplusProduceUsageId") Long surplusProduceUsageId, @Validated @ModelAttribute("surplusProduceUsage") SurplusProduceUsage surplusProduceUsage,BindingResult result,Model model){
        surplusProduceUsage.setId(surplusProduceUsageId);
        if(result.hasErrors()){

            return "administration/surplusProduceUsage/edit";
        }else {

            surplusProduceUsageService.save(surplusProduceUsage);
        }

        return "redirect:/surplusProduceUsage/list";
    }

    @GetMapping("list")
    public String ListForm(Model model){
        model.addAttribute("surplusProduceUsageList",surplusProduceUsageService.findAll());
        return "administration/surplusProduceUsage/list";
    }
}
