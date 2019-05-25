package com.example.biscates.models;

import java.util.ArrayList;

public class Biscates {
    private int mImageResource;
    private String name;
    private String location;
    private Double price;
    private String description;
    private String cellphone;
    private String categoria;

    public Biscates(int mImageResource, String name, String location, Double price, String description, String cellphone, String categoria) {
        this.mImageResource = mImageResource;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.cellphone = cellphone;
        this.categoria = categoria;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getCategoria() {
        return categoria;
    }
}