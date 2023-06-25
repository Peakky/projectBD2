package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Pagination;
import com.example.projectbd2.Warehouse.Warehouse;
import com.example.projectbd2.Warehouse.WarehouseProperty;
import com.example.projectbd2.Warehouse.WarehouseRepository;
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

public class WarehouseController implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<WarehouseProperty, String> ColumnID, ColumnNama,ColumnAlamat, ColumnNoTelp;
    @FXML
    private TableView<WarehouseProperty> TableWarehouse;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<WarehouseProperty> warehouseProperties = FXCollections.observableArrayList();

    private WarehouseRepository warehouseRepository = new WarehouseRepository();

    public WarehouseController() throws SQLException {
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
        app.setPrimaryStage(app.getWarehouseInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getWarehouseUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getWarehouseDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((warehouseRepository.GetWarehouseCount()  / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        warehouseProperties = FXCollections.observableArrayList();
        ArrayList<Warehouse> result;
        try {
            result = warehouseRepository.GetWarehouse(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((t) -> {
            WarehouseProperty tp = new WarehouseProperty();
            tp.setWarehouseID(Integer.toString(t.WarehouseID));
            tp.setNamaWarehouse(t.NamaWarehouse);
            tp.setAlamat(t.alamat);
            tp.setNoTelp(Integer.toString(t.NomorTelp));
            warehouseProperties.add(tp);
        });
        TableWarehouse.setItems(warehouseProperties);
        updateButton();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnID.setCellValueFactory(f -> f.getValue().warehouseIDProperty());
        ColumnNama.setCellValueFactory(f -> f.getValue().namaWarehouseProperty());
        ColumnAlamat.setCellValueFactory(f -> f.getValue().alamatProperty());
        ColumnNoTelp.setCellValueFactory(f -> f.getValue().noTelpProperty());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
