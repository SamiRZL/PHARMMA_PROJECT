package com.example.pharmma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends Product{

    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;





    public static ObservableList<Product> getProducts(){
        ObservableList<Product> productTab = FXCollections.observableArrayList();

        String query = "select * from product";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Id_product");
                String name = resultSet.getString("Product_name");
                int qty = resultSet.getInt("Quantity");
                int price = resultSet.getInt("Price");
                String expDate = resultSet.getString("Exp_date");

                Product prd = new Product(id, name, qty, price, expDate);
                productTab.add(prd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productTab;
    }


    public static ObservableList<Product> getProductsById(int id){
        ObservableList<Product> productSearchedTab = FXCollections.observableArrayList();

        String query = "select * from product where Id_product = ?";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("Id_product");
                String name = resultSet.getString("Product_name");
                int qty = resultSet.getInt("Quantity");
                int price = resultSet.getInt("Price");
                String expDate = resultSet.getString("Exp_date");

                Product prdSr = new Product(idProduct, name, qty, price, expDate);
                productSearchedTab.add(prdSr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productSearchedTab;
    }



    public static void addProduct( String name, int qty, int price, String expDate){
        String query = "insert into product(Product_name, Quantity, Price, Exp_date) values(?, ?, ?, ?)";
        try {
            PreparedStatement  statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, qty);
            statement.setInt(3, price);
            statement.setString(4, expDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateProductById(int id, String name, int qty, int price, String expDate){

        String query = "update product set Product_name = ?, Quantity = ?, Price = ?, Exp_date = ?, where Id_product = ?";
        try {
            PreparedStatement  statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, qty);
            statement.setInt(3, price);
            statement.setString(4, expDate);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteProductById(int id){
        String query = "delete from product where Id_product = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void showProductById(int id) {
        String query = "select * from product where Id_product = ?";
        try{
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
