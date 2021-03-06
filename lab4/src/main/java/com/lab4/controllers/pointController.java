package com.lab4.controllers;

import com.lab4.entities.Point;
import com.lab4.entities.User;
import com.lab4.entities.pointRes;
import com.lab4.model.PointService;
import com.lab4.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost/8081")
@RequestMapping(value="/point")
public class pointController {
    @Autowired
    private PointService pointService;

    @Autowired
    private UserService userService;

    //private Principal principal;
   // @GetMapping(value = "/get")
    public List<Point> points(){
        return pointService.getAllPoints();
    }

    //@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping
    public Point publishPoint(@RequestBody Point point,Principal principal) throws NullPointerException{// fix me
        System.out.println(point.getValueX());
        System.out.println(point.getValueY());
        System.out.println(point.getValueR());

       // this.principal = principal;
       // if (!checkPoint(point)) return null;
        point.setIsHit(_isHit(point));
        //System.out.println(principal.getName());
        User user = getUser(principal.getName());
        //get list point of this user
        //List<Point> addListPoints = user.getResultHistory();
        //addListPoints.add(point);
        //user.setResultHistory(addListPoints);

        //userService.insert(user);
        //point.setUser(user);
        point.setUsername(user.getUsername());
        pointService.insert(point);
        //return this.getData(principal);
        return point;
    }

    private boolean checkPoint(Point point){
        double[] area = {-5,-4,-3,-2,-1,0,1,2,3};
        boolean okX = false;
        boolean okR = false;
        for(int i=0;i<area.length;i++) {
            if (area[i] == point.getValueX()) okX = true;
            if (area[i] == point.getValueR()) okR = true;
        }
        return (point.getValueY()>=-3 && point.getValueY()<=5 &&okX && okR );
    }

    private boolean _isHit(Point point){
        double x=point.getValueX();
        double y=point.getValueY();
        double r=point.getValueR();
        boolean isHit = false;
        if (x>=0 && y>=0){ if (x*x + y*y <= r*r) isHit = true; }
        else if (x>=0 && y<0){ if (2*x <= (r+y)) isHit = true; }
        else if (x<0 && y<0) { if (x>=-r && y>=-r/2) isHit= true; }
        return isHit;
    }

    private User getUser(String username){
        try {
            User _user = userService.getUser(username);
            return _user;
        }
        catch (Exception e) {
            System.out.println("User " + username + " doesn't exist");
        }
        return null;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Point> getData(Principal principal){
        User user = getUser(principal.getName());
        //List<Point> points = pointService.findAllByUser(user);
        List<Point> points = pointService.findByUsername(user.getUsername());
        ArrayList<Point> data = new ArrayList<>();
        for (Point tmp: points) {
            data.add(tmp);
        }
        return data;
    }

    @GetMapping("/update/{r}")
    public List<pointRes> getAllUpdated(@PathVariable double r, Principal principal){
        User user = getUser(principal.getName());
        List<Point> reqResult = pointService.findByUsername(user.getUsername());
        List<pointRes> points = new ArrayList<>();
        reqResult.forEach(it-> {
            if (it.getValueR()==r) points.add(new pointRes(it.getValueX(), it.getValueY(), it.getIsHit()));

        });
        return points;
    }
}

