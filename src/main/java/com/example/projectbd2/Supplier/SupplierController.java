package com.example.projectbd2.Supplier;

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

public class SupplierController implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<SupplierProperty, String> IDSup, namaSup, NoTelp;
    @FXML
    private TableView<SupplierProperty> TableSupplier;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<SupplierProperty> supplier = FXCollections.observableArrayList();

    private SupplierRepository supplierRepository = new SupplierRepository();

    public SupplierController() throws SQLException {
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
        app.setPrimaryStage(app.getSupplierInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getSupplierUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getSupplierDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((supplierRepository.GetSupplierCount()  / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        supplier = FXCollections.observableArrayList();
        ArrayList<Supplier> result;
        try {
            result = supplierRepository.GetSupplier(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((t) -> {
            SupplierProperty tp = new SupplierProperty();
            tp.setIdSup(Integer.toString(t.id));
            tp.setNamaSup(t.namaSup);

            supplier.add(tp);
        });
        TableSupplier.setItems(supplier);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IDSup.setCellValueFactory(f -> f.getValue().idSupProperty());
        namaSup.setCellValueFactory(f -> f.getValue().namaSupProperty());

        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
