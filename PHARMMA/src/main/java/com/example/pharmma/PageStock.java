package com.example.pharmma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageStock extends javax.swing.JFrame{

    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    static int units = 0;

    public static int totalUnits() {
        String query = "select Quantity from product ";


        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                units = units + rs.getInt("Quantity");

            }

            return units;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    static int outOfStockCpt = 0;

    public static int outOfStock() {
        String query = "select Quantity from product ";


        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int qty = rs.getInt("Quantity");
                if (qty == 0) {
                    outOfStockCpt++;
                }

            }

            return outOfStockCpt;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}










