package com.example.projectbd2.Transaction;

import com.example.projectbd2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Transaction_Delete {
    @FXML
    TextField id;
    boolean isValid;
    @FXML
    Label warningText;
    Transaction_Repository transactionRepository;

    @FXML
    public void onDeleteButtonClick() throws SQLException {
        transactionRepository = new Transaction_Repository();
        String inputId = id.getText().replace(" ","");
        isValid = true;
        if (inputId.contains(",")){
            String[] temp = inputId.split(",");
            for (String x : temp) {
                if (transactionRepository.cekId(Integer.parseInt(x)) && isValid) {
                    transactionRepository.deleteData(Integer.parseInt(x));
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getTransactionController().updateTable();
                app.setPrimaryStage(app.getTransaction());
            }
        }
        else if (inputId.contains("-")){
            String[] temp = inputId.split("-");
            for (int i = Integer.parseInt(temp[0]) ; i <= Integer.parseInt(temp[1]) ; i++){
                if (transactionRepository.cekId(i) && isValid) {
                    transactionRepository.deleteData(i);
                }
                else {
                    warningText.setText("Input Invalid");
                    isValid = false;
                }
            }
            if (isValid){
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getTransactionController().updateTable();
                app.setPrimaryStage(app.getTransaction());
            }
        }
        else {
            if (transactionRepository.cekId(Integer.parseInt(id.getText()))){
                transactionRepository.deleteData(Integer.parseInt(id.getText()));
                HelloApplication app = HelloApplication.getapplicationInstance();
                app.getTransactionController().updateTable();
                app.setPrimaryStage(app.getTransactionDelete());
            }
            else {
                warningText.setText("Input Invalid");
            }
        }
    }
}
