package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.demo.SendMail;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Question;
import com.coding.codingzone.model.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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


    public List<Question> findTestQuestions(Integer codeQuiz) {
        List<Question> data = new ArrayList<>();
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.SHOW_QUESTIONS);
            st.setInt(1, codeQuiz);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new Question(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),new Category(rs.getString(10),rs.getString(11),rs.getString(12)),rs.getInt(8)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public void checkResponse(Question q , String response ,int code){
        if(q.getResponse().toString().equals(response)){
            try{
                connection = SingletonDB.getInstance().getConnection();
                PreparedStatement st =  connection.prepareStatement("update resultquiz set score = score + ? where quiz_id in (select id from quiz where code = ? )");
                st.setInt(1,q.getScore());
                st.setInt(2,code);
                st.executeUpdate();
                System.out.println("Correct !! ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Incorrect !! ");
        }
    }


}
