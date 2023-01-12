package com.example.pharmma;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ClientController implements Initializable {



    @FXML
    private TextField textIdCltDelete;


    @FXML
    private TextField textIdCltSearch;

    @FXML
    private TextField textIdCltUp;



    @FXML
    private TextField textName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textAge;

    @FXML
    private TextField textPhoneNbr;

    @FXML
    private TableView<Client> tableClients;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;


    @FXML
    private TableColumn<Client, Integer> colId;

    @FXML
    private TableColumn<Client, String> colName;
    @FXML
    private TableColumn<Client, String> colLastName;

    @FXML
    private TableColumn<Client, Integer> colAge;

    @FXML
    private TableColumn<Client, Integer> colPhoneNbr;

    @FXML
    private  Label totalClts;



    private int tester = 0;

    private Stage stage;
    private Scene scene;
    private Parent root;




    public void tester(){
        if (tester == 0){
            btnDelete.setDisable(true);
            btnUpdate.setDisable(true);

        }
    }

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DASHBOARD.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PHARMMA.fxml"));
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
    public void addClientPerformed(ActionEvent actionEvent) {
        ClientDaoImpl.addClient(textName.getText(), textLastName.getText(), Integer.parseInt(textAge.getText()), Integer.parseInt(textPhoneNbr.getText()));
        showClients();
        clearFields();
        fillLabelClt();
    }

    @FXML
    public void updateClientPerformed(ActionEvent actionEvent) {
            ClientDaoImpl.updateClientById(Integer.parseInt(textIdCltUp.getText()), textName.getText(), textLastName.getText(), Integer.parseInt(textAge.getText()), Integer.parseInt(textPhoneNbr.getText()));
            showClients();
            clearFields();

    }

    @FXML
    public void deleteClientPerformed(ActionEvent actionEvent) {
            ClientDaoImpl.deleteClientById(Integer.parseInt(textIdCltDelete.getText()));
            showClients();
            clearFields();
            fillLabelClt();
           tester --;

    }





    public void showClients(){
        ObservableList<Client> clientsList = ClientDaoImpl.getClients();
        tableClients.setItems(clientsList);
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastname"));
        colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));
        colPhoneNbr.setCellValueFactory(new PropertyValueFactory<Client, Integer>("phoneNbr"));
    }


    @FXML
    public void showClientsById(ActionEvent actionEvent){
        ObservableList<Client> clientsList = ClientDaoImpl.getClientsById(Integer.parseInt(textIdCltSearch.getText()));
        tableClients.setItems(clientsList);
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastname"));
        colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));
        colPhoneNbr.setCellValueFactory(new PropertyValueFactory<Client, Integer>("phoneNbr"));
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {
        showClients();
        fillLabelClt();
    }

    public  void fillLabelClt(){
        totalClts.setText(String.valueOf(ClientDaoImpl.nbrOfClients()));

    }


    public void clearFields(){
        textName.setText(null);
        textLastName.setText(null);
        textAge.setText(null);
        textPhoneNbr.setText(null);

    }
}
