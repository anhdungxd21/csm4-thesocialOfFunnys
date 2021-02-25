package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.User;
import com.codegym.socialnetwork.model.UserInfoComment;
import com.codegym.socialnetwork.repository.user.UserInfoCommentRepository;
import com.codegym.socialnetwork.service.IUserInfoCommentService;
import com.codegym.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private IUserInfoCommentService userInfoCommentService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/u/{username}", method = RequestMethod.GET)
    public ModelAndView getUserInformationForm(@PathVariable("username") String username){
        User userInfo = userService.findUserByUsername(username);
        User CurrentUser = userService.getCurrentUser();
        ModelAndView model;
        if(userInfo == null){
           return new ModelAndView("/error-404");
        }
        //Xem chính mình
        if(userInfo.getUsername().equals(CurrentUser.getUsername())){
            List<UserInfoComment> comments = userInfoCommentService.findAllByUsername(username);
            model = new ModelAndView("/user/userOwnInformation","user", CurrentUser);
            model.addObject("comments",comments);
            return model;
        }
        //Xem user khác
        model = new ModelAndView("/user/userInformation", "user",CurrentUser);
        List<UserInfoComment> comments = userInfoCommentService.findAllByUsername(username);
        model.addObject("userInfo",userInfo);
        model.addObject("comments",comments);
        return model;
    }

    @RequestMapping(value = "/u/{username}", method = RequestMethod.POST)
    public ModelAndView getUserInformationForm(@PathVariable("username") String username,
            @RequestParam(value = "description", required = false)String description,
            @RequestParam(value = "commentUser", required = false)String commentUser){
        if(commentUser != null){
            UserInfoComment userInfoComment = new UserInfoComment();
            userInfoComment.setId(null);
            userInfoComment.setUsername(username);
            userInfoComment.setUserCommentName(userService.getCurrentUser().getUsername());
            userInfoComment.setComment(commentUser);
            userInfoCommentService.save(userInfoComment);
            return new ModelAndView("redirect:/u/"+username);
        }
        User user = userService.getCurrentUser();
        user.setDescription(description);
        userService.save(user);
        return new ModelAndView("redirect:/u/"+username);
    }
}
