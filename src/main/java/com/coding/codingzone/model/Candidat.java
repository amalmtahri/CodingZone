package com.coding.codingzone.model;

public class Candidat extends Person{
    private int id_candidat;
    private String code;
    public Candidat(int id,String firstname, String lastname, String email,int id_candidat, String code) {
        super(id,firstname, lastname, email);
        this.id_candidat = id_candidat;
        this.code = code;
    }

    public int getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
