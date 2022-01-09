package com.coding.codingzone.model;

import java.util.Date;

public class Test {
    private String name;
    private Date creationDate;
    private QuestionsTest question;

    public Test(String name, Date creationDate, QuestionsTest question) {
        this.name = name;
        this.creationDate = creationDate;
        this.question = question;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public QuestionsTest getQuestion() {
        return question;
    }

    public void setQuestion(QuestionsTest question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", question=" + question +
                '}';
    }
}
