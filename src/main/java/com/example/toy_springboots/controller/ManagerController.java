package com.example.toy_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {
    
    @GetMapping({"/admin/*"})
    public ModelAndView admin(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/read");
        return modelAndView; 
    }
        
    @GetMapping({"/manager/*"})
    public ModelAndView manager(ModelAndView modelAndView){
        modelAndView.setViewName("/manager/read");
        return modelAndView;
    }        

    @GetMapping({"/main"})
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.setViewName("/main");
        return modelAndView;
    }
}
