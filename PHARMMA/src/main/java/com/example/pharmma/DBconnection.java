package com.example.pharmma;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    static Connection con;

    public static Connection createDBconnection() {
        try {
            // load driver
            Class.forName("com.mysql.jdbc.driver");
            // get connection
            String url = "jdbc:mysql://localhost:3306/clientDB";
            String username = "root";
            String password = "toor";
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}