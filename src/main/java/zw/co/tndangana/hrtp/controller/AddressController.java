package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Address;
import zw.co.tndangana.hrtp.domain.AddressType;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.service.AddressService;
import zw.co.tndangana.hrtp.service.CityService;
import zw.co.tndangana.hrtp.service.PatientService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/6/17.
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;
    @Resource
    private CityService cityService;
    private Patient patient;

    @Resource
    private PatientService patientService;
    @GetMapping("/add.form/{patientId}")
    public String createForm(@PathVariable("patientId") Long patientId, Model model){
        Address address = new Address();

        Patient patient = patientService.findOne(patientId);

               if(patientId != null){
                   address.setPatient(patient);
               }else
               { throw new IllegalArgumentException("Record not found");
               }
        model.addAttribute("patient",patient);
        model.addAttribute("address",address);
        populateModel(model);
         return "/address/add";
    }
    @PostMapping("/submit.form/{patientId}")
    public String submitForm(@PathVariable("patientId")Long patientId,@Validated @ModelAttribute("address") Address address, BindingResult result,Model model){
        Patient patient = patientService.findOne(patientId);
        if(result.hasErrors()){

           populateModel(model);
           return "/address/add";
        }else{
            if(address.isNew()){
                address.setPatient(patient);

                addressService.save(address);
        }
        }
        return "redirect:/patient/view/" + address.getPatient().getId();
    }
    @GetMapping("/{addressId}/update.form")
    public String updateForm(@PathVariable("addressId") Long addressId ,Model model){

        model.addAttribute("address",addressService.findOne(addressId));
        populateModel(model);
        return "address/edit";

    }
    @PostMapping("/submit.update/{addressId}/{patientId}")
    public String submitUpdate(@PathVariable("patientId") Long patientId,@ModelAttribute("address") @Validated Address address,@PathVariable("addressId") Long addressId,Model model,BindingResult result){
        patient = patientService.findOne(patientId);
        address.setPatient(patient);
        address.setId(addressId);
        if (result.hasErrors()){
            populateModel(model);
            return "address/edit";
        }else{
            addressService.save(address);
        }
        return "redirect:/patient/view/" + address.getPatient().getId();
    }

    private void populateModel(Model model){
        model.addAttribute("addressTypeList", AddressType.values());
        model.addAttribute("cityList",cityService.findAll());
    }
}
