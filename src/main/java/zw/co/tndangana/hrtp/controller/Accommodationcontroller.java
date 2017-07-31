package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Accommodation;
import zw.co.tndangana.hrtp.service.AccommodationService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
@Controller
@RequestMapping("/accommodation")
public class Accommodationcontroller {

    @Resource
    private AccommodationService accommodationService;

    @GetMapping({"/add.form"})
    public String createAccommodationForm(Model model) {
        model.addAttribute("title","Accommodation Detail");
        model.addAttribute("accommodation", new Accommodation());
        return "administration/accommodation/add";
    }

    @GetMapping("/update.form/{accommodationId}")
    public String editForm(Model model, @PathVariable("accommodationId") Long maritalstatusId) {
        model.addAttribute("accommodation", accommodationService.findOne(maritalstatusId));
        return "administration/accommodation/edit";
    }

    @PostMapping("/submit.form")
    public String postRecord(@Validated @ModelAttribute("accommodation") Accommodation accommodation, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Something is not right!!");
            return "administration/accommodation/add";
        } else {
            if (accommodation.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "record added successfully");
            } else {
                redirectAttributes.addFlashAttribute("msg", "record updated successfully");


            }
            accommodationService.save(accommodation);
        }
        return "redirect:/accommodation/list.accommodation";
    }

    @PostMapping("/update.form/{accommodationId}/update")
    public String updateForm(@PathVariable("accommodationId") Long accommodationId, Model model, @Valid @ModelAttribute("accommodation") Accommodation accommodation, BindingResult result) {
        accommodation.setId(accommodationId);
        if (result.hasErrors()) {
            return "administration/accommodation/edit";
        }
        accommodationService.save(accommodation);
        return "redirect:/accommodation/list.accommodation";
    }


    @GetMapping("/list.accommodation")
    public String listMS(Model model) {
        List<Accommodation> accommodationList = accommodationService.findAll();
        model.addAttribute("accommodationList", accommodationService.findAll());
        model.addAttribute("count",accommodationService.count());
        return "administration/accommodation/list";
    }
    @PostMapping("delete.form/{accId}")
    public String deleteForm(@PathVariable("Id") Long Id){
        Long accId = accommodationService.findOne(Id).getId();
        accommodationService.delete(accId);
        return "";
    }
}