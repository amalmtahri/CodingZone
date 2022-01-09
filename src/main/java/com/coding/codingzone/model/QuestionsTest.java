package com.coding.codingzone.model;

public class QuestionsTest {
    private Test id_test;
    private Question id_question;

    public QuestionsTest(Test id_test, Question id_question) {
        this.id_test = id_test;
        this.id_question = id_question;
    }

    public Test getId_test() {
        return id_test;
    }

    public void setId_test(Test id_test) {
        this.id_test = id_test;
    }

    public Question getId_question() {
        return id_question;
    }

    public void setId_question(Question id_question) {
        this.id_question = id_question;
    }

    @Override
    public String toString() {
        return "QuestionsTest{" +
                "id_test=" + id_test +
                ", id_question=" + id_question +
                '}';
    }
}
