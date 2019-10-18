package com.lab4.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@RestController
@CrossOrigin(origins = "http:localhost/8080")
public class MainController {
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        //System.out.println("tao la duc");
        return principal.getName();
    }

    @GetMapping("/login")
    public ModelAndView home(){
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        return view;
    }

    @GetMapping("/")
    public ModelAndView register(){
        ModelAndView _view = new ModelAndView();
        _view.setViewName("register");
        return _view;
    }

    @GetMapping("/main")
    @ResponseBody
    public ModelAndView main(){
        ModelAndView view = new ModelAndView();
        view.setViewName("graph");
        return view;
    }

    @GetMapping("/test_index")
    @ResponseBody
    public ModelAndView test_index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
