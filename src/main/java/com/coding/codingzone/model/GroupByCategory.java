package com.coding.codingzone.model;

import java.text.DecimalFormat;

public  class GroupByCategory {
    private String name;
    private String image;
    private int nbrQuestions;
    private double minutes;

    public GroupByCategory(String name, String image, int nbrQuestions, double minutes) {
        this.name = name;
        this.image = image;
        this.nbrQuestions = nbrQuestions;
        this.minutes = minutes/60 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNbrQuestions() {
        return nbrQuestions;
    }

    public void setNbrQuestions(int nbrQuestions) {
        this.nbrQuestions = nbrQuestions;
    }

    public double getMinutes() {

        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
}
