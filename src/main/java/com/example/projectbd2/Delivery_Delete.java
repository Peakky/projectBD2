package com.example.projectbd2;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Delivery_Delete {
    @FXML
    TextField id;
    boolean isValid = false;
    @FXML
    Label warningText;
    Delivery_Repository deliveryRepository;

    @FXML
    public void onDeleteButtonClick() throws SQLException {
        deliveryRepository = new Delivery_Repository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (deliveryRepository.cekId(Integer.parseInt(x)) && isValid) {
                    deliveryRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getDeliveryController().updateTable();
                app.setPrimaryStage(app.getDelivery());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (deliveryRepository.cekId(i) && isValid) {
                    deliveryRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getDeliveryController().updateTable();
                app.setPrimaryStage(app.getDelivery());
            }
        }
        else {
            if (deliveryRepository.cekId(Integer.parseInt(id.getText()))){
                deliveryRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getDeliveryController().updateTable();
                app.setPrimaryStage(app.getDelivery());
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
