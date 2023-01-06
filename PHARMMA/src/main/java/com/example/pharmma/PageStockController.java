package com.example.pharmma;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PageStockController implements Initializable {

    @FXML
    static
    Label outOfStockLabel = new Label();

    @FXML
    Label unitsLabel = new Label();


    public static void fillOutOfStockLabel() {
        int outOfStockVAR = PageStock.outOfStock();
        outOfStockLabel.setText(String.valueOf(outOfStockVAR));
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}