package com.example.projectbd2.Order;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Order_Insert {
    @FXML
    TextField Tanggal_Order, TransactionID;
    @FXML
    Label warningText;
    Order_Repository orderRepository;

    @FXML
    public void onAddButtonClick() throws SQLException {
        orderRepository = new Order_Repository();

        orderRepository.insertData(Tanggal_Order.getText(), Integer.parseInt(TransactionID.getText()));
        HelloApplication app = HelloApplication.getapplicationInstance();
        app.getOrderController().updateTable();
        app.setPrimaryStage(app.getOrder());

    }

    public static boolean isNumeric(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
