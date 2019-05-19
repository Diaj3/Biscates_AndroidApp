package com.example.biscates.models;

public class Biscates {
    private String name;
    private Double price;
    private String description;
    private String location;

    public Biscates() {}

    public Biscates(String name, Double price, String description, String location) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
