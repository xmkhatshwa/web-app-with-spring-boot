package com.in28minutes.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex.getStackTrace());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
