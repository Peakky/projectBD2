package com.example.projectbd2;

import com.example.projectbd2.Delivery.Delivery_Repository;
import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Order.Order_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Order_Delete {
    @FXML
    TextField id;
    boolean isValid = false;
    @FXML
    Label warningText;
    Order_Repository orderRepository;

    @FXML
    public void onDeleteButtonClick() throws SQLException {
        orderRepository = new Order_Repository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (orderRepository.cekId(Integer.parseInt(x)) && isValid) {
                    orderRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getOrderController().updateTable();
                app.setPrimaryStage(app.getOrder());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (orderRepository.cekId(i) && isValid) {
                    orderRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getOrderController().updateTable();
                app.setPrimaryStage(app.getOrder());
            }
        }
        else {
            if (orderRepository.cekId(Integer.parseInt(id.getText()))){
                orderRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getOrderController().updateTable();
                app.setPrimaryStage(app.getOrder());
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
