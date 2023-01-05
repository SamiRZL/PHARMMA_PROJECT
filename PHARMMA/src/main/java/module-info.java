module com.example.pharmma {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pharmma to javafx.fxml;
    exports com.example.pharmma;
}