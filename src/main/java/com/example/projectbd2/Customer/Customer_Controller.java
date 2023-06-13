package com.example.projectbd2.Customer;

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

public class Customer_Controller implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<Customer_Property, String> ColumnIdCustomer, ColumnNamaCustomer, ColumnEmailCustomer, ColumnNumberCustomer;
    @FXML
    private TableView<Customer_Property> TableViewCustomer;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<Customer_Property> customers = FXCollections.observableArrayList();

    private Customer_Repository customerRepository = new Customer_Repository();

    public Customer_Controller() throws SQLException {
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
        app.setPrimaryStage(app.getCustomerInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCustomerUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCustomerDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((customerRepository.GetCustomerCount() / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        customers = FXCollections.observableArrayList();
        ArrayList<Customer> result;
        try {
            result = customerRepository.GetCustomer(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((p) -> {
            Customer_Property pt = new Customer_Property();
            pt.setId(Integer.toString(p.customerID));
            pt.setNama(p.nama);
            pt.setEmail(p.email);
            pt.setNumber(p.no_hp);

            customers.add(pt);
        });
        TableViewCustomer.setItems(customers);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnIdCustomer.setCellValueFactory(f -> f.getValue().Id_Customer());
        ColumnNamaCustomer.setCellValueFactory(f -> f.getValue().NamaCustomer());
        ColumnEmailCustomer.setCellValueFactory(f -> f.getValue().EmailCustomer());
        ColumnNumberCustomer.setCellValueFactory(f -> f.getValue().NumberCustomer());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
