package com.coding.codingzone.model;

public class Staff extends Person{

    private String id_staff;
    private String password;

    public Staff(String id_staff, String id,String firstname, String lastname, String email, String password) {
        super(id,firstname, lastname, email);
        this.id_staff = id_staff;
        this.password = password;
    }


    public String getId_staff() {
        return id_staff;
    }

    public void setId_staff(String id_staff) {
        this.id_staff = id_staff;
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
                "id_staff='" + id_staff + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ",password='" + password + '\'' +
                '}';
    }
}
