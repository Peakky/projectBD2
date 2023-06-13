package com.example.projectbd2.Transaction;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Pagination;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Transaction_Controller implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<Transaction_Property, String> ColumnId,ColumnNominal;
    @FXML
    private TableView<Transaction_Property> TableViewTransaction;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<Transaction_Property> transactions = FXCollections.observableArrayList();

    private Transaction_Repository transactionRepository = new Transaction_Repository();

    public Transaction_Controller() throws SQLException {
    }

    @FXML
    void onNextButtonClick(ActionEvent event) throws SQLException {
        page++;
        updateTable();
    }

    @FXML
    void onPrevButtonClick(ActionEvent event) throws SQLException {
        page--;
        updateTable();
    }

    @FXML
    void onBackButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getMenu());
    }

    @FXML
    void onAddButtonClick(){
        HelloApplication app = HelloApplication.getapplicationInstance();
        app.setPrimaryStage(app.getTransactionInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getTransactionUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getTransactionDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((transactionRepository.GetTransactionCount() / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        transactions = FXCollections.observableArrayList();
        ArrayList<Transaction> result;
        try {
            result = transactionRepository.GetTransaction(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((t) -> {
            Transaction_Property tp = new Transaction_Property();
            tp.setId(Integer.toString(t.id));
            tp.setNominal(Integer.toString(t.nominal));
            transactions.add(tp);
        });
        TableViewTransaction.setItems(transactions);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnId.setCellValueFactory(f -> f.getValue().idTransaction());
        ColumnNominal.setCellValueFactory(f -> f.getValue().NominalTransaction());

        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
