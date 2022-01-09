package com.coding.codingzone.dao;

public final class QueryDAO {
    public static final String INSERT_CATEGORY = "INSERT INTO categorie( name, image ) VALUES (?, ?)";
    public static final String SELECT_CATEGORY = "SELECT * FROM categorie";
    public static final String DELETE_CATEGORY = "DELETE from categorie where id = ?";
    public static final String GETONE_CATEGORY = "select * from categorie where id = ?";
    public static final String UPDATE_CATEGORY = "update  categorie set name = ?, image = ? ";


    public static final String INSERT_QUESTION = "insert into question(question, response, choice1, choice2, choice3, timelimit, categorie_id, score) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
   public static final String SELECT_QUESTION = "select * from question";
    public static final String DELETE_QUESTION = "delete from question where id = ?";
    public static final String GETONE_QUESTION = "select * from question where id = ?";
    public static final String UPDATE_QUESTION = "update question set question = ?, response = ?, choice1 = ?, choice2 = ?, choice3 = ?, timelimit = ?, categorie_id = ?, score = ?";
}
