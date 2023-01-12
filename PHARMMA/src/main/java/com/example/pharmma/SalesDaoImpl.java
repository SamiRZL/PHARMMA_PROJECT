package com.example.pharmma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDaoImpl extends Sales {

    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;


    public static ObservableList<Sales> getSales() {
        ObservableList<Sales> salesTab = FXCollections.observableArrayList();

        String query = "select * from sales";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id_sales");
                String name = resultSet.getString("Product_name");
                int unites = resultSet.getInt("Unites");
                int total = resultSet.getInt("Total");
                String Date = resultSet.getString("Date");

                Sales sl = new Sales(id, name, unites, total, Date);
                salesTab.add(sl);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salesTab;
    }


    public static ObservableList<Sales> getSalesByDate(String date) {
        ObservableList<Sales> salesSearchedTab = FXCollections.observableArrayList();

        String query = "select * from sales where Date = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setString(1, date);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idSales = resultSet.getInt("Id_sales");
                String name = resultSet.getString("Product_name");
                int unites = resultSet.getInt("Unites");
                int total = resultSet.getInt("Total");
                String Date = resultSet.getString("Date");

                Sales slSr = new Sales(idSales, name, unites, total, Date);
                salesSearchedTab.add(slSr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salesSearchedTab;
    }


    public static void addSales(String name, int unites, int total, String date) {
        String query = "insert into sales(Product_name, Unites, Total, Date) values(?, ?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, unites);
            statement.setInt(3, total);
            statement.setString(4, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateSalesById(int id, String name, int unites, int total, String date) {

        String query = "update product set Product_name = ?, Unites = ?, Total = ?, Date = ?, where Id_sales = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, unites);
            statement.setInt(3, total);
            statement.setString(4, date);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteSalesById(int id) {
        String query = "delete from sales where Id_sales = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int totalGain() throws SQLException {
        String query = "select Total from sales ";


        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            int sum = 0;
           /* if (rs.next()) {
                rs.next();
            }

            */
            while (rs.next()) {
                sum = sum + rs.getInt("Total");
            }
            return sum;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static int totalUnites() {
        String query = "select Unites from sales ";


        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            int sumUnt = 0;

            while (rs.next()) {

                sumUnt = sumUnt + rs.getInt("Unites");

            }

            return sumUnt;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}



