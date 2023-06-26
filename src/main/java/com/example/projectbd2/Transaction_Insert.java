package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Transaction.Transaction_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Transaction_Insert {
    @FXML
    TextField tanggal, nominal, penggunaId;
    boolean isValid;
    @FXML
    Label warningText;
    Transaction_Repository transactionRepository;

    @FXML
    public void onAddButtonClick() throws SQLException {
        transactionRepository = new Transaction_Repository();
                try {
                    transactionRepository.insertData(Integer.parseInt(nominal.getText()),Integer.parseInt(penggunaId.getText()));
                } catch (SQLIntegrityConstraintViolationException e){
                    warningText.setText("Pengguna ID Tidak ditemukan");
                    isValid = false;
                }

                    HelloApplication app = HelloApplication.getapplicationInstance();
                    app.getTransactionController().updateTable();
                    app.setPrimaryStage(app.getTransaction());

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
