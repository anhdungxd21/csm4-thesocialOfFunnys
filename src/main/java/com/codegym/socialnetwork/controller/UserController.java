package com.codegym.socialnetwork.controller;

import com.codegym.socialnetwork.model.User;
import com.codegym.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public ModelAndView registerForm(){
        ModelAndView model = new ModelAndView("/user/register","user", new User());
        return model;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView model;
        if(user.getEmail() == null || user.getPassword() == null || user.getUsername() == null){
            model = new ModelAndView("/user/register","user",new User());
            model.addObject("message","Do not leave anything blank");
            return model;
        }
        if(userService.findUserByUsername(user.getUsername()) != null){
            model = new ModelAndView("/user/register","user",new User());
            model.addObject("message","User was existed");
            return model;
        }
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        model = new ModelAndView("redirect:/");
        return model;
    }

    @GetMapping("/login")
    public ModelAndView loginForm(){
        return new ModelAndView("/login");
    }
}
