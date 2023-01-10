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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class SalesController implements Initializable {



    @FXML
    private TextField textIdSale;

    @FXML
    private TextField textNameSale;

    @FXML
    private TextField textUnites;

    @FXML
    private TextField textTotal;

    @FXML
    private TextField textDate;

    private Stage stage;
    private Scene scene;
    private Parent root;






    @FXML
    private TableView<Sales> tableSales;

    @FXML
    private TableColumn<Sales, Integer> colIdSale;

    @FXML
    private TableColumn<Sales, String> colNameSale;
    @FXML
    private TableColumn<Sales, Integer> colUnites;

    @FXML
    private TableColumn<Sales, Integer> colTotal;

    @FXML
    private TableColumn<Sales, String> colDate;

    private boolean notEmpty = false;





    @FXML
    public void addSalesPerformed(ActionEvent actionEvent) {
        SalesDaoImpl.addSales(textNameSale.getText(), Integer.parseInt(textUnites.getText()), Integer.parseInt(textTotal.getText()), textDate.getText());
        showSales();
        clearFields();
        notEmpty = true;
    }

    @FXML
    public void updateSalesPerformed(ActionEvent actionEvent) {
        if(notEmpty){
            SalesDaoImpl.updateSalesById(Integer.parseInt(textIdSale.getText()), textNameSale.getText(), Integer.parseInt(textUnites.getText()), Integer.parseInt(textTotal.getText()), textDate.getText());
            showSales();
            clearFields();
        }
    }

    @FXML
    public void deleteSalesPerformed(ActionEvent actionEvent) {
        if(notEmpty){
            SalesDaoImpl.deleteSalesById(Integer.parseInt(textIdSale.getText()));
            showSales();
            clearFields();
        }
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
        clearFields();
    }



    public void showSales(){
        ObservableList<Sales> salesList = SalesDaoImpl.getSales();
        tableSales.setItems(salesList);
        colIdSale.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("id"));
        colNameSale.setCellValueFactory(new PropertyValueFactory<Sales, String>("name"));
        colUnites.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("unites"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("total"));
        colDate.setCellValueFactory(new PropertyValueFactory<Sales, String>("date"));
    }


    @FXML
    public void showSalesById(ActionEvent actionEvent){
        ObservableList<Sales> salesList = SalesDaoImpl.getSalesById(Integer.parseInt(textIdSale.getText()));
        tableSales.setItems(salesList);
        colIdSale.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("id"));
        colNameSale.setCellValueFactory(new PropertyValueFactory<Sales, String>("name"));
        colUnites.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("unites"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("total"));
        colDate.setCellValueFactory(new PropertyValueFactory<Sales, String>("date"));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSales();
    }


    public void clearFields(){
        textNameSale.setText(null);
        textUnites.setText(null);
        textTotal.setText(null);
        textDate.setText(null);


    }
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
    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PHARMMA.fxml"));
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
}

