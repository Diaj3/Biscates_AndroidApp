package com.example.biscates.models;

import java.net.URL;
import java.util.ArrayList;

public class User {
    private String name;
    private String location;

    public User(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
