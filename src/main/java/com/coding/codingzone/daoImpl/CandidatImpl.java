package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.dao.QueryDAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Candidat;
import com.coding.codingzone.model.Person;
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
        Candidat candidat = null;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.FIND_CANDIDAT);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                candidat = new Candidat(rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return candidat;
    }



    @Override
    public Candidat create(Candidat c) {
        return c;
    }

    @Override
    public Candidat update(Candidat obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public Candidat addCandidat(Candidat c, Person p){
        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.INSERT_PERSON);
            st.setString(1, p.getId());
            st.setString(2, p.getFirstname());
            st.setString(3, p.getLastname());
            st.setString(4, p.getEmail());
            st.executeUpdate();
            PreparedStatement state =  connection.prepareStatement(QueryDAO.INSERT_CANDIDAT);
            state.setString(1, c.getId_candidat());
            state.setString(2, p.getId());
            state.executeUpdate();
            System.out.println("Candidat bien ajouter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }



    public Candidat updateCandidat(Person obj) {
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.UPDATE_CANDIDAT);
            st.setString(1, obj.getFirstname());
            st.setString(2, obj.getLastname());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getId());
            st.executeUpdate();
            System.out.println("candidat updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCandidat(String id_candidat, String id_person) {

        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.DELETE_CANDIDAT);
            PreparedStatement statement =  connection.prepareStatement(QueryDAO.DELETE_PERSON);
            st.setString(1,id_candidat);
            statement.setString(1,id_person);
            System.out.println(st);
            st.executeUpdate();
            statement.executeUpdate();
            System.out.println("deleted");
        }catch(SQLException e){
        }
    }

    public int countCandidats(){
        int countC = 0;
        try{
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st =  connection.prepareStatement(QueryDAO.COUNT_CANDIDATS);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                countC = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  countC;
    }

}
