package com.coding.codingzone.dao;

public final class QueryDAO {
    public static final String INSERT_CATEGORY = "INSERT INTO categorie( name, image ) VALUES (?, ?)";
    public static final String SELECT_CATEGORY = "SELECT * FROM categorie";
    public static final String DELETE_CATEGORY = "DELETE from categorie where id = ?";
    public static final String GETONE_CATEGORY = "select * from categorie where id = ?";
    public static final String UPDATE_CATEGORY = "update  categorie set name = ?, image = ? ";
}
