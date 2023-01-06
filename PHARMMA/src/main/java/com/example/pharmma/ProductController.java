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
public class ProductController implements Initializable {



    @FXML
    private TextField textIdProd;

    @FXML
    private TextField textNameProd;

    @FXML
    private TextField textQty;

    @FXML
    private TextField textPrice;

    @FXML
    private TextField textExpDate;


    // zid les bouttons lahna idha tess7a9
    //.
    //.
    //.
    //.




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

    private int tester = 0;





    @FXML
    public void addProductPerformed(ActionEvent actionEvent) {
        ProductDaoImpl.addProduct(textNameProd.getText(), Integer.parseInt(textQty.getText()), Integer.parseInt(textPrice.getText()), textExpDate.getText());
        showProducts();
        clearFields();
        PageStockController.fillOutOfStockLabel();
        tester ++;
    }

    @FXML
    public void updateProductPerformed(ActionEvent actionEvent) {
        if(tester != 0){
            ProductDaoImpl.updateProductById(Integer.parseInt(textIdProd.getText()), textNameProd.getText(), Integer.parseInt(textQty.getText()), Integer.parseInt(textPrice.getText()), textExpDate.getText());
            showProducts();
            PageStockController.fillOutOfStockLabel();
            clearFields();
        }
    }

    @FXML
    public void deleteProductPerformed(ActionEvent actionEvent) {
        if(tester != 0){
            ProductDaoImpl.deleteProductById(Integer.parseInt(textIdProd.getText()));
            showProducts();
            PageStockController.fillOutOfStockLabel();
            clearFields();
            tester --;
        }
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
        clearFields();
    }



    public void showProducts(){
        ObservableList<Product> productsList = ProductDaoImpl.getProducts();
        tableProducts.setItems(productsList);
        colIdProd.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Id_product"));
        colNameProd.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_name"));
        colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<Product, String>("Exp_date"));
    }


    @FXML
    public void showProductsById(ActionEvent actionEvent){
        ObservableList<Product> productsList = ProductDaoImpl.getProductsById(Integer.parseInt(textIdProd.getText()));
        tableProducts.setItems(productsList);
        colIdProd.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Id_product"));
        colNameProd.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_name"));
        colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<Product, String>("Exp_date"));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProducts();
    }


    public void clearFields(){
        textNameProd.setText(null);
        textQty.setText(null);
        textPrice.setText(null);
        textExpDate.setText(null);


    }
}
