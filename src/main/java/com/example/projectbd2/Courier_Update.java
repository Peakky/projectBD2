package com.example.projectbd2;

import com.example.projectbd2.Courier.Courier_Repository;
import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Courier_Update {
    @FXML
    TextField id, nama, no_hp;
    @FXML
    Label warningText;
    Courier_Repository courierRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        courierRepository = new Courier_Repository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka");
        }
        else if (!courierRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        }
        else {
            courierRepository.updateData(Integer.parseInt(id.getText()), nama.getText(), no_hp.getText());
            HelloApplication app = HelloApplication.getapplicationInstance();
            app.getCourierController().updateTable();
            app.setPrimaryStage(app.getCourier());
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
