package com.lab4.model;

import com.lab4.entities.User;
import com.lab4.responsitory.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    @Bean
   // public PasswordEncoder getPasswordEncoder(){ return new DelegatingPasswordEncoder();}
     public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
     }

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

    public void insert(User user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        userRespository.save(user);
    }

    public User getUser(String name){
        return userRespository.findByUsername(name);
    }
}
