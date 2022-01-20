package com.coding.codingzone.model;


import java.util.Date;
import java.util.UUID;

public class ResultQuiz {

    private String id;
    private Integer score;
    private Date date;
    private String id_quiz;

    public ResultQuiz() {
        this.id = UUID.randomUUID().toString();
        this.score = 0;
    }

    public ResultQuiz(String id, Integer score, Date date, String id_quiz) {
        this.id = id;
        this.score = score;
        this.date = date;
        this.id_quiz = id_quiz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(String id_quiz) {
        this.id_quiz = id_quiz;
    }
}
