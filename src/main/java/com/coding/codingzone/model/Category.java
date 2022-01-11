package com.coding.codingzone.model;

import java.util.UUID;

public class Category {
    private String id;
    private String name;
    private String image;

    public Category(String name, String image) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.image = image;
    }
    public Category(String id ,String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
