package com.lab4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="user_entity")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private Role role;
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)// read me
    private List<Point> resultHistory ;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
        //this.setRole();
        //this.enabled = true;
        resultHistory = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole(){ return role;}

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(){this.role = Role.USER;}

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setResultHistory(List<Point> resultHistory) {
        this.resultHistory = resultHistory;
    }

    public List<Point> getResultHistory() throws NullPointerException {
        if (resultHistory==null) resultHistory = new ArrayList<>() ;
        return resultHistory;
    }
}
