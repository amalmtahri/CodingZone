package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Candidat;
import com.coding.codingzone.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatImpl extends DAO<Candidat> {
    Connection connection = null;

    @Override
    public List<Candidat> all() {
        List<Candidat> data = new ArrayList<>();
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.SELECT_CANDIDAT);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new Candidat(rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public Candidat getDataCandidat(String id_candidat) {
        Candidat data = null;
        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st = connection.prepareStatement(QueryDAO.SELECT_EMAIL_CANDIDAT);
            st.setString(1, id_candidat);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data = new Candidat(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    @Override
    public Candidat find(String id) {
        return null;
    }

    @Override
    public Candidat create(Candidat obj) {
        return null;
    }

    @Override
    public Candidat update(Candidat obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
