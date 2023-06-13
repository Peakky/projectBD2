package com.example.projectbd2.Delivery;

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

public class Delivery_Controller implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<Delivery_Property, String> ColumnIdDelivery, ColumnTanggalDelivery;
    @FXML
    private TableView<Delivery_Property> TableViewDelivery;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<Delivery_Property> deliveries = FXCollections.observableArrayList();

    private Delivery_Repository deliveryRepository = new Delivery_Repository();

    public Delivery_Controller() throws SQLException {
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
        app.setPrimaryStage(app.getDeliveryInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getDeliveryUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getDeliveryDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((deliveryRepository.GetDeliveryCount() / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        deliveries = FXCollections.observableArrayList();
        ArrayList<Delivery> result;
        try {
            result = deliveryRepository.GetDelivery(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((f) -> {
            Delivery_Property ft = new Delivery_Property();
            ft.setId(Integer.toString(f.deliveryID));
            ft.setTanggal_Delivery(f.Tanggal_Delivery);

            deliveries.add(ft);
        });
        TableViewDelivery.setItems(deliveries);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnIdDelivery.setCellValueFactory(f -> f.getValue().IdDelivery());
        ColumnTanggalDelivery.setCellValueFactory(f -> f.getValue().TanggalDelivery());

        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
