package com.codegym.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainWebController {

    @GetMapping
    public ModelAndView mainWeb(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}
