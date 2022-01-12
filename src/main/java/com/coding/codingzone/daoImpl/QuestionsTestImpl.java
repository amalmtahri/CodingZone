package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.QuestionsTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QuestionsTestImpl extends DAO<QuestionsTest> {
    Connection connection = null;

    @Override
    public List<QuestionsTest> all() {
        return null;
    }

    @Override
    public QuestionsTest find(String id) {
        return null;
    }

    @Override
    public QuestionsTest create(QuestionsTest obj) {
        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_QUESTIONS_TEST);
            st.setString(1, obj.getId_test());
            st.setString(2, obj.getId_question());
            System.out.println(st);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public QuestionsTest update(QuestionsTest obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
