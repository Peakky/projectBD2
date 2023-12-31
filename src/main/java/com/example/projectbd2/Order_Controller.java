package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Order.Order;
import com.example.projectbd2.Order.Order_Property;
import com.example.projectbd2.Order.Order_Repository;
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

public class Order_Controller implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<Order_Property, String> ColumnIdOrder, ColumnTanggalOrder,ColumnTransactionFK;
    @FXML

    private TableView<Order_Property> TableViewOrder;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<Order_Property> orders = FXCollections.observableArrayList();

    private Order_Repository orderRepository = new Order_Repository();

    public Order_Controller() throws SQLException {
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
        app.setPrimaryStage(app.getOrderInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getOrderUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getOrderDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((orderRepository.GetOrderCount() / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        orders = FXCollections.observableArrayList();
        ArrayList<Order> result;
        try {
            result = orderRepository.GetOrder(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((f) -> {
            Order_Property ot = new Order_Property();
            ot.setId(Integer.toString(f.getOrderID()));
            ot.setTanggal_Order(f.getTanggal_Delivery());
            ot.setTransactionID(Integer.toString(f.getTransactionID()));
            orders.add(ot);
        });
        TableViewOrder.setItems(orders);
        updateButton();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnIdOrder.setCellValueFactory(f -> f.getValue().IdOrder());
        ColumnTanggalOrder.setCellValueFactory(f -> f.getValue().TanggalOrder());
        ColumnTransactionFK.setCellValueFactory(f -> f.getValue().transactionIDProperty());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
