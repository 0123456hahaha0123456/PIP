package com.lab4.model;

import com.lab4.entities.User;
import com.lab4.responsitory.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return new BCryptPasswordEncoder();}

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

    public void insert(User user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        //System.out.println("model");
        userRespository.save(user);
       // System.out.println("model done");
    }

    public User getUser(String name){
        return userRespository.findByUsername(name);
    }
}
