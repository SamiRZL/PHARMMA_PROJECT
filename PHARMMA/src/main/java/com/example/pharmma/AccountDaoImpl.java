package com.example.pharmma;


import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl extends Account {

    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;




    public static ObservableList<Account> getAccounts(){
        ObservableList<Account> accountTab = FXCollections.observableArrayList();

        String query = "select Id_account, Name, LastName, Job, Username, Password from account";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Id_account");
                String name = resultSet.getString("Name");
                String lastname = resultSet.getString("LastName");
                String job = resultSet.getString("Job");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                Account acc = new Account(id, name, lastname, job, username, password);
                accountTab.add(acc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountTab;
    }

    public static ObservableList<Account> getAccountsById(int id){
        ObservableList<Account> accountSearchedTab = FXCollections.observableArrayList();

        String query = "select * from account where Id_account = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                int idAcc = resultSet.getInt("Id_account");
                String  name = resultSet.getString("Name");
                String lastname = resultSet.getString("LastName");
                String job = resultSet.getString("Job");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                Account accSr = new Account(idAcc, name, lastname, job, username, password);
                accountSearchedTab.add(accSr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountSearchedTab;
    }










    public static void addAccount( String name, String lastname, String job, String username , String password){
        String query = "insert into account(Name, LastName, Job, Username, Password) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement  statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, job);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateAccountById(int id, String name, String lastname, String job, String username, String password){

        String query = "update account set Name = ?, LastName = ?, Job = ?, Username = ?, Password = ?, where Id_account = ?";
        try {
            PreparedStatement  statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, job);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void deleteAccountById(int id){
        String query = "delete from account where Id_account = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}