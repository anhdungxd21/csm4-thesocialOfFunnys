package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.Comment;
import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.model.User;
import com.codegym.socialnetwork.service.ConversationService;
import com.codegym.socialnetwork.service.ICommentService;
import com.codegym.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainWebController {
    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserService userService;


    @GetMapping
    public ModelAndView mainWeb(){
        ModelAndView model = new ModelAndView("index");
        List<Conversation> conversations = (List<Conversation>) conversationService.findAllNewestRecord();
        User user = userService.getCurrentUser();
        model.addObject("user",user);
        model.addObject("conversations", conversations);
        return model;
    }
    @GetMapping("/post")
    public ModelAndView viewPost(@RequestParam(value = "id", required = true) Long id){
        ModelAndView modelAndView;
        Optional<Conversation> optionalConversation = conversationService.findById(id);
        if(optionalConversation.isPresent()){
            Conversation conversation = optionalConversation.get();
            List<Comment> comments = (List<Comment>) commentService.findAllByConversationId(id);
            modelAndView = new ModelAndView("/conversation/post", "conversation",conversation);
            modelAndView.addObject("user", userService.getCurrentUser());
            modelAndView.addObject("comment",new Comment());
            modelAndView.addObject("comments",comments);
            return modelAndView;
        }else {
            return modelAndView = new ModelAndView("error-404");
        }
    }
    @PostMapping("/post")
    public String postComment(@RequestParam(value = "id", required = true) Long id, @ModelAttribute("comment") Comment comment){
        comment.setConversationId(id);
        comment.setUserName(userService.getCurrentUser().getUsername());
        commentService.save(comment);
        return "redirect:/post?id="+id;
    }
}
