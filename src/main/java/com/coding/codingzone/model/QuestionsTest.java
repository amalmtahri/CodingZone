package com.coding.codingzone.model;

import java.util.UUID;

public class QuestionsTest {
    private String id_test;
    private String id_question;


    public QuestionsTest(String id_test, String id_question) {
        this.id_test = id_test;
        this.id_question = id_question;
    }

    public String getId_test() {
        return id_test;
    }

    public void setId_test(String id_test) {
        this.id_test = id_test;
    }

    public String getId_question() {
        return id_question;
    }

    public void setId_question(String id_question) {
        this.id_question = id_question;
    }

    @Override
    public String toString() {
        return "QuestionsTest{" +
                ", id_test=" + id_test +
                ", id_question=" + id_question +
                '}';
    }
}
