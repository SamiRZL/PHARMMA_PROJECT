module com.example.pharmma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pharmma to javafx.fxml;
    exports com.example.pharmma;
}