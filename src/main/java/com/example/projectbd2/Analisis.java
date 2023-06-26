package com.example.projectbd2;

import com.example.projectbd2.Customer.Customer;
import com.example.projectbd2.Customer.Customer_Property;
import com.example.projectbd2.Customer.Customer_Repository;
import com.example.projectbd2.Supplier.Supplier;
import com.example.projectbd2.Supplier.SupplierProperty;
import com.example.projectbd2.Supplier.SupplierRepository;
import com.example.projectbd2.Transaction.Transaction_Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Analisis implements Initializable {
    @FXML
    Label Nominal;
    @FXML
    TableColumn<Customer_Property,String> ColumnID,ColumnNama,ColumnEmail,ColumnNoHP;
    @FXML
    TableColumn<SupplierProperty,String>ColumnSID,ColumnNamaSup;
    @FXML
    TableView<Customer_Property> TableCustomer;
    @FXML
    TableView<SupplierProperty> TableSupplier;

    private int page = 1;
    private int rowsPerPage = 3;
    private Transaction_Repository transactionRepository = new Transaction_Repository();
    private ObservableList<Customer_Property> customer = FXCollections.observableArrayList();
    private ObservableList<SupplierProperty> Supplier = FXCollections.observableArrayList();
    private Customer_Repository customerRepository = new Customer_Repository();
    private SupplierRepository SupplierRepository = new SupplierRepository();

    public Analisis() throws SQLException {
    }

    public void updateTable() throws SQLException{
        customer = FXCollections.observableArrayList();
        ArrayList<Customer> result;
        try {
            result = customerRepository.GetMostContribution(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((p) -> {
            Customer_Property ct = new Customer_Property();
            ct.setId(Integer.toString(p.getCustomerID()));
            ct.setNama(p.getNama());
            ct.setEmail(p.getEmail());
            ct.setNumber(p.getNo_hp());
            customer.add(ct);
        });
        TableCustomer.setItems(customer);

        Supplier = FXCollections.observableArrayList();
        ArrayList<Supplier> resultFilm;
        try {
            resultFilm = SupplierRepository.GetMostSupplier(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resultFilm.forEach((f) -> {
            SupplierProperty ft = new SupplierProperty();
            ft.setIdSup(Integer.toString(f.getId()));
            ft.setNamaSup(f.getNamaSup());
            Supplier.add(ft);
        });
        TableSupplier.setItems(Supplier);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Nominal.setText(transactionRepository.getNominal(new Pagination(1,1)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ColumnID.setCellValueFactory(f -> f.getValue().Id_Customer());
        ColumnNama.setCellValueFactory(f -> f.getValue().NamaCustomer());
        ColumnEmail.setCellValueFactory(f -> f.getValue().EmailCustomer());
        ColumnNoHP.setCellValueFactory(f -> f.getValue().NumberCustomer());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ColumnSID.setCellValueFactory(f -> f.getValue().idSupProperty());
        ColumnNamaSup.setCellValueFactory(f -> f.getValue().namaSupProperty());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void onBackButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getMenu());
    }


}
