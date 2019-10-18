package com.lab4.entities;


public class pointRes{
    public double x;
    public double y;
    public boolean hit;
    public pointRes(double x, double y, boolean hit){
        this.x = x;
        this.y = y;
        this.hit = hit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}