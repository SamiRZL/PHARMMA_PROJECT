package com.example.pharmma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl extends Client {

    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;








    public static int nbrOfClients() {
        String query = "select * from client ";


        try {
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
             int cpt = 0;

            while (rs.next()) {
                cpt++;
            }

            return cpt;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ObservableList<Client> getClients() {
        ObservableList<Client> clientTab = FXCollections.observableArrayList();

        String query = "select * from client";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id_client");
                String name = resultSet.getString("Name");
                String lastname = resultSet.getString("LastName");
                int age = resultSet.getInt("Age");
                int phoneNbr = resultSet.getInt("Phone_nbr");

                Client clt = new Client(id, name, lastname, age, phoneNbr);
                clientTab.add(clt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientTab;
    }


    public static ObservableList<Client> getClientsById(int id) {
        ObservableList<Client> clientSearchedTab = FXCollections.observableArrayList();

        String query = "select * from client where Id_client = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idClient = resultSet.getInt("Id_client");
                String name = resultSet.getString("Name");
                String lastname = resultSet.getString("LastName");
                int age = resultSet.getInt("Age");
                int phoneNbr = resultSet.getInt("Phone_nbr");

                Client cltSr = new Client(idClient, name, lastname, age, phoneNbr);
                clientSearchedTab.add(cltSr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientSearchedTab;
    }


    public static void addClient(String name, String lastname, int age, double phoneNbr) {
        String query = "insert into client(Name, LastName, Age, Phone_nbr) values(?, ?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setInt(3, age);
            statement.setDouble(4, phoneNbr);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateClientById(int id, String name, String lastname, int age, double phoneNbr) {

        String query = "update client set Name = ?, LastName = ?, Age = ?, Phone_nbr = ?, where Id_client = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setInt(3, age);
            statement.setDouble(4, phoneNbr);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteClientById(int id) {
        String query = "delete from client where Id_client = ?";
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

