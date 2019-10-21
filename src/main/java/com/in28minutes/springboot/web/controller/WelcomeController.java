package com.in28minutes.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap modelMap){

        System.out.println("hello " + getLoggedInUsername() + " \n\n");
        modelMap.put("username", getLoggedInUsername());

        return "welcome";
    }

    private String getLoggedInUsername(){
        Object principal = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getPrincipal();

        if(principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }



}