package com.example.projectbd2;

import com.example.projectbd2.Customer.Customer_Repository;
import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Customer_Update {
    @FXML
    TextField id, nama, email, number;
    @FXML
    Label warningText;
    Customer_Repository customerRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        customerRepository = new Customer_Repository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka");
        }
        else if (!isNumeric(number.getText())){
            warningText.setText("Number harus angka");
        }

        else if (!customerRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        }
        else {
            customerRepository.updateData(Integer.parseInt(id.getText()), nama.getText(), email.getText(), (number.getText()));
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
