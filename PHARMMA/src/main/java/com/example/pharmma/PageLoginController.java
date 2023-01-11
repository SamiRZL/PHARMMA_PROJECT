package com.example.pharmma;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.SwingUtilities;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;


import static com.example.pharmma.PageLogin.jobAccount;
import static javax.swing.JFrame.*;


public  class PageLoginController implements Initializable {


    @FXML
    private Label errorLabel = new Label();

    @FXML
    private Label usernameLab = new Label("Username");

    @FXML
    private TextField edtUsername = new TextField();

    @FXML
    private Label passwordLab = new Label("Password");
    @FXML
    private TextField edtPassword = new TextField();

    @FXML
    private Button loginBtn = new Button("Login");




    //ISMAIL HNA ZID kemel DECLARI LES VIEWS LI TES7A9HOM,
    //.
    //.
    //.
    //.
    //.






    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void loginBtnClicked(ActionEvent actionEvent) throws IOException {
        if (PageLogin.login(edtUsername.getText(), edtPassword.getText())) {
        root = FXMLLoader.load(getClass().getResource("DASHBOARD.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();






            if (jobAccount == "vendor") {
                PageDashboardController.switchToProfileBtn.setDisable(true);


            }





            }else{

            errorLabel.setText("Username or password entered is incorrect");
            edtUsername.setText(null);
            edtPassword.setText(null);
        }


            }





       // } else {
         //
      //  }

  //  }


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}