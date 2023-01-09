package com.example.pharmma;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageDashboardController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PHARMMA.fxml"));
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
    public void switchToSTOCK(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("STOCK.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
