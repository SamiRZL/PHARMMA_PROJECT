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


    // zid les bouttons lahna idha tess7a9
    //.
    //.
    //.
    //.




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
        colIdSale.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Id_sales"));
        colNameSale.setCellValueFactory(new PropertyValueFactory<Sales, String>("Product_name"));
        colUnites.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Unites"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Total"));
        colDate.setCellValueFactory(new PropertyValueFactory<Sales, String>("Date"));
    }


    @FXML
    public void showSalesById(ActionEvent actionEvent){
        ObservableList<Sales> salesList = SalesDaoImpl.getSalesById(Integer.parseInt(textIdSale.getText()));
        tableSales.setItems(salesList);
        colIdSale.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Id_sales"));
        colNameSale.setCellValueFactory(new PropertyValueFactory<Sales, String>("Product_name"));
        colUnites.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Unites"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("Total"));
        colDate.setCellValueFactory(new PropertyValueFactory<Sales, String>("Date"));
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
}

