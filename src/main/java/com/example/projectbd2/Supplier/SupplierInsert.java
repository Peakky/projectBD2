package com.example.projectbd2.Supplier;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SupplierInsert {
    @FXML
    TextField  NamaSup, NoTelepon;
    boolean isValid;
    Label warningText;
    SupplierRepository supplierRepository;
    @FXML
    public void onAddButtonClick() throws SQLException {
        supplierRepository = new SupplierRepository();
        if (!isNumeric(NoTelepon.getText())){
            warningText.setText("No Telepon Harus Angka!");
        }
        try {
            supplierRepository.insertData(NamaSup.getText(), Integer.parseInt(NoTelepon.getText()));
        } catch (SQLIntegrityConstraintViolationException e){
            warningText.setText("Gagal Input");
        }
        HelloApplication app = HelloApplication.getapplicationInstance();
        app.getSupplierController().updateTable();
        app.setPrimaryStage(app.getSupplier());
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
