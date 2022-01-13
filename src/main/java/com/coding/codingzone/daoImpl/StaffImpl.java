package com.coding.codingzone.daoImpl;

import com.coding.codingzone.dao.DAO;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StaffImpl extends DAO<Staff> {

    @Override
    public List<Staff> all() {
        return null;
    }

    @Override
    public Staff find(String id) {
        return null;
    }

    @Override
    public Staff create(Staff obj) {
        return null;
    }

    @Override
    public Staff update(Staff obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
    public Staff login(String email,String password){
        Connection connection = null;
        Staff staff = null;

        try {
            connection = SingletonDB.getInstance().getConnection();
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM person p,staff c  where p.email=? and c.password= ? and p.id =c.person_id;");
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                staff = new Staff(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6));
                System.out.println("You have successfully logged in");
            } else {
                System.out.println("Wrong email & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return staff;
    }

}
