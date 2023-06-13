package com.example.projectbd2.Courier;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Courier_Delete {
    @FXML
    TextField id;
    boolean isValid;
    @FXML
    Label warningText;
    Courier_Repository courierRepository;

    @FXML
    public void onDeleteButtonClick() throws SQLException {
        courierRepository = new Courier_Repository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (courierRepository.cekId(Integer.parseInt(x)) && isValid) {
                    courierRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCourierController().updateTable();
                app.setPrimaryStage(app.getCourier());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (courierRepository.cekId(i) && isValid) {
                    courierRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCourierController().updateTable();
                app.setPrimaryStage(app.getCourier());
            }
        }
        else {
            if (courierRepository.cekId(Integer.parseInt(id.getText()))){
                courierRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCourierController().updateTable();
                app.setPrimaryStage(app.getCourier());
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
