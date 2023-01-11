package com.example.pharmma;

import java.sql.*;


public class PageLogin extends javax.swing.JFrame{
    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    static String jobAccount;


    public static boolean login(String username, String password){

        String query = " select username, password from account where username='" + username + "' and password='" + password + "'";

        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            //jobAccount = resultSet.getString("job");
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}