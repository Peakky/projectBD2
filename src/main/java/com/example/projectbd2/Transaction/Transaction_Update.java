package com.example.projectbd2.Transaction;

import com.example.projectbd2.HelloApplication;
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
        else if (!(tanggal.getText().length() >= 10)){
            warningText.setText("Tanggal Invalid");
        }
        else if (!(tanggal.getText().charAt(4) == '-')){
            warningText.setText("Tanggal Invalid");
        }
        else if (!(tanggal.getText().charAt(7) == '-')){
            warningText.setText("Tanggal Invalid");
        }
        else {
            String[] temp = tanggal.getText().split("-");
            String tanggalAkhir = "";
            for (String s : temp) {
                if (!isNumeric(s)) {
                    warningText.setText("Tanggal Invalid");
                }
            }
            if (temp.length != 3){
                warningText.setText("Tanggal Invalid");
            }
            else if (Integer.parseInt(temp[1]) > 12 || Integer.parseInt(temp[1]) < 0){
                warningText.setText("Bulan Invalid");
            }
            else if (Integer.parseInt(temp[2]) > 31 || Integer.parseInt(temp[2]) < 0){
                warningText.setText("Bulan Invalid");
            }
            else {
                tanggalAkhir += temp[0] + "-" + temp[1] + "-" + temp[2];
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
