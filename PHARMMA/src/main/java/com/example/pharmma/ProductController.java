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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ProductController implements Initializable{





    @FXML
    private TextField textNameProd;

    @FXML
    private TextField textQty;






    @FXML
    private TextField textPrice;

    @FXML
    private TextField textExpDate;

    @FXML
    private TextField textIdProdDelete;
    @FXML
    private TextField textIdProdUpdate;

    @FXML
    private TextField textIdProdSearch;








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


    @FXML
    private Label outOfStockLabel;

    @FXML
    private Label totalStock  ;



    private int tester = 0;


    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

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
    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PHARMMA.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tester(){
        if (tester == 0){
            btnDelete.setDisable(true);
        }
    }

    @FXML
    public void addProductPerformed(ActionEvent actionEvent) {
       ProductDaoImpl.addProduct(textNameProd.getText(), Integer.parseInt(textQty.getText()), Integer.parseInt(textPrice.getText()), textExpDate.getText());
        showProducts();
        clearFields();
       //fillOutOfStockLabel();
        tester ++;
    }

    @FXML
   public void updateProductPerformed(ActionEvent actionEvent) {
           ProductDaoImpl.updateProductById(Integer.parseInt(textIdProdUpdate.getText()), textNameProd.getText(), Integer.parseInt(textQty.getText()), Integer.parseInt(textPrice.getText()), textExpDate.getText());
           showProducts();
          // fillOutOfStockLabel();
           clearFields();

   }

    @FXML
  public void deleteProductPerformed(ActionEvent actionEvent) {
          ProductDaoImpl.deleteProductById(Integer.parseInt(textIdProdDelete.getText()));
            showProducts();
        outOfStockLabel.setText(String.valueOf(ProductDaoImpl.outOfStock()));

        // fillOutOfStockLabel();
            clearFields();
           tester --;

    }





    public void showProducts(){
        ObservableList<Product> productsList = ProductDaoImpl.getProducts();
       tableProducts.setItems(productsList);
      colIdProd.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colNameProd.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
       colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("qty"));
       colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
       colExpDate.setCellValueFactory(new PropertyValueFactory<Product, String>("expDate"));
    }


   @FXML
   public void showProductsById(ActionEvent actionEvent){
     ObservableList<Product> productsList = ProductDaoImpl.getProductsById(Integer.parseInt(textIdProdSearch.getText()));
        tableProducts.setItems(productsList);
        colIdProd.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colNameProd.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("qty"));
      colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<Product, String>("expDate"));
    }




   public void initialize(URL url, ResourceBundle resourceBundle) {
        showProducts();
       //totalStock.setText(String.valueOf(ProductDaoImpl.totalUnits()));
      // outOfStockLabel.setText(String.valueOf(new ProductDaoImpl().outOfStock()));

        //tester();
    }


   public void clearFields(){
       textNameProd.setText(null);
        textQty.setText(null);
        textPrice.setText(null);
        textExpDate.setText(null);


    }




    //public void fillOutOfStockLabel() {
//        int outOfStockVAR = ProductDaoImpl.outOfStock();
  //     outOfStockLabel.setText(String.valueOf(outOfStockVAR));
    //}

  //public void fillTotalLabel() {
    //    int totalVAR = ProductDaoImpl.totalUnits();
      //  totalStock.setText(String.valueOf(totalVAR));

   // }
}
