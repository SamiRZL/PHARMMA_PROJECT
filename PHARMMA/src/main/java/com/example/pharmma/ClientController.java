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
public class ClientController implements Initializable {



    @FXML
    private TextField textId;

    @FXML
    private TextField textName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textAge;

    @FXML
    private TextField textPhoneNbr;


    // zid les bouttons lahna idha tess7a9
    //.
    //.
    //.
    //.




    @FXML
    private TableView<Client> tableClients;
    @FXML
    private Button btnSave;

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

    private int tester = 0;





    @FXML
    public void addClientPerformed(ActionEvent actionEvent) {
        ClientDaoImpl.addClient(textName.getText(), textLastName.getText(), Integer.parseInt(textAge.getText()), Integer.parseInt(textPhoneNbr.getText()));
        showClients();
        clearFields();
        tester++;
    }

    @FXML
    public void updateClientPerformed(ActionEvent actionEvent) {
        if(tester != 0){
            ClientDaoImpl.updateClientById(Integer.parseInt(textId.getText()), textName.getText(), textLastName.getText(), Integer.parseInt(textAge.getText()), Integer.parseInt(textPhoneNbr.getText()));
            showClients();
            clearFields();
        }
    }

    @FXML
    public void deleteClientPerformed(ActionEvent actionEvent) {
        if(tester != 0){
            ClientDaoImpl.deleteClientById(Integer.parseInt(textId.getText()));
            showClients();
            clearFields();
            tester --;
        }
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
        clearFields();
    }




    public void showClients(){
        ObservableList<Client> clientsList = ClientDaoImpl.getClients();
        tableClients.setItems(clientsList);
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Id_client"));
        colName.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("LastName"));
        colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Age"));
        colPhoneNbr.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Phone_nbr"));
    }


    @FXML
    public void showClientsById(ActionEvent actionEvent){
        ObservableList<Client> clientsList = ClientDaoImpl.getClientsById(Integer.parseInt(textId.getText()));
        tableClients.setItems(clientsList);
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Id_client"));
        colName.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("LastName"));
        colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Age"));
        colPhoneNbr.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Phone_nbr"));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showClients();
    }


    public void clearFields(){
        textName.setText(null);
        textLastName.setText(null);
        textAge.setText(null);
        textPhoneNbr.setText(null);
        btnSave.setDisable(true);

    }
}
