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
            while (rs.next()) {
                data.add(new Question(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Question find(int id) {
        return null;
    }

    @Override
    public Question create(Question obj) {
        return null;
    }

    @Override
    public Question update(Question obj) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
