package com.example.projectbd2;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Order.Order_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Order_Update {
    @FXML
    TextField Id_Order, Tanggal_Order,TransactionID;
    @FXML
    Label warningText;
    Order_Repository orderRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        orderRepository = new Order_Repository();
        if (!isNumeric(Id_Order.getText())){
            warningText.setText("Id harus angka");
        }
        else if (!orderRepository.cekId(Integer.parseInt(Id_Order.getText()))){
            warningText.setText("Id invalid");
        }else if (!isNumeric(TransactionID.getText())){
            warningText.setText("TransactionID harus angka!");
        }
        else {
            orderRepository.updateData(Integer.parseInt(Id_Order.getText()), Tanggal_Order.getText(), Integer.parseInt(TransactionID.getText()));
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
