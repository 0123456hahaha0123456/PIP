package com.lab4.controllers;

import com.lab4.entities.User;
import com.lab4.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseBody
    public User publishUser(@RequestBody User user) {
        System.out.println("duc dep trai");
        userService.insert(user);
        System.out.println("yeu em");
        return user;
    }
}
