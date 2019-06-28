package com.lab4.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String role = "ROLE_USER";

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }
}
