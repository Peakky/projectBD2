package com.example.projectbd2.Delivery;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Delivery_Update {
    @FXML
    TextField id, Tanggal, CourierID;
    @FXML
    Label warningText;
    Delivery_Repository deliveryRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        deliveryRepository = new Delivery_Repository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka");
        }
        else if (!deliveryRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        }
        else {
            deliveryRepository.updateData(Integer.parseInt(id.getText()), Tanggal.getText(), Integer.parseInt(CourierID.getText()));
            HelloApplication app = HelloApplication.getapplicationInstance();
            app.getDeliveryController().updateTable();
            app.setPrimaryStage(app.getDelivery());
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
