package com.example.pharmma;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Account {

    private int id;
    private String name;
    private String lastname;
    private String job;
    private String username;
    private String password;



    public Account(int id, String name, String lastname, String job, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.job = job;
        this.username = username;
        this.password = password;
    }

    public Account(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}