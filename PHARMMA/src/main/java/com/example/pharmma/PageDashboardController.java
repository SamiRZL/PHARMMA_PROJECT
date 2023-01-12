package com.example.pharmma;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PageDashboardController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Product> tableProducts;

    @FXML
    private TableColumn<Product, Integer> colIdProd;

    @FXML
    private TableColumn<Product, String> colNameProd;
    @FXML
    private TableColumn<Product, Integer> colQty;

    @FXML
    private TableColumn<Product, Integer> colPrice;

    @FXML
    private TableColumn<Product, String> colExpDate;

   /* @FXML
    private Label totalClts;


    @FXML
    private Label totalGainsLabel;

    */


    @FXML
    private Button switchToStockBtn;

    @FXML
    private Button switchToProfileBtn;


    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PHARMMA.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToClients(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFinances(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Finances.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSTOCK(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("STOCK.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showProducts() {
        ObservableList<Product> productsList = ProductDaoImpl.getProducts();
        tableProducts.setItems(productsList);
        colIdProd.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colNameProd.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<Product, String>("expDate"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProducts();
      /*  try {
            totalGainsLabel.setText(String.valueOf(SalesDaoImpl.totalGain()));

           // ClientController.fillLabelClt();
            //ProductDaoImpl.totalUnits();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

       */
    }
}
