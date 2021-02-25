package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.model.User;
import com.codegym.socialnetwork.service.ConversationService;
import com.codegym.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadFileController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView createForm(){
        User user = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView("conversation/upload");
        modelAndView.addObject("user",user);
        modelAndView.addObject("conversation", new Conversation());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView saveCreateForm(@ModelAttribute("conversation") Conversation conversation){
        MultipartFile multipartFile = conversation.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(conversation.getImg().getBytes(), new File(uploadPath + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        conversation.setImgSrc(fileName);
        conversation.setUpvote(0L);
        conversationService.save(conversation);
        ModelAndView model = new ModelAndView("redirect:/upload");
        model.addObject("conversation",new Conversation());
        model.addObject("message","New Conversation was posted");
        return model;
    }
}
