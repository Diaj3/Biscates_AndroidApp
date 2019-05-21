package com.example.biscates.models;

import java.net.URL;
import java.util.ArrayList;

public class User {
    private URL photo;
    private String name;
    private Double classification;
    private String description;
    private ArrayList<Biscates> biscates;

    public User(URL photo, String name, Double classification, String description, ArrayList<Biscates> biscates) {
        this.photo = photo;
        this.name = name;
        this.classification = classification;
        this.description = description;
        this.biscates = biscates;
    }

    public URL getPhoto() {
        return photo;
    }

    public void setPhoto(URL photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getClassification() {
        return classification;
    }

    public void setClassification(Double classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Biscates> getBiscates() {
        return biscates;
    }

    public void setBiscates(ArrayList<Biscates> biscates) {
        this.biscates = biscates;
    }

    public void removeBiscate(Biscates biscate){
        biscates.remove(biscate);
    }

    public void addBiscate(Biscates biscate){
        biscates.add(biscate);
    }
}
