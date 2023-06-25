package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Supplier.SupplierRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SupplierDelete {
    @FXML
    TextField id;
    boolean isValid;
    Label warningText;
    SupplierRepository supplierRepository;
    @FXML
    public void onDeleteButtonClick() throws SQLException {
        supplierRepository = new SupplierRepository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (supplierRepository.cekId(Integer.parseInt(x)) && isValid) {
                    supplierRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getSupplierController().updateTable();
                app.setPrimaryStage(app.getSupplier());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (supplierRepository.cekId(i) && isValid) {
                    supplierRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getProductController().updateTable();
                app.setPrimaryStage(app.getProduct());
            }
        }
        else {
            if (supplierRepository.cekId(Integer.parseInt(id.getText()))){
                supplierRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getSupplierController().updateTable();
                app.setPrimaryStage(app.getSupplier());;
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
