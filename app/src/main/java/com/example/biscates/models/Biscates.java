package com.example.biscates.models;

import java.util.ArrayList;

public class Biscates {
    private static int id = 0;
    private String name;
    private Double price;
    private String description;
    private String location;
    private String categoria;
    private String cellphone;

    public Biscates(String name, Double price, String description, String location, String categoria, String cellphone) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.location = location;
        this.categoria = categoria;
        this.cellphone = cellphone;
        id++;
    }

    public static int getId() {
        return id;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}