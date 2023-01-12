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
import java.sql.SQLException;
import java.util.ResourceBundle;
public class SalesController implements Initializable {



    @FXML
    private  TextField textIdSaleDelete;


    @FXML
    private  TextField textIdSaleSearch;

    @FXML
    private   Label totalGainsLabel;






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

    private int tester = 0;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;









    @FXML
    public void addSalesPerformed(ActionEvent actionEvent) throws SQLException {
        SalesDaoImpl.addSales(textNameSale.getText(), Integer.parseInt(textUnites.getText()), Integer.parseInt(textTotal.getText()), textDate.getText());
        showSales();
        clearFields();
        fillTotalSales();
        tester++;
    }



    @FXML
    public void deleteSalesPerformed(ActionEvent actionEvent) throws SQLException {
            SalesDaoImpl.deleteSalesById(Integer.parseInt(textIdSaleDelete.getText()));
            textIdSaleDelete.setText(null);
            showSales();

            fillTotalSales();

            tester--;

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
        ObservableList<Sales> salesList = SalesDaoImpl.getSalesByDate(textIdSaleSearch.getText());
        tableSales.setItems(salesList);
        colIdSale.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("id"));
        colNameSale.setCellValueFactory(new PropertyValueFactory<Sales, String>("name"));
        colUnites.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("unites"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("total"));
        colDate.setCellValueFactory(new PropertyValueFactory<Sales, String>("date"));

        textIdSaleSearch.setText(" ");
    }




    public void initialize(URL url, ResourceBundle resourceBundle) {

        showSales();
        try {
            fillTotalSales();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void clearFields(){
        textNameSale.setText(null);
        textUnites.setText(null);
        textTotal.setText(null);
        textDate.setText(null);
    }


    public  void fillTotalSales() throws SQLException {
        totalGainsLabel.setText(String.valueOf(SalesDaoImpl.totalGain()));

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

