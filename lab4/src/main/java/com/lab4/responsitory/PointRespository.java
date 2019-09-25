package com.lab4.responsitory;

import com.lab4.entities.Point;
import com.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PointRespository extends JpaRepository<Point,Long> {
    ArrayList<Point> findAllById(Long id);
    List<Point> findAllByUser(User user);
}
