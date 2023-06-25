package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Product.ProductRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProductUpdate {
    @FXML
    TextField id, NamaProduct, JumlahProduct, SupplierID,WarehouseID;
    boolean isValid;
    @FXML
    Label warningText;
    ProductRepository productRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        productRepository = new ProductRepository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka!");
        }
        else if (!productRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        } else if (!isNumeric(JumlahProduct.getText())) {
            warningText.setText("Jumlah Produk Harus angka!");
        } else if (!isNumeric(SupplierID.getText())) {
            warningText.setText("Supplier ID harus angka!");
        } else if (!isNumeric(WarehouseID.getText())) {
            warningText.setText("WarehouseID harus angka!");
        } else {
            try {
                productRepository.updateData(Integer.parseInt(id.getText()), NamaProduct.getText(), Integer.parseInt(JumlahProduct.getText()), Integer.parseInt(SupplierID.getText()), Integer.parseInt(WarehouseID.getText()));
            } catch (SQLIntegrityConstraintViolationException e) {
                warningText.setText("Supplier ID Tidak ditemukan");
                isValid = false;
            }
            if (isValid) {
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getProductController().updateTable();
                app.setPrimaryStage(app.getProduct());
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
