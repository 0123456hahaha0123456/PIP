package com.lab4;
import com.lab4.controllers.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = pointController.class)
@ComponentScan(basePackageClasses = MainController.class)

public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
