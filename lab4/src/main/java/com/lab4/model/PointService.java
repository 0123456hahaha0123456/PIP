package com.lab4.model;

import com.lab4.entities.Point;
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
    public void insert(Point point){
        pointRespository.save(point);
    }
}
