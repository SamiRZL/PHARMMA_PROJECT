package com.example.pharmma;

import javafx.fxml.Initializable;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
public class AccountController implements Initializable {



    @FXML
    private TextField textIdAcc;

    @FXML
    private TextField textNameAcc;

    @FXML
    private TextField textLastNameAcc;

    @FXML
    private TextField textJob;

    @FXML
    private TextField textUsername;

    @FXML
    private TextField textPassword;


    // zid les bouttons lahna idha tess7a9
    //.
    //.
    //.
    //.




    @FXML
    private TableView<Account> tableAccounts;


    @FXML
    private TableColumn<Account, Integer> colId;

    @FXML
    private TableColumn<Account, String> colNameAcc;
    @FXML
    private TableColumn<Account, String> colLastNameAcc;

    @FXML
    private TableColumn<Account, String> colJob;

    @FXML
    private TableColumn<Account, String> colUsername;

    @FXML
    private TableColumn<Account, String> colPassword;

    private boolean notEmpty = false;





    @FXML
    public void addAccountPerformed(ActionEvent actionEvent) {
        AccountDaoImpl.addAccount(textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
        showAccounts();
        clearFields();
        notEmpty = true;
    }

    @FXML
    public void updateAccountPerformed(ActionEvent actionEvent) {
        if(notEmpty){
            AccountDaoImpl.updateAccountById(Integer.parseInt(textIdAcc.getText()),textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
            showAccounts();
            clearFields();
        }
    }

    @FXML
    public void deleteClientPerformed(ActionEvent actionEvent) {
        if(notEmpty){
            AccountDaoImpl.deleteAccountById(Integer.parseInt(textIdAcc.getText()));
            showAccounts();
            clearFields();
        }
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
        clearFields();
    }




    public void showAccounts(){
        ObservableList<Account> accountsList = AccountDaoImpl.getAccounts();
        tableAccounts.setItems(accountsList);
        colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Id_account"));
        colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("Name"));
        colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("LastName"));
        colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("Job"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("Username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("Password"));
    }

    @FXML
    public void showAccountsById(ActionEvent actionEvent){
        ObservableList<Account> accountsList = AccountDaoImpl.getAccountsById(Integer.parseInt(textIdAcc.getText()));
        tableAccounts.setItems(accountsList);
        colId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Id_account"));
        colNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("Name"));
        colLastNameAcc.setCellValueFactory(new PropertyValueFactory<Account, String>("LastName"));
        colJob.setCellValueFactory(new PropertyValueFactory<Account, String>("Job"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Account, String>("Username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Account, String>("Password"));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAccounts();
    }


    public void clearFields(){
        textNameAcc.setText(null);
        textLastNameAcc .setText(null);
        textJob.setText(null);
        textUsername.setText(null);
        textPassword.setText(null);


    }
}

