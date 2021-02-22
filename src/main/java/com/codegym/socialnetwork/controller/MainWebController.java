package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.service.conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainWebController {
    @Autowired
    private ConversationService conversationService;

    @GetMapping
    public ModelAndView mainWeb(){
        ModelAndView model = new ModelAndView("index");
        List<Conversation> conversations = (List<Conversation>) conversationService.findAll();
        model.addObject("conversations", conversations);
        return model;
    }
}