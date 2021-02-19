package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.converstation.Conversation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadFileController {

    @GetMapping
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/conversation/post");
        modelAndView.addObject("post", new Conversation());
        return modelAndView;
    }
}
