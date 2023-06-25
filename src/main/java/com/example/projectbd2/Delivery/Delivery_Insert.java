package com.example.projectbd2.Delivery;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Delivery_Insert {
    @FXML
    TextField Tanggal_Delivery, CourierID;
    @FXML
    Label warningText;
    Delivery_Repository deliveryRepository;

    @FXML
    public void onAddButtonClick() throws SQLException {
        deliveryRepository = new Delivery_Repository();

            deliveryRepository.insertData(Tanggal_Delivery.getText(), Integer.parseInt(CourierID.getText()));
            HelloApplication app = HelloApplication.getapplicationInstance();
            app.getDeliveryController().updateTable();
            app.setPrimaryStage(app.getDelivery());

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
