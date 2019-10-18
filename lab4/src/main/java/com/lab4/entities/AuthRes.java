package com.lab4.entities;

import java.io.Serializable;

public class AuthRes implements Serializable {
    public boolean success;
    public String message;
    public AuthRes(boolean success, String message){
        this.message = message;
        this.success = success;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
