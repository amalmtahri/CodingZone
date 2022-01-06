package com.codingzone.model;


import java.util.Date;

public class ResultQuiz {
    Integer score;
    Date date;
    Quiz id_quiz;

    public ResultQuiz(Integer score, Date date) {
        this.score = score;
        this.date = date;
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

    public Quiz getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(Quiz id_quiz) {
        this.id_quiz = id_quiz;
    }

    @Override
    public String toString() {
        return "ResultQuiz{" +
                "score=" + score +
                ", date=" + date +
                ", id_quiz=" + id_quiz +
                '}';
    }
}
