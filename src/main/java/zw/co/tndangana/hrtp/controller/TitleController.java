package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Title;

import zw.co.tndangana.hrtp.service.TitleService;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * Created by tndangana on 6/21/17.
 */
@RequestMapping("/title/")
@Controller
public class TitleController {
    @Resource
    private TitleService titleService;

    @GetMapping({"add.title"})
    public String createForm(Model model){
        model.addAttribute("title",new Title());
        return "administration/title/add";
    }

    @PostMapping("submit.form")
    public String submitForm(@Valid @ModelAttribute("title") Title title, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors())
        {
            redirectAttributes.addFlashAttribute("msg","Something is not right!!");
            return "administration/title/add";
        }else
        {if(title.isNew()) {
            redirectAttributes.addFlashAttribute("msg", "title added successfully");
        }else{
            redirectAttributes.addFlashAttribute("msg","title updated successfully");
        }
            titleService.save(title);
        }
        return "redirect:/title/list.title";
    }
    @GetMapping("/update.form/{titleId}")
    public String updateForm(@PathVariable("titleId") Long titleId,Model model){
        model.addAttribute("title",titleService.findOne(titleId));
        return "administration/title/edit";
    }
    @PostMapping("submit.update/{titleId}/update")
    public String postUpdate(@PathVariable("titleId") Long titleId, @Validated @ModelAttribute("title") Title title,BindingResult result){
        title.setId(titleId);
        if(result.hasErrors()){
            return "administration/title/edit";
        }
        else{ titleService.save(title);}

        return "redirect:/title/list.title";
    }
    @GetMapping("list.title")
    public String ListTitle(Model model){
        model.addAttribute("titlelist",titleService.findAll());
        return "administration/title/list";
    }



}
