package com.coding.codingzone.model;

import java.util.Date;
import java.util.UUID;

public class Test {
    private String id;
    private String name;
    private Date creationDate;

    public Test(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Test(String id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
