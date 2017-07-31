package zw.co.tndangana.hrtp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.*;
import zw.co.tndangana.hrtp.service.*;

import javax.annotation.Resource;

/**
 * Created by tndangana on 6/22/17.
 */
@RequestMapping("/patient/")
@Controller
public class PatientController {
    @Resource
    private PatientService patientService;
    @Resource
    private AddressService addressService;
    @Resource
    private OccupationService occupationService;
    @Resource
    private QualificationService qualificationService;
    @Resource
    TitleService titleService;
    @Resource
    private ReligionService religionService;
    @Resource
    private MaritalStatusService maritalStatusService;
    @Resource
    private ContactService contactService;
    @Resource
    private IctDataService ictDataService;
    @Resource
    private PsychoSocialService psychoSocialService;

    private final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Resource
    private AccommodationService accommodationService;
    @GetMapping("add.form")
    public String createPatientForm(Model model){
        model.addAttribute("patient",new Patient());
         populateModel(model);
         return "patient/add";
    }
    @PostMapping("/submit.form")
public String submitPatientForm(Model model, @Validated @ModelAttribute("patient") Patient patient, BindingResult bindingResult, RedirectAttributes redirectAttributes ){
        if (bindingResult.hasErrors()){

            populateModel(model);

            return "patient/add";
        }else {

            patientService.save(patient);
        }
     return "redirect:/patient/view/"+ patient.getId();
    }

    @GetMapping("/create.update/{patientId}")
    public String createUpdate(@PathVariable("patientId") Long patientId,Model model){
    model.addAttribute("patient",patientService.findOne(patientId));
    populateModel(model);

     return "patient/edit";
    }
    @PostMapping("/submit.update/{patientId}")
    public String submitUpdate(Model model,@Validated @ModelAttribute("patient") Patient patient,BindingResult result,@PathVariable("patientId")Long patientId){
        patient.setId(patientId);
        if(result.hasErrors()){
            populateModel(model);
            return "patient/edit";
        }else{
            patientService.save(patient);

        }
        return "redirect:/patient/view/"+ patient.getId();

    }
    @GetMapping("view/{patientId}")
    public String viewPatientForm(@PathVariable("patientId") Long patientId,Model model){

    if (patientId == null){
        model.addAttribute("msg","Patient Record Not Found !!");
    }else
        {

        final Patient patient = patientService.findOne(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("addressList",addressService.findAddressesByPatient(patient));
        model.addAttribute("contactList",contactService.findContactsByPatient(patient));
        model.addAttribute("ictDataList",ictDataService.findIctDataByPatient(patient));
        model.addAttribute("psychList",psychoSocialService.findPsychoSocialsByPatient(patient));
     }

    return "patient/view";
    }

    private void populateModel(Model model){
   model.addAttribute("qualificationList",qualificationService.findAll());
   model.addAttribute("accommodationList",accommodationService.findAll());
   model.addAttribute("occupationList",occupationService.findAll());
   model.addAttribute("titleList",titleService.findAll());
   model.addAttribute("genderList",Gender.values());
   model.addAttribute("religionList",religionService.findAll());
   model.addAttribute("maritalstatusList",maritalStatusService.findAll());

    }

}
