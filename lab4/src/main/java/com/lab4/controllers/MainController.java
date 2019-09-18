package com.lab4.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;


@Controller
public class MainController {
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/")
    public String home(){
        return "login.html";
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView _view = new ModelAndView();
        _view.setViewName("index.html");
        return _view;
    }
}
