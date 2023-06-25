package com.example.projectbd2;

import com.example.projectbd2.Customer.Customer_Repository;
import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Customer_Delete {
    @FXML
    TextField id;
    boolean isValid;
    @FXML
    Label warningText;
    Customer_Repository customerRepository;

    @FXML
    public void onDeleteButtonClick() throws SQLException {
        customerRepository = new Customer_Repository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (customerRepository.cekId(Integer.parseInt(x)) && isValid) {
                    customerRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCustomerController().updateTable();
                app.setPrimaryStage(app.getCustomer());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (customerRepository.cekId(i) && isValid) {
                    customerRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCustomerController().updateTable();
                app.setPrimaryStage(app.getCustomer());
            }
        }
        else {
            if (customerRepository.cekId(Integer.parseInt(id.getText()))){
                customerRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getCustomerController().updateTable();
                app.setPrimaryStage(app.getCustomer());
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
