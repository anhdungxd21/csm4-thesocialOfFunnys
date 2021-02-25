package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.User;
import com.codegym.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInforController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/u/{username}", method = RequestMethod.GET)
    public ModelAndView getUserInformation(@PathVariable("username") String username){
        User userInfo = userService.findUserByUsername(username);
        User CurrentUser = userService.getCurrentUser();
        ModelAndView model;
        if(userInfo == null){
           return new ModelAndView("/error-404");
        }
        //Xem chính mình
        if(userInfo.getUsername().equals(CurrentUser.getUsername())){
            model = new ModelAndView("/user/userOwnInformation","user", CurrentUser);
            return model;
        }
        //Xem user khác
        model = new ModelAndView("/user/userInformation", "user",CurrentUser);
        model.addObject("userView",userInfo);
        return model;
    }
}
