package com.example.projectbd2.Customer;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Customer_Insert {
    @FXML
    TextField nama, email, number, jumlahUang;
    @FXML
    Label warningText;
    Customer_Repository customerRepository;

    @FXML
    public void onAddButtonClick() throws SQLException {
        customerRepository = new Customer_Repository();
        if (!isNumeric(number.getText())){
            warningText.setText("Number harus angka");
        }
        else {
            customerRepository.insertData(nama.getText(), email.getText(),number.getText());
            HelloApplication app = HelloApplication.getapplicationInstance();
            app.getCustomerController().updateTable();
            app.setPrimaryStage(app.getCustomer());
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
