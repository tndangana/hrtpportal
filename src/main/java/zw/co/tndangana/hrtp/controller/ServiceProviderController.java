package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zw.co.tndangana.hrtp.domain.ict.ServiceProvider;
import zw.co.tndangana.hrtp.service.ServiceProviderService;

import javax.annotation.Resource;

/**
 * Created by tndangana on 7/11/17.
 */
@Controller
@RequestMapping("/serviceProvider/")
public class ServiceProviderController {
    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("add.form")
    public String createform(Model model){
        model.addAttribute("serviceProvider",new ServiceProvider());
        return "administration/serviceprovider/add";
    }
    @PostMapping("submit.form")
    public String submitForm(@Validated @ModelAttribute("serviceProvider") ServiceProvider serviceProvider, BindingResult result, RedirectAttributes redirectAttributes){
         if(result.hasErrors()){
             redirectAttributes.addFlashAttribute("msg","Somethingd is not right!!");
             return "administration/serviceprovider/add";

         }else{
             if (serviceProvider.isNew()){
                 redirectAttributes.addFlashAttribute("msg","Success");
                 serviceProviderService.save(serviceProvider);
             }

          }
          return "redirect:/serviceProvider/list";

    }
    @GetMapping("/update.form/{serviceProviderId}")
    public String updateForm(@PathVariable("serviceProviderId") Long serviceProviderId,Model model){
        model.addAttribute("serviceProvider",serviceProviderService.findOne(serviceProviderId));

        return "administration/serviceprovider/edit";
    }
    @PostMapping("submit.update/{serviceProviderId}")
    public String submitUpdate(@PathVariable("serviceProviderId") Long serviceProviderId, @Validated @ModelAttribute("serviceProvider") ServiceProvider serviceProvider,BindingResult result){
        serviceProvider.setId(serviceProviderId);
        if(result.hasErrors()){
            return "serviceprovider/edit";
        }else{
            if(!serviceProvider.isNew()){
                serviceProviderService.save(serviceProvider);
            }
        }
        return "redirect:/serviceProvider/list";

    }
    @GetMapping("list")
    public String listForm(Model model){
        model.addAttribute("serviceProviderList",serviceProviderService.findAll());
        return "administration/serviceprovider/list";

    }
}
