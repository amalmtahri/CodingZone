package com.coding.codingzone.model;

public class Staff extends Person{


    private String password;

    public Staff(String id,String firstname, String lastname, String email, String password) {
        super(id,firstname, lastname, email);
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
                "firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ",password='" + password + '\'' +
                '}';
    }
}
