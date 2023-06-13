module com.example.projectbd2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projectbd2 to javafx.fxml;
    exports com.example.projectbd2;
}