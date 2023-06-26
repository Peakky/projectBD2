package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Transaction.Transaction_Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Transaction_Update {
    @FXML
    TextField id, tanggal, nominal, penggunaId;
    boolean isValid;
    @FXML
    Label warningText;
    Transaction_Repository transactionRepository;

    @FXML
    public void onEditButtonClick() throws SQLException {
        transactionRepository = new Transaction_Repository();
        if (!isNumeric(id.getText())){
            warningText.setText("Id harus angka");
        }
        else if (!isNumeric(penggunaId.getText())){
            warningText.setText("Pengguna ID harus angka");
        }
        else if (!transactionRepository.cekId(Integer.parseInt(id.getText()))){
            warningText.setText("Id invalid");
        }

                isValid = true;
                try{
                    transactionRepository.updateData(Integer.parseInt(id.getText()),  Integer.parseInt(nominal.getText()));
                } catch (SQLIntegrityConstraintViolationException e){
                    warningText.setText("Pengguna ID Tidak ditemukan");
                    isValid = false;
                }
                if (isValid){
                    HelloApplication app = HelloApplication.getapplicationInstance();
                    app.getTransactionController().updateTable();
                    app.setPrimaryStage(app.getTransaction());
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
