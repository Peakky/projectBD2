package com.example.projectbd2.Courier;

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

public class Courier_Controller implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<Courier_Property, String> ColumnId, ColumnNama, ColumnNomor;
    @FXML
    private TableView<Courier_Property> TableViewCourier;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<Courier_Property> Couriers = FXCollections.observableArrayList();

    private Courier_Repository courierRepository = new Courier_Repository();

    public Courier_Controller() throws SQLException {
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
        app.setPrimaryStage(app.getCourierInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCourierUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCourierDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((courierRepository.GetCourierCount() / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        Couriers = FXCollections.observableArrayList();
        ArrayList<Courier> result;
        try {
            result = courierRepository.GetCourier(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((p) -> {
            Courier_Property cp = new Courier_Property();
            cp.setId(Integer.toString(p.courierID));
            cp.setNama(p.nama);
            cp.setNo_telp(p.no_telp);

            Couriers.add(cp);
        });
        TableViewCourier.setItems(Couriers);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnId.setCellValueFactory(f -> f.getValue().IdCourier());
        ColumnNama.setCellValueFactory(f -> f.getValue().NamaCourier());
        ColumnNomor.setCellValueFactory(f-> f.getValue().no_Courier());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
