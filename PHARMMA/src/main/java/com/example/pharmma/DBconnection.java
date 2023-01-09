package com.example.pharmma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/clientDB";
    static String username = "root";
    static String password = "Polaris001";
     static Connection con;



    public static Connection createDBconnection() {
          con = null;
        try {
            // load driver

            // get connection

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return con;
    }
}