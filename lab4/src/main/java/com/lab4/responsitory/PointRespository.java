package com.lab4.responsitory;

import com.lab4.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRespository extends JpaRepository<Point,Long> {
    List<Point> findAllById(Long id);
}
