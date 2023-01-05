module com.example.pharmma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.pharmma to javafx.fxml;
    exports com.example.pharmma;
}