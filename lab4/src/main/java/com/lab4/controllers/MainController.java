package com.lab4.controllers;


import com.lab4.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MainController {
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(/*Principal principal*/) {
        System.out.println("tao la duc");
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println(username);
        return username;
       // return principal.getName();

    }

    @GetMapping("/login")
    public ModelAndView home(){
        ModelAndView view = new ModelAndView();
        view.setViewName("login.html");
        return view;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView _view = new ModelAndView();
        _view.setViewName("index.html");
        return _view;
    }
}
