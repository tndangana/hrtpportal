package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tndangana on 6/21/17.
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","ZZZZZZ---ZZZZ-zzz-ZZZ");
        return "index";
    }
    @GetMapping("/administration/list")
    public String adminstrationhandler(Model model){
        model.addAttribute("title","Adminstrator");

   return "administration/list";
    }

}
