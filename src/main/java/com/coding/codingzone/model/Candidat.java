package com.coding.codingzone.model;

public class Candidat extends Person{
    private String id_candidat;


    public Candidat(String id_candidat, String id, String firstname, String lastname, String email) {
        super(id, firstname, lastname, email);
        this.id_candidat = id_candidat;
    }

    public String getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(String id_candidat) {
        this.id_candidat = id_candidat;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", id_candidat='" + id_candidat + '\'' +
                '}';
    }
}
