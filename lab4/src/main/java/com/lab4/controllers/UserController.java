package com.lab4.controllers;

import com.lab4.entities.User;
import com.lab4.entities.AuthRes;
import com.lab4.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost/8081")
@RequestMapping(value="/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @GetMapping("/register")
    public ModelAndView registation() {
        ModelAndView _view = new ModelAndView();
        _view.setViewName("register");
        //_view.setViewName("test_register");
        return _view;
    }
/*
    //, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    @PostMapping(value="/register")//create form register
    public AuthRes publishUser(User user) {
        List<AuthRes> res = new ArrayList<>();
       // ModelAndView modelAndView = new ModelAndView();
        User tmp = userService.getUser(user.getUsername());
        AuthRes authRes;// = new AuthRes(user.getUsername());
        if (tmp!=null){
            System.out.println("wrong");
            authRes = new AuthRes(false,"Username was taken");
            //res.add(authRes);
            return authRes;
        }else{
            user.setRole();
            user.setEnabled(true);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            userService.insert(user);
            authRes = new AuthRes(true,"Successful");
            //res.add(authRes);
            return authRes;
        }

    }

*/
    @PostMapping(value="/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)//create form register
    @ResponseBody
    public ModelAndView publishUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User tmp = userService.getUser(user.getUsername());
        if (tmp!=null){
            System.out.println("wrong");
            modelAndView.setViewName("redirect:/");
        }else{
            user.setRole();
            user.setEnabled(true);
            userService.insert(user);
            System.out.println("done");
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }

}
