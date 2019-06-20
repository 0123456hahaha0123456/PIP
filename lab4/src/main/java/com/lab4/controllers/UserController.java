package com.lab4.controllers;

import com.lab4.entities.User;
import com.lab4.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value= "/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/users")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/user")
    public String publishUser(@RequestBody User user) {
        userService.insert(user);
        return "Point was published";
    }


}
