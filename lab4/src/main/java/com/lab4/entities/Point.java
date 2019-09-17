package com.lab4.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="point")
public class Point implements Serializable {
    public Point(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double valueX;
    private double valueY;
    private double valueR;
    private boolean isHit;

    @ManyToOne
    private User user;

    public void setValueX(double valueX) {
        this.valueX = valueX;
    }

    public void setValueY(double valueY) {
        this.valueY = valueY;
    }

    public void setValueR(double valueR) {
        this.valueR = valueR;
    }

    public void setIsHit(boolean isHit){ this.isHit = isHit;}

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public double getValueX() {
        return valueX;
    }

    public double getValueY() {
        return valueY;
    }

    public double getValueR() {
        return valueR;
    }

    public boolean getIsHit(){
        return isHit;
    }

    public User getUser() {
        return user;
    }

}
