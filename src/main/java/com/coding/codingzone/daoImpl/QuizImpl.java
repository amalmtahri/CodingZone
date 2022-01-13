package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.demo.SendMail;
import com.coding.codingzone.model.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QuizImpl extends DAO<Quiz> {
    Connection connection = null;

    @Override
    public List<Quiz> all() {
        return null;
    }

    @Override
    public Quiz find(String id) {
        return null;
    }

    @Override
    public Quiz create(Quiz obj) {
        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_QUIZ);
            st.setString(1, obj.getId());
            st.setInt(2, obj.getCode());
            st.setString(3, obj.getId_test());
            st.setString(4, obj.getId_candidat());
            st.setString(5, obj.getId_stuff());
            st.executeUpdate();
            System.out.println("quiz ajouter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Quiz update(Quiz obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
