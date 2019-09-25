package com.lab4.controllers;

import com.lab4.entities.User;
import com.lab4.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //@ResponseBody
    public ModelAndView publishUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User tmp = userService.getUser(user.getUsername());
        if (tmp!=null){
            System.out.println("wrong");
            modelAndView.setViewName("login.html");
        }else{
            user.setRole();
            user.setEnabled(true);
            userService.insert(user);
            System.out.println("done");
            //modelAndView.setViewName("redirect:/username");
            return new ModelAndView("redirect:/username");
        }
        return modelAndView;
    }
/*

    @PostMapping(value="/postLogin")
    @ResponseBody
    public ModelAndView _publishUser(@RequestBody  User user) {
        ModelAndView modelAndView = new ModelAndView();
        User tmp = userService.getUser(user.getUsername());
        if (tmp!=null){
            System.out.println("wrong");
            modelAndView.setViewName("login.html");
        }else{
            user.setRole();
            userService.insert(user);
            System.out.println("done");
            modelAndView.setViewName(".html");
        }
        return modelAndView;
    }*/
}
