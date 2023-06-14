package com.example.projectbd2.Product;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Supplier.SupplierRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ProductDelete {
    @FXML
    TextField id;
    boolean isValid;
    Label warningText;
    ProductRepository productRepository;
    @FXML
    public void onDeleteButtonClick() throws SQLException {
        productRepository = new ProductRepository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (productRepository.cekId(Integer.parseInt(x)) && isValid) {
                    productRepository.deleteData(Integer.parseInt(x));
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
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (productRepository.cekId(i) && isValid) {
                    productRepository.deleteData(i);
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
            if (productRepository.cekId(Integer.parseInt(id.getText()))){
                productRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getProductController().updateTable();
                app.setPrimaryStage(app.getProduct());;
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
