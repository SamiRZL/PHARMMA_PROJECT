package com.example.pharmma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddWindow implements Initializable {
    @FXML
    private TextField textNameAcc;

    @FXML
    private  TextField textLastNameAcc;

    @FXML
    private  TextField textJob;

    @FXML
    private  TextField textUsername;

    @FXML
    private  TextField textPassword;

    private Stage stage;
    private Parent root;

    @FXML
    public void addAccountPerformed(ActionEvent actionEvent) throws IOException {



        AccountDaoImpl.addAccount(textNameAcc.getText(), textLastNameAcc.getText(), textJob.getText(), textUsername.getText(), textPassword.getText());
        clearFields();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountController.fxml"));
        root = fxmlLoader.load();





        AccountController accCtrl = fxmlLoader.getController();
        accCtrl.showAccounts();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow() ;
        stage.setScene(new Scene(root));
        stage.show();




    }


    public  void clearFields(){
        textNameAcc.setText(null);
        textLastNameAcc .setText(null);
        textJob.setText(null);
        textUsername.setText(null);
        textPassword.setText(null);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
