package com.example.pharmma;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class AccountController implements Initializable {






    @FXML
    private  TextField textIdAccDelete;

    @FXML
    private  TextField textIdAccUpdate;

    @FXML
    private  TextField textIdAccSearch;





    @FXML
    private TextField textNameAcc;

    @FXML
    private  TextField textLastNameAcc;

    @FXML
    private  TextField textJob;


    @FXML
    private  TextField textUsername;

    @FXML
    private  TextField textPassword;
    @FXML
    private  TableView<Account> tableAccounts;
    @FXML
    private  TableColumn<Account, Integer> colId;
    @FXML
    private  TableColumn<Account, String> colNameAcc;
    @FXML
    private  TableColumn<Account, String> colLastNameAcc;
    @FXML
    private  TableColumn<Account, String> colJob;
    @FXML
    private  TableColumn<Account, String> colUsername;
    @FXML
    private  TableColumn<Account, String> colPassword;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    private int tester = 0;


    private Stage stage;
    private Scene scene;
    private Parent root;




    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
             root = FXMLLoader.load(getClass().getResource("DASHBOARD.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    public void switchToClients(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFinances(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Finances.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSTOCK(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("STOCK.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    static Connection con = DBconnection.createDBconnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;


    @FXML
    public void addAccountPerformed(ActionEvent actionEvent) throws IOException {

        AccountDaoImpl.addAccount(textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
        clearFields();
        tester++;
        showAccounts();



    }


    public  void clearFields(){
        textNameAcc.setText(null);
        textLastNameAcc .setText(null);
        textJob.setText(null);
        textUsername.setText(null);
        textPassword.setText(null);


    }


   public void tester(){
        if (tester == 0){
           btnDelete.setDisable(true);
           btnUpdate.setDisable(true);
       }
    }









    public void updateFuncClicked(ActionEvent event){
       String query="select Name, LastName, Job, Username, Password from account where Id_account = '"+textIdAccUpdate.getText()+"'";

       try {

           statement = con.prepareStatement(query);
           resultSet = statement.executeQuery(query);
           if(resultSet.next()){
               textNameAcc.setText(resultSet.getString("Name"));
               textLastNameAcc.setText(resultSet.getString("LastName"));
               textJob.setText(resultSet.getString("Job"));
               textUsername.setText(resultSet.getString("Username"));
               textPassword.setText(resultSet.getString("Password"));



           }else{
               textNameAcc.setText("ID NOT FOUND");
               textLastNameAcc.setText("ID NOT FOUND");
               textJob.setText("ID NOT FOUND");
               textUsername.setText("ID NOT FOUND");
               textPassword.setText("ID NOT FOUND");
           }


       } catch (SQLException e) {
           e.printStackTrace();
       }


   }



    @FXML
    public void updateSavedPerformed(ActionEvent actionEvent) {
        AccountDaoImpl.updateAccountById( textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText(), Integer.parseInt(textIdAccUpdate.getText()));
        showAccounts();
        clearFields();
        textIdAccUpdate.setText(null);
    }





    @FXML
    public void deleteAccountPerformed(ActionEvent actionEvent) {
            AccountDaoImpl.deleteAccountById(Integer.parseInt(textIdAccDelete.getText()));
            showAccounts();
            clearFields();
            textIdAccDelete.setText(null);
            tester--;
    }



    public  void showAccounts(){
        ObservableList<Account> accountsList = AccountDaoImpl.getAccounts();
        tableAccounts.setItems(accountsList);
        colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("id"));
        colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("lastname"));
        colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("job"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));

        textIdAccSearch.setText(null);
    }

    @FXML
    public void showAccountsById(ActionEvent actionEvent){
        ObservableList<Account> accountsList = AccountDaoImpl.getAccountsById(Integer.parseInt(textIdAccSearch.getText()));
        tableAccounts.setItems(accountsList);
        colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("id"));
        colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("lastname"));
        colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("job"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));

        textIdAccSearch.setText(null);
    }




    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAccounts();
        //tester();


    }



}

