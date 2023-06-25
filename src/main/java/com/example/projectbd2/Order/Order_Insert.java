package com.example.projectbd2.Order;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
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
        } else if (!(Tanggal_Order.getText().length() == 10)) {
            warningText.setText("Tanggal Invalid");
        } else if (!(Tanggal_Order.getText().charAt(4) == '-')) {
            warningText.setText("Tanggal Invalid");
        } else if (!(Tanggal_Order.getText().charAt(7) == '-')) {
            warningText.setText("Tanggal Invalid");
        } else {
            String[] temp = Tanggal_Order.getText().split("-");
            String tanggalAkhir = "";
            for (String s : temp) {
                if (!isNumeric(s)) {
                    warningText.setText("Tanggal Invalid");
                }
            }
            if (temp.length != 3) {
                warningText.setText("Tanggal Invalid");
            } else if (Integer.parseInt(temp[1]) > 12 || Integer.parseInt(temp[1]) < 0) {
                warningText.setText("Bulan Invalid");
            } else if (Integer.parseInt(temp[2]) > 31 || Integer.parseInt(temp[2]) < 0) {
                warningText.setText("Bulan Invalid");
            } else {
                tanggalAkhir += temp[0] + "-" + temp[1] + "-" + temp[2];
                isValid = true;
                try {
                    orderRepository.insertData(tanggalAkhir, Integer.parseInt(TransactionID.getText()));
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
