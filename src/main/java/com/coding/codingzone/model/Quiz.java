package com.coding.codingzone.model;

import java.util.Date;
import java.util.UUID;


public class Quiz {
    private String id;
    private int code;
    private String id_test;
    private String id_candidat;
    private String id_stuff;
    private Date creationDate;

    public Quiz( String id_test, String id_candidat, String id_stuff) {
        this.id = UUID.randomUUID().toString();
        this.code = (int) (System.currentTimeMillis() & 0xfffffff);
        this.id_test = id_test;
        this.id_candidat = id_candidat;
        this.id_stuff = id_stuff;
    }

    public Quiz(String id, int code, String id_test, String id_candidat, String id_stuff) {
        this.id = id;
        this.code = code;
        this.id_test = id_test;
        this.id_candidat = id_candidat;
        this.id_stuff = id_stuff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId_test() {
        return id_test;
    }

    public void setId_test(String id_test) {
        this.id_test = id_test;
    }

    public String getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(String id_candidat) {
        this.id_candidat = id_candidat;
    }

    public String getId_stuff() {
        return id_stuff;
    }

    public void setId_stuff(String id_stuff) {
        this.id_stuff = id_stuff;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
