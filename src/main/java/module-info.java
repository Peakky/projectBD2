module com.example.projectbd2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;

    exports com.example.projectbd2;
    exports com.example.projectbd2.Courier;
    exports com.example.projectbd2.Customer;
    exports com.example.projectbd2.Delivery;
    exports com.example.projectbd2.Transaction;
    exports com.example.projectbd2.Order;
    exports com.example.projectbd2.Product;
    exports com.example.projectbd2.Supplier;
    exports com.example.projectbd2.Warehouse;

    opens com.example.projectbd2 to javafx.fxml;
    opens com.example.projectbd2.Courier to javafx.fxml;
    opens com.example.projectbd2.Customer to javafx.fxml;
    opens com.example.projectbd2.Delivery to javafx.fxml;
    opens com.example.projectbd2.Transaction to javafx.fxml;
    opens com.example.projectbd2.Order to javafx.fxml;
    opens com.example.projectbd2.Product to javafx.fxml;
    opens com.example.projectbd2.Supplier to javafx.fxml;
    opens com.example.projectbd2.Warehouse to javafx.fxml;

}