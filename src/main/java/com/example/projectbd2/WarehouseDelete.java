package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Warehouse.WarehouseRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class WarehouseDelete {
    @FXML
    TextField id;
    boolean isValid;
    Label warningText;
    WarehouseRepository warehouseRepository;
    @FXML
    public void onDeleteButtonClick() throws SQLException {
        warehouseRepository = new WarehouseRepository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (warehouseRepository.cekId(Integer.parseInt(x)) && isValid) {
                    warehouseRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getWarehouseController().updateTable();
                app.setPrimaryStage(app.getWarehouse());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (warehouseRepository.cekId(i) && isValid) {
                    warehouseRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getWarehouseController().updateTable();
                app.setPrimaryStage(app.getWarehouse());
            }
        }
        else {
            if (warehouseRepository.cekId(Integer.parseInt(id.getText()))){
                warehouseRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getWarehouseController().updateTable();
                app.setPrimaryStage(app.getWarehouse());;
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
