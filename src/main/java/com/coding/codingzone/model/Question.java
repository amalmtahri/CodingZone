package com.coding.codingzone.model;

import java.io.Serializable;
import java.util.UUID;

public class Question implements Serializable {
    private String id;
    private String question;
    private String response;
    private String choice1;
    private String choice2;
    private String choice3;
    private int timeLimit;
    private Category id_category;
    private int score;

    public Question( String question, String response, String choice1, String choice2, String choice3, int timeLimit, Category id_category, int score) {
        this.id = UUID.randomUUID().toString();
        this.question = question;
        this.response = response;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.timeLimit = timeLimit;
        this.id_category = id_category;
        this.score = score;
    }

    public Question(String id, String question, String response, String choice1, String choice2, String choice3, int timeLimit, Category id_category, int score) {
        this.id = id;
        this.question = question;
        this.response = response;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.timeLimit = timeLimit;
        this.id_category = id_category;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Category getId_category() {
        return id_category;
    }

    public void setId_category(Category id_category) {
        this.id_category = id_category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", reponse='" + response + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", timeLimit=" + timeLimit +
                ", id_category=" + id_category +
                ", score=" + score +
                '}';
    }
}
