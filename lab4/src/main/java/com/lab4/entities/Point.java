package com.lab4.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="point")
public class Point implements Serializable {
    public Point(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @NotNull
    double valueX;
    @NotNull
    double valueY;

    @NotNull
    double valueR;
    @NotNull
    boolean isHit;

    @NotNull
    String username;

    public Point(double x,double y, double r, boolean isHit){
        this.valueX = x;
        this.valueY = y;
        this.valueR = r;
        this.isHit = isHit;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
        return (valueX+ " " + valueY + " " + valueR);
    }
}
