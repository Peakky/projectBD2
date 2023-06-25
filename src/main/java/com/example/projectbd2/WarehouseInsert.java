package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Supplier.SupplierRepository;
import com.example.projectbd2.Warehouse.WarehouseRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class WarehouseInsert {
    @FXML
    TextField NamaWarehouse,Alamat, NoTelepon;
    Label warningText;
    WarehouseRepository warehouseRepository;
    @FXML
    public void onAddButtonClick() throws SQLException {
        warehouseRepository = new WarehouseRepository();
        if (!isNumeric(NoTelepon.getText())){
            warningText.setText("No Telepon Harus Angka!");
        }else {
            try {
                warehouseRepository.insertData(NamaWarehouse.getText(), Alamat.getText(), Integer.parseInt(NoTelepon.getText()));
            } catch (SQLIntegrityConstraintViolationException e) {
                warningText.setText("Gagal Input");
            }
            HelloApplication app = HelloApplication.getapplicationInstance();
            app.getWarehouseController().updateTable();
            app.setPrimaryStage(app.getWarehouse());
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
