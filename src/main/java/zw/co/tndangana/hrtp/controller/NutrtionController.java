package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.nutrition.Nutrition;
import zw.co.tndangana.hrtp.domain.nutrition.TakingTradFood;
import zw.co.tndangana.hrtp.service.NutritionService;
import zw.co.tndangana.hrtp.service.PatientService;
import zw.co.tndangana.hrtp.service.TradFoodBeingTakenService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/13/17.
 */
@Controller
@RequestMapping("/nutrition/")
public class NutrtionController {
    @Resource
    private NutritionService nutritionService;
    @Resource
    private PatientService patientService;
    @Resource
    private TradFoodBeingTakenService tradFoodBeingTakenService;
    private Patient patient;

    @GetMapping("add.form/{patientId}")
    public String createForm(Model model, @PathVariable("patientId") Long patientId){
        patient = patientService.findOne(patientId);
        Nutrition nutrition = new Nutrition();
        if(patientId!=null){
      nutrition.setPatient(patient);
        }else throw new IllegalArgumentException("Cannot add data without patient id.");

        model.addAttribute("nutrition",nutrition);
        populateModel(model);
        return "nutrition/add";
    }
    @PostMapping("submit.form/{patientId}")
    public String submitForm(@PathVariable("patientId") Long patientId,
                             @Validated @ModelAttribute("nutrition") Nutrition nutrition,
                             BindingResult result,Model model){
        patient = patientService.findOne(patientId);
        if(result.hasErrors()){
            populateModel(model);
            return "nutrition/add";
        }else{
          nutrition.setPatient(patient);
            nutritionService.save(nutrition);
        }
   return "redirect:/patient/view/"+nutrition.getPatient().getId();
    }
    @GetMapping("/update.form/nutrtion/{nutrtionId}/patient/{patientId}")
    public String createUpdate(@PathVariable("nutritionId") Long nutritionId,Model model){
         model.addAttribute("nutrition",nutritionService.findOne(nutritionId));
        populateModel(model);
        return "nutrition/edit";
    }
    @PostMapping("submit.update")
    public String submitUpadate(@Validated@ModelAttribute("nutrition") Nutrition nutrition,
                                BindingResult result,
                                Model model ,@PathVariable("patientId") Long patientId){

        if (result.hasErrors()){
              populateModel(model);
            return "nutrition/edit";
        }else {
            patient = patientService.findOne(patientId);
            nutrition.setPatient(patient);
            nutritionService.save(nutrition);
        }

        return "redirect:/patient/view/"+nutrition.getPatient().getId();


    }



    public void populateModel(Model model){
    model.addAttribute("");
    model.addAttribute("tradFoodBeingTakenList",tradFoodBeingTakenService.findAll());
    model.addAttribute("takingTradFoodList", TakingTradFood.values());

    }

}
