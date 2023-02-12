package com.example.toy_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
    
    @GetMapping({"loginForm"})
    public ModelAndView loginForm(ModelAndView modelAndView){
        modelAndView.setViewName("security/loginForm");
        return modelAndView;
    }
    
    @GetMapping({"logoutForm"})
    public ModelAndView logoutForm(ModelAndView modelAndView){
        modelAndView.setViewName("security/logoutForm");
        return modelAndView;
    }
}
