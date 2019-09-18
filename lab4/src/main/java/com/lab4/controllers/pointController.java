package com.lab4.controllers;

import com.lab4.entities.Point;
import com.lab4.model.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

@RestController
@RequestMapping(value="/point")
public class pointController {
    @Autowired
    private PointService pointService;

    @GetMapping(value = "/get")
    public List<Point> points(){
        return pointService.getAllPoints();
    }

    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    public void publishPoint(@RequestBody Point point){
        pointService.insert(point);
    }

    @PostMapping(path="/", consumes = "application/json", produces = "application/json")
    public boolean checkPoint(@RequestBody Point point){
        double x=point.getValueX();
        double y=point.getValueY();
        double r=point.getValueR();
        boolean isHit = false;
        if (x>=0 && y>=0){ if (x*x + y*y <= r*r) isHit = true; }
        else if (x>=0 && y<0){ if (2*x <= (r+y)) isHit = true; }
        else if (x<0 & y>0) { if (x>=r && y>=r/2) isHit= true; }
        point.setIsHit(isHit);
        publishPoint(point);
        return true;
    }
}
