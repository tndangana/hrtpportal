package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;
import zw.co.tndangana.hrtp.domain.psycho.SkillTrainingReceived;
import zw.co.tndangana.hrtp.domain.psycho.SurplusProduce;
import zw.co.tndangana.hrtp.domain.psycho.ZNNPAffiliation;
import zw.co.tndangana.hrtp.service.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by tndangana on 7/13/17.
 */
@Controller
@RequestMapping("/psychoSocial/")
public class PsychoSocialController {
    @Resource
    private PsychoSocialService psychoSocialService;
    @Resource
    private IncomeGeneratingProjectService incomeGeneratingProjectService;
    @Resource
    private AgricPractiseService agricPractiseService;
    @Resource
    private SurplusProduceUsageService surplusProduceUsageService;
    @Resource
    private SkillTrainingReceivedService skillTrainingReceivedService;
    @Resource
    PatientService patientService;
    private Patient patient;

    @GetMapping("/add.form/{patientId}")
    public String createForm(Model model, @PathVariable("patientId") Long patientId){
        patient = patientService.findOne(patientId);
        PsychoSocial psychoSocial = new PsychoSocial();
        psychoSocial.setPatient(patient);
        model.addAttribute("psychoSocial",psychoSocial);
        populateModel(model);
        return "psychoSocial/add";
    }

    @PostMapping("submit.form/{patientId}")
    public String submitForm(Model model, @Valid @ModelAttribute("psychoSocial") PsychoSocial psychoSocial, BindingResult result,@PathVariable("patientId") Long patientId){
     patient = patientService.findOne(patientId);
     psychoSocial.setPatient(patient);
     if(result.hasErrors()){
         populateModel(model);
         return "psychoSocial/add";
     }else {

         if(psychoSocial.isNew()){

             psychoSocialService.save(psychoSocial);
         }
         else{
             throw new IllegalArgumentException("id already occupied");
         }
     }

        return "redirect:/patient/view/" + psychoSocial.getPatient().getId();

    }
    @GetMapping("update.form/{psychosocialId}")
    public String updateForm(@PathVariable("psychosocialId") Long psychosocialId,Model model){
        model.addAttribute("psychoSocial",psychoSocialService.findOne(psychosocialId));
        populateModel(model);
        return "psychoSocial/edit";
    }
    @PostMapping("submit.update/psych/{psychosocialId}/patient/{patientId}")
    public String submitUpdate(@Validated @ModelAttribute("psychoSocial") PsychoSocial psychoSocial,
                               @PathVariable("psychosocialId") Long psychosocialId,
                               @PathVariable("patientId") Long patientId,BindingResult result
                               ,Model model){

              patient = patientService.findOne(patientId);
              psychoSocial.setPatient(patient);
              psychoSocial.setId(psychosocialId);
              if(result.hasErrors()){
                  populateModel(model);
                  return "psychoSocial/edit";
              }else{

                  psychoSocialService.save(psychoSocial);
              }


        return "redirect:/patient/view/" + psychoSocial.getPatient().getId();
    }

    public void populateModel(Model model){
        model.addAttribute("incomeGeneratingProjectList",incomeGeneratingProjectService.findAll());
        model.addAttribute("agricPractiseList",agricPractiseService.findAll());
        model.addAttribute("surplusProduceUsage",surplusProduceUsageService.findAll());
        model.addAttribute("znnpList", ZNNPAffiliation.values());
        model.addAttribute("suplusProduceList", SurplusProduce.values());

        //\][l.addAttribute("skilledList",skillTrainingReceivedService.findByPsychoSocial(psychoSocial));

    }
}
