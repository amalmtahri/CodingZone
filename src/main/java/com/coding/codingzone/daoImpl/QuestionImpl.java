package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionImpl extends DAO<Question> {
    Connection connection = null;

    @Override
    public List<Question> all() {
        List<Question> data = new ArrayList<>();
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.SELECT_QUESTION);
            ResultSet rs = st.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                data.add(new Question(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),new Category(rs.getString(9),rs.getString(11),rs.getString(12)),rs.getInt(8)));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Question find(String id) {
        Question question = null;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.GETONE_QUESTION);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                question = new Question(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),new Category(rs.getString(9),rs.getString(11),rs.getString(12)),rs.getInt(8));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }
    @Override
    public Question create(Question q) {

        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_QUESTION);
            st.setString(1, q.getId());
            st.setString(2, q.getQuestion());
            st.setString(3, q.getResponse());
            st.setString(4, q.getChoice1());
            st.setString(5, q.getChoice2());
            st.setString(6, q.getChoice3());
            st.setInt(7, q.getTimeLimit());
            st.setString(8, q.getId_category().getId());
            st.setInt(9, q.getScore());
            System.out.println(st);
            st.executeUpdate();
            System.out.println("question ajouter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Question update(Question q) {
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.UPDATE_QUESTION);
            st.setString(1, q.getQuestion());
            st.setString(2, q.getResponse());
            st.setString(3, q.getChoice1());
            st.setString(4, q.getChoice2());
            st.setString(5, q.getChoice3());
            st.setInt(6, q.getTimeLimit());
            st.setString(7, q.getId_category().getId());
            st.setInt(8, q.getScore());
            st.setString(9, q.getId());
            st.executeUpdate();
            System.out.println("question updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {

        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.DELETE_QUESTION);
            st.setString(1,id);
            System.out.println(st);
            st.executeUpdate();
            System.out.println("deleted");
        }catch(SQLException e){
        }
    }
}
