package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestImpl extends DAO<Test> {
    Connection connection = null;
    @Override
    public List<Test> all() {
        List<Test> data = new ArrayList<>();
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.SELECT_TEST);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new Test(rs.getString(1),rs.getString(2),rs.getDate(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Test find(String id) {
        return null;
    }

    @Override
    public Test create(Test obj) {
        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_TEST);
            st.setString(1, obj.getId());
            st.setString(2, obj.getName());
            System.out.println(st);
            st.executeUpdate();
            System.out.println("test ajouter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Test update(Test obj) {
        return null;
    }

    @Override
    public void delete(String id) {
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.DELETE_TEST);
            st.setString(1,id);
            System.out.println(st);
            st.executeUpdate();
            System.out.println("deleted");
        }catch(SQLException e){
        }
    }


    public int testPassedPerDay(){
        int days = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.TEST_PASSED_PER_DAY);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                days = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  days;
    }

    public int testPassedPerMonth(){
        int months = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.TEST_PASSED_PER_MONTH);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                months = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  months;
    }

    public int testPassedPerYear(){
        int years = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.TEST_PASSED_PER_YEAR);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                years = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  years;
    }
    public int countTests(){
        int countT = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.COUNT_TESTS);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                countT = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  countT;
    }

}
