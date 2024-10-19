package org.spring.mvc;

import org.spring.mvc.entity.Tire;
import org.spring.mvc.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
public class MyController {

    @Autowired
    private TireService tireService;
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/tire")
    public String tire() {
        return "tire";
    }

    @RequestMapping(path="/tireChoose", method = RequestMethod.POST)
    public String tireChoose(@ModelAttribute Tire tire, Model model){
        tireService.tireChoose(tire);
        model.addAttribute("Msg", tire);
        return "result";
    }
}

