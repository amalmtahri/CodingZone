package com.coding.codingzone.dao;

public final class QueryDAO {
    public static final String INSERT_CATEGORY = "INSERT INTO categorie(id, name, image) VALUES (?, ?, ?)";
    public static final String SELECT_CATEGORY = "SELECT * FROM categorie";
    public static final String DELETE_CATEGORY = "delete from categorie where id = ?";
    public static final String GETONE_CATEGORY = "select * from categorie where id = ?";
    public static final String UPDATE_CATEGORY = "update  categorie set name = ?, image = ? where id = ? ";

    public static final String INSERT_QUESTION = "insert into question(id,question, response, choice1, choice2, choice3, timelimit, categorie_id, score) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_QUESTION = "select q.*, c.id, c.name, c.image from question q, categorie c where q.categorie_id = c.id";
    public static final String DELETE_QUESTION = "delete from question where id = ?";
    public static final String GETONE_QUESTION = "select q.*, c.id, c.name, c.image from question q, categorie c where q.categorie_id = c.id and q.id = ?";
    public static final String UPDATE_QUESTION = "update question set question = ?, response = ?, choice1 = ?, choice2 = ?, choice3 = ?, timelimit = ?, categorie_id = ?, score = ? where id = ?";

    public static final String INSERT_TEST = "insert into test(id, name) values (?, ?)";
    public static final String SELECT_TEST = "select * from test";
    public static final String DELETE_TEST = "delete from test where id = ?";

    public static final String INSERT_QUESTIONS_TEST = "insert into questtest (test_id, question_id) values (?, ?)";

    public static final String INSERT_QUIZ = "insert into quiz(id, code, test_id, candidat_id, staff_id) values(?, ?, ?, ?, ?)";

    public static final String SELECT_CANDIDAT = "select c.*, p.* from candidat c, person p where c.person_id = p.id";

    public static final String SELECT_EMAIL_CANDIDAT = "select c.*, p.* from candidat c, person p where c.person_id = p.id and c.id = ?";
}
