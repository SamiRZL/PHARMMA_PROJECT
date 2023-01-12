package com.example.pharmma;

import java.sql.*;


public class PageLogin extends javax.swing.JFrame{
    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;






    public static boolean login(String username, String password){

        String query = " select Username, Password from account where Username='" + username + "' and Password='" + password + "'";

        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);

            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getJob1(String username){

        String query = " select Job from account where Username='" + username + "'";
        String job;
        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            job = rs.getString("Job");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }




}