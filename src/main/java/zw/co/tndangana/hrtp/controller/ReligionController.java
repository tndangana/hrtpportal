package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Religion;
import zw.co.tndangana.hrtp.service.ReligionService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 6/21/17.
 */
@Controller
@RequestMapping("/religion/")
public class ReligionController {
    @Resource
    private ReligionService religionService;

    @GetMapping({"add.religion"})
    public String createForm(Model model){
        model.addAttribute("religion",new Religion());
        return "administration/religion/add";
    }

    @PostMapping("submit.form")
    public String submitForm(@Valid @ModelAttribute("religion") Religion religion, BindingResult result, RedirectAttributes redirectAttributes){
      if (result.hasErrors())
      {
          redirectAttributes.addFlashAttribute("msg","Something is not right!!");
       return "administration/religion/add";
      }else
          {if(religion.isNew()) {
              redirectAttributes.addFlashAttribute("msg", "religion added successfully");
          }else{
              redirectAttributes.addFlashAttribute("msg","religion updated successfully");
          }
          religionService.save(religion);
          }
          return "redirect:/religion/list.religion";
    }
    @GetMapping("/update.form/{religionId}")
    public String updateForm(@PathVariable("religionId") Long religionId,Model model){
        model.addAttribute("religion",religionService.findOne(religionId));
        return "administration/religion/edit";
    }
    @PostMapping("submit.update/{religionId}/update")
    public String postUpdate(@PathVariable("religionId") Long religionId, @Validated @ModelAttribute("religion") Religion religion,BindingResult result){
        religion.setId(religionId);
        if(result.hasErrors()){
            return "administration/religion/edit";
        }
        else{ religionService.save(religion);}

        return "redirect:/religion/list.religion";
    }
   @GetMapping("list.religion")
    public String ListReligion(Model model){
        model.addAttribute("religionlist",religionService.findAll());
       return "administration/religion/list";
    }



}
