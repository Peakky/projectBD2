package com.example.projectbd2.Product;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Supplier.SupplierRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProductInsert {
    @FXML
        TextField NamaProduct, JumlahProduct, SupplierID,WarehouseID;
    Label warningText;
    ProductRepository productRepository;
    @FXML
    public void onAddButtonClick() throws SQLException {
        productRepository = new ProductRepository();
        if (!isNumeric(JumlahProduct.getText())){
            warningText.setText("Jumlah Product Harus Angka!");
        } else if (!isNumeric(SupplierID.getText())) {
            warningText.setText("Supplier ID Harus Angka");
        } else if (!isNumeric(WarehouseID.getText())) {
            warningText.setText("Warehouse ID harus angka!");
        } else {
            try {
                productRepository.insertData(NamaProduct.getText(),Integer.parseInt(JumlahProduct.getText()), Integer.parseInt(SupplierID.getText()), Integer.parseInt(WarehouseID.getText()));
            } catch (SQLIntegrityConstraintViolationException e){
                warningText.setText("Pengguna ID Tidak ditemukan");
            }
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getProductController().updateTable();
                app.setPrimaryStage(app.getProduct());
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
