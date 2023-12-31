package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Supplier.SupplierRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SupplierInsert {
    @FXML
    TextField  NamaSup, NoTelepon;
    Label warningText;
    SupplierRepository supplierRepository;
    @FXML
    public void onAddButtonClick() throws SQLException {
        supplierRepository = new SupplierRepository();
            supplierRepository.insertData(NamaSup.getText(),Integer.parseInt(NoTelepon.getText()));
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
