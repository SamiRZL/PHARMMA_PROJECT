package com.example.pharmma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    double x,y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PHARMMA.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 984, 665);
        AnchorPane root= new AnchorPane();

       // stage.initStyle(StageStyle.UNDECORATED);


        // move around
        root.setOnMousePressed(evt->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        root.setOnMouseDragged(evt->{
            stage.setX(evt.getScreenX()- x);
            stage.setY(evt.getScreenY()- y);

        });


        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}