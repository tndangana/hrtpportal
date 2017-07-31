package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.nutrition.TradFoodBeingTaken;
import zw.co.tndangana.hrtp.service.TradFoodBeingTakenService;

import javax.annotation.Resource;

/*
 * Created by tndangana on 7/15/17.
 */
@Controller
@RequestMapping("/tradFoodBeingTaken/")
public class TradFoodBeingTakenController {


    @Resource
    private TradFoodBeingTakenService tradFoodBeingTakenService;
    @GetMapping("add")
    public  String createForm(Model model){
        model.addAttribute("tradFoodBeingTaken",new TradFoodBeingTaken());
        return "administration/tradFoodBeingTaken/add";
    }
    @PostMapping("submit.form")
    public String submitForm(Model model, @ModelAttribute("tradFoodBeingTaken") TradFoodBeingTaken tradFoodBeingTaken, BindingResult result){
        if(result.hasErrors()){

            return "administration/tradFoodBeingTaken/add";
        }else{

            tradFoodBeingTakenService.save(tradFoodBeingTaken);
        }
        return "redirect:/tradFoodBeingTaken/list";

    }
    @GetMapping("update.form/{tradFoodBeingTakenId}")
    public String updateForm(Model model, @PathVariable("tradFoodBeingTakenId") Long tradFoodBeingTakenId){
        model.addAttribute("tradFoodBeingTaken",tradFoodBeingTakenService.findOne(tradFoodBeingTakenId));
        return "administration/tradFoodBeingTaken/edit";
    }

    @PostMapping("update.form/{tradFoodBeingTakenId}")
    public String submitUpdate(@PathVariable("tradFoodBeingTakenId") Long tradFoodBeingTakenId,@ModelAttribute("tradFoodBeingTaken") TradFoodBeingTaken tradFoodBeingTaken,BindingResult result,Model model){
        tradFoodBeingTaken.setId(tradFoodBeingTakenId);
        if(result.hasErrors()){

            return "administration/tradFoodBeingTaken/edit";
        }else {

            tradFoodBeingTakenService.save(tradFoodBeingTaken);
        }

        return "redirect:/tradFoodBeingTaken/list";
    }
    @GetMapping("list")
    public String ListForm(Model model){
        model.addAttribute("tradFoodBeingTakenList",tradFoodBeingTakenService.findAll());
        return "administration/tradFoodBeingTaken/list";
    }
}
