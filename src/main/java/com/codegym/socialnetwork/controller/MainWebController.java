package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.service.conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainWebController {
    @Autowired
    private ConversationService conversationService;

    @GetMapping
    public ModelAndView mainWeb(){
        ModelAndView model = new ModelAndView("index");
        List<Conversation> conversations = (List<Conversation>) conversationService.findAllNewestRecord();
        model.addObject("conversations", conversations);
        return model;
    }
    @GetMapping("/post")
    public ModelAndView post(@RequestParam(value = "id", required = true) Long id){
        ModelAndView modelAndView;
        Optional<Conversation> optionalConversation = conversationService.findById(id);
        if(optionalConversation.isPresent()){
            Conversation conversation = optionalConversation.get();
            return modelAndView = new ModelAndView("/conversation/post", "conversation",conversation);
        }else {
            return modelAndView = new ModelAndView("error-404");
        }
    }
}
