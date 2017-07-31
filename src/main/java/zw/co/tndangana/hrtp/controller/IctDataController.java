package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.ict.*;
import zw.co.tndangana.hrtp.service.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tndangana on 7/8/17.
 */
@Controller
@RequestMapping("/ictData/")
public class IctDataController {
    @Resource
    private IctDataService ictDataService;
    private Patient patient;
    @Resource
    private MobileOperatingSystemService mobileOperatingSystemService;
    @Resource
    private SocialMediaApplicationService socialMediaApplicationService;
    @Resource
    private SocialMediaBenefitsService socialMediaBenefitsService;
    @Resource
    private SocialMediaGeneratingMethodsService socialMediaGeneratingMethodsService;
    @Resource
    private ServiceProviderService serviceProviderService;
    @Resource
    PatientService patientService;
    @GetMapping("/add.form/{patientId}")
    public String createFormById(@PathVariable("patientId") Long patientId,Model model){
        Patient patient = patientService.findOne(patientId);
        IctData ictData = new IctData();
        if(patient.getId()!=null){
            ictData.setPatient(patient);
        }else{
            throw new IllegalArgumentException("Ict Data is not binned to any patient");
        }
        model.addAttribute("patient",patient);//ID to be hidden in ictDATA FORM
        model.addAttribute("ictData",ictData);
        populateModel(model);
        return "ict/add";

    }
    @PostMapping("/submit.form/{patientId}")
    public String submitForm(@PathVariable("patientId") Long patientId, Model model,@Validated @ModelAttribute("ictData") IctData ictData, BindingResult result, RedirectAttributes redirectAttributes){
        Patient patient = patientService.findOne(patientId);
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right !!");
            populateModel(model);
            return "ict/add";
        }else{
            if(ictData.isNew()){
                ictData.setPatient(patient);
                ictDataService.save(ictData);
            }

        }
      return "redirect:/patient/view/" + ictData.getPatient().getId();
    }
    @GetMapping("/update.form/{ictDataId}")
    public String updateForm(@PathVariable("ictDataId") Long ictDataId,Model model){
        model.addAttribute("ictData",ictDataService.findOne(ictDataId));
        populateModel(model);
        return "ict/edit";
    }
    @PostMapping("/submit.update/{ictDataId}/{patientId}")
    public String submitUpdate(@PathVariable("patientId") Long patientId, Model model,@Validated @ModelAttribute("ictData") IctData ictData,BindingResult result,@PathVariable("ictDataId") Long ictDataId){
        patient = patientService.findOne(patientId);
        ictData.setPatient(patient);
        ictData.setId(ictDataId);
        if(result.hasErrors()){
            populateModel(model);
            return "ict/edit";
        }else{
            ictDataService.save(ictData);
        }
        return "redirect:/patient/view/" + ictData.getPatient().getId();
    }

    public void populateModel(Model model){
        model.addAttribute("mobileOperatingSystemList",mobileOperatingSystemService.findAll());
        model.addAttribute("socialMediaApplicationList",socialMediaApplicationService.findAll());
        model.addAttribute("socialMediaBenefitsList",socialMediaBenefitsService.findAll());
        model.addAttribute("socialMediaGeneratingMethodsList",socialMediaGeneratingMethodsService.findAll());
        model.addAttribute("isSocialMediaGeneratingIncomeList", IsSocialMediaGeneratingIncome.values());
        model.addAttribute("isOnSocialMediaList", IsOnSocialMedia.values());
        model.addAttribute("socialMediaTrainingList",SocialMediaTraining.values());
        model.addAttribute("internetAccessOnDeviceList",InternetAccessOnDevice.values());
        model.addAttribute("hivDiscusionOnMediaList",HivDiscusionOnMedia.values());
        model.addAttribute("usedSocialMForMarketingList",UsedSocialMForMarketing.values());
        model.addAttribute("safeTrainingOfPatientList",SafeTrainingOfPatient.values());
        model.addAttribute("serviceProviderList",serviceProviderService.findAll());



    }
}
