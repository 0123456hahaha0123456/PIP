package com.lab4.model;

import com.lab4.entities.Point;
import com.lab4.entities.User;
import com.lab4.responsitory.PointRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRespository pointRespository;

    public List<Point> getAllPoints(){
        return pointRespository.findAll();
    }

  //  public List<Point> findAllByUser(User user){
        //return pointRespository.findAllByUser(user);
    //}

    public List<Point> findByUsername(String username) {
        return pointRespository.findAllByUsernameOrderById(username);
    }
    public void insert(Point point){
        pointRespository.save(point);
    }
}
