package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoryImpl extends DAO<Category> {

    Connection connection = null;
    @Override
    public Category find(String id) {
        Category category = null;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.GETONE_CATEGORY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category = new Category(rs.getString(1),rs.getString(2),rs.getString(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }


    @Override
    public List<Category> all() {
        List<Category> data = new ArrayList<>();
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.SELECT_CATEGORY);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               data.add(new Category(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Category create(Category c) {

        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_CATEGORY);
            st.setString(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getImage());
            System.out.println(st);
            st.executeUpdate();
            System.out.println("category ajouter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category update(Category c) {
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.UPDATE_CATEGORY);
            st.setString(1, c.getName());
            st.setString(2, c.getImage());
            st.setString(3, c.getId());
            st.executeUpdate();
            System.out.println("category updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int countCategories(){
        int countC = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.COUNT_CATEGORY);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                countC = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  countC;
    }


    @Override
    public void delete(String id) {

        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.DELETE_CATEGORY);
            st.setString(1,id);
            System.out.println(st);
            st.executeUpdate();
            System.out.println("deleted");
        }catch(SQLException e){
        }
    }
}
