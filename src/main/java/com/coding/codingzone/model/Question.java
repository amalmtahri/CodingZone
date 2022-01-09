package com.coding.codingzone.model;

public class Question {
    private String question;
    private String reponse;
    private String choice1;
    private String choice2;
    private String choice3;
    private String timeLimit;
    private Integer score;
    private Category id_category;

    public Question(String question, String reponse, String choice1, String choice2, String choice3, String timeLimit, Integer score, Category id_category) {
        this.question = question;
        this.reponse = reponse;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.timeLimit = timeLimit;
        this.score = score;
        this.id_category = id_category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
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

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Category getId_category() {
        return id_category;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setId_category(Category id_category) {
        this.id_category = id_category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", reponse='" + reponse + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", timeLimit='" + timeLimit + '\'' +
                ", id_category=" + id_category +
                '}';
    }
}
