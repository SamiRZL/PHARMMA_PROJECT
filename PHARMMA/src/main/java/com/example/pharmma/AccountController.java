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
import java.util.ResourceBundle;



public class AccountController implements Initializable {





   // @FXML
   // private static TextField textIdAcc;

    @FXML
    private  TextField textNameAcc;

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

    private boolean notEmpty = false;


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
    @FXML
    public void AddButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddClient.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }





    @FXML
    public void addAccountPerformed(ActionEvent actionEvent) {
        AccountDaoImpl.addAccount(textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
        clearFields();
        stage.close();
        showAccounts();


    }

    public  void clearFields(){
        textNameAcc.setText(null);
        textLastNameAcc .setText(null);
        textJob.setText(null);
        textUsername.setText(null);
        textPassword.setText(null);


    }







    //@FXML
    //public void updateAccountPerformed(ActionEvent actionEvent) {
      //  if(notEmpty){
        //    AccountDaoImpl.updateAccountById(Integer.parseInt(textIdAcc.getText()),textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
          //  showAccounts();
            //clearFields();
        //}
    //}

    //@FXML
    //public void deleteClientPerformed(ActionEvent actionEvent) {
      //  if(notEmpty){
        //    AccountDaoImpl.deleteAccountById(Integer.parseInt(textIdAcc.getText()));
          //  showAccounts();
            //clearFields();
        //}
    //}



    public  void showAccounts(){
        ObservableList<Account> accountsList = AccountDaoImpl.getAccounts();
        tableAccounts.setItems(accountsList);
        colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Id_account"));
        colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("Name"));
        colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("LastName"));
        colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("Job"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("Username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("Password"));
    }

    //@FXML
    //public void showAccountsById(ActionEvent actionEvent){
        //ObservableList<Account> accountsList = AccountDaoImpl.getAccountsById(Integer.parseInt(textIdAcc.getText()));
        //tableAccounts.setItems(accountsList);
        //colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Id_account"));
        //colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("Name"));
        //colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("LastName"));
        //colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("Job"));
        //colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("Username"));
        //colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("Password"));
    //}




    public void initialize(URL url, ResourceBundle resourceBundle) {
        //showAccounts();
    }



}

