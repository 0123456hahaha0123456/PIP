package com.lab4.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

@RestController
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
    public String index(){
        return "index.html";
    }
}