package com.codingzone.model;

public class Stuff extends Person{
    String password;

    public Stuff(String firstname, String lastname, String email) {
        super(firstname, lastname, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "password='" + password + '\'' +
                '}';
    }
}
