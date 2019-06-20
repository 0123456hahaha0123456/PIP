package com.lab4.controllers;

import com.lab4.entities.Point;
import com.lab4.model.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

@RestController
public class pointController {

    @Autowired
    private PointService pointService;

    @GetMapping(value= "/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/points")
    public List<Point> points(){
        return pointService.getAllPoints();
    }

    @PostMapping(value="/point")
    public String publishPoint(@RequestBody Point point){

        pointService.insert(point);
        return "Point was published";
    }


}
