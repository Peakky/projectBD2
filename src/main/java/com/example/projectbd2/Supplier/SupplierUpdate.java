package com.example.projectbd2.Supplier;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Transaction.Transaction_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SupplierUpdate {
    @FXML
    TextField id, NamaSup, NoTelepon;
    boolean isValid;
    @FXML
    Label warningText;
    SupplierRepository supplierRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        supplierRepository = new SupplierRepository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka!");
        }
        else if (!supplierRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        } else if (!isNumeric(NoTelepon.getText())) {
            warningText.setText("No Telepon Harus angka!");
        }else {
            try {
                supplierRepository.updateData(Integer.parseInt(id.getText()), NamaSup.getText(), Integer.parseInt(NoTelepon.getText()));
            } catch (SQLIntegrityConstraintViolationException e) {
                warningText.setText("Pengguna ID Tidak ditemukan");
                isValid = false;
            }
            if (isValid) {
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getSupplierController().updateTable();
                app.setPrimaryStage(app.getSupplier());
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
