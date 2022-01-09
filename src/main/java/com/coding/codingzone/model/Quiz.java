package com.coding.codingzone.model;

import java.util.Date;

public class Quiz {
    private Date creationDate;
    private String code;
    private Test id_test;
    private Candidat id_candidat;

    public Quiz(Date creationDate, String code, Test id_test, Candidat id_candidat) {
        this.creationDate = creationDate;
        this.code = code;
        this.id_test = id_test;
        this.id_candidat = id_candidat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Test getId_test() {
        return id_test;
    }

    public void setId_test(Test id_test) {
        this.id_test = id_test;
    }
    public Candidat getId_candidat() {
        return id_candidat;
    }


    public void setId_candidat(Candidat id_candidat) {
        this.id_candidat = id_candidat;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "creationDate=" + creationDate +
                ", id_test=" + id_test +
                ", id_candidat=" + id_candidat +
                '}';
    }
}
