package com.coding.codingzone.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDB {

    private static String url = "jdbc:postgresql://localhost:5432/codingZone";
    private static String user = "postgres";
    private static String passwd = "amal";
    private static Connection connect;

    private static SingletonDB instance;

    //private constructor
    private  SingletonDB(){
    }

    public static SingletonDB getInstance(){
        if(instance==null){
            instance= new SingletonDB();
        }
        return instance;
    }

    public static Connection getConnection(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
                System.out.println("connected");
            } catch (SQLException e) {
                System.out.println("Connection to database has a problem " + e.getMessage());
            }
        }
        return connect;
    }
}
