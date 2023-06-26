package com.example.projectbd2;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Order.Order_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Order_Insert {
    @FXML
    TextField Tanggal_Order, TransactionID;
    @FXML
    Label warningText;
    boolean isValid;
    Order_Repository orderRepository;

    @FXML
    public void onAddButtonClick() throws SQLException {
        orderRepository = new Order_Repository();
        if (!isNumeric(TransactionID.getText())) {
            warningText.setText("Transaction ID harus angka");
        } isValid = true;
                try {
                    orderRepository.insertData(Tanggal_Order.getText(), Integer.parseInt(TransactionID.getText()));
                }catch (SQLIntegrityConstraintViolationException e){
                    warningText.setText("Transaction Tidak ditemukan");
                    isValid = false;
                }
                if (isValid) {
                    HelloApplication app = HelloApplication.getapplicationInstance();
                    app.getOrderController().updateTable();
                    app.setPrimaryStage(app.getOrder());
                }
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
