package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.Address;
import zw.co.tndangana.hrtp.domain.Contact;
import zw.co.tndangana.hrtp.domain.ContactType;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.service.ContactService;
import zw.co.tndangana.hrtp.service.PatientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/6/17.
 */
@Controller
@RequestMapping("/contact/")
public class ContactController {
    @Resource
    private ContactService contactService;
    private Patient patient;
    @Resource
    private PatientService patientService;
    @GetMapping("/add.form/{patientId}")
    public String createFormById(@PathVariable("patientId") Long patientId,Model model){
        Patient patient = patientService.findOne(patientId);
        Contact contact = new Contact();
        if(patientId == null){
            throw new IllegalArgumentException("Contact not binded to patient");
        }else{
            contact.setPatient(patient);
        }
        model.addAttribute("patient",patient);//patient id will be hidden in form
        model.addAttribute("contact",contact);
        populateModel(model);
        return "contact/add";
    }
    @PostMapping("/submit.form/{patientId}")
    public String submitForm(Model model,@PathVariable("patientId") Long patientId,@Validated @ModelAttribute("contact") Contact contact, BindingResult result, RedirectAttributes redirectAttributes){
        Patient patient = patientService.findOne(patientId);
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("msg","Something is not right");
            populateModel(model);
            return "contact/add";
        }else{
            redirectAttributes.addFlashAttribute("msg","Successfully saved");
              contact.setPatient(patient);
              contactService.save(contact);
        }
        return "redirect:/patient/view/"+contact.getPatient().getId();
    }
    @GetMapping("update.form/{contactId}")
    public String updateForm(Model model,@PathVariable("contactId") Long contactId){
        Contact contact = contactService.findOne(contactId);
        model.addAttribute("contact",contact);
        populateModel(model);
        return "contact/edit";
    }
    @PostMapping("submit.update/{contactId}/{patientId}")
    public String submitUpdate(Model model,@PathVariable("contactId") Long contactId,@PathVariable("patientId") Long patientId,@Validated @ModelAttribute("contact") Contact contact,BindingResult result ){
        patient = patientService.findOne(patientId);
        contact.setId(contactId);
        contact.setPatient(patient);

        if(result.hasErrors()){
            populateModel(model);
            return "contact/edit";
        }else {
            if(contact.isNew()){
                contactService.save(contact);
            }
        }
        return "redirect:/patient/view/"+contact.getPatient().getId();
    }
    public void populateModel(Model model){
        model.addAttribute("contactTypeList", ContactType.values());
    }

}
