package com.example.projectbd2;

import com.example.projectbd2.Courier.Courier_Controller;
import com.example.projectbd2.Courier.Courier_Delete;
import com.example.projectbd2.Courier.Courier_Insert;
import com.example.projectbd2.Courier.Courier_Update;
import com.example.projectbd2.Customer.Customer_Controller;
import com.example.projectbd2.Customer.Customer_Delete;
import com.example.projectbd2.Customer.Customer_Insert;
import com.example.projectbd2.Customer.Customer_Update;
import com.example.projectbd2.Delivery.Delivery_Controller;
import com.example.projectbd2.Delivery.Delivery_Delete;
import com.example.projectbd2.Delivery.Delivery_Insert;
import com.example.projectbd2.Delivery.Delivery_Update;
import com.example.projectbd2.Order.Order_Controller;
import com.example.projectbd2.Order.Order_Delete;
import com.example.projectbd2.Order.Order_Insert;
import com.example.projectbd2.Order.Order_Update;
import com.example.projectbd2.Transaction.Transaction_Controller;
import com.example.projectbd2.Transaction.Transaction_Delete;
import com.example.projectbd2.Transaction.Transaction_Insert;
import com.example.projectbd2.Transaction.Transaction_Update;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private Scene menu;
    private Scene courier,courierInsert,courierUpdate,courierDelete;
    private Scene customer,customerInsert,customerUpdate,customerDelete;
    private Scene delivery,deliveryInsert,deliveryUpdate,deliveryDelete;
    private Scene order,orderInsert,orderUpdate,orderDelete;
    private Scene transaction,transactionInsert,transactionUpdate,transactionDelete;
    private Courier_Controller courierController;
    private Courier_Insert courierInsertController;
    private Courier_Update courierUpdateController;
    private Courier_Delete courierDeleteController;
    private Customer_Controller customerController;
    private Customer_Insert customerInsertController;
    private Customer_Update customerUpdateController;
    private Customer_Delete customerDeleteController;
    private Delivery_Controller deliveryController;
    private Delivery_Insert deliveryInsertController;
    private Delivery_Update deliveryUpdateController;
    private Delivery_Delete deliveryDeleteController;
    private Transaction_Controller transactionController;
    private Transaction_Insert transactionInsertController;
    private Transaction_Update transactionUpdateController;
    private Transaction_Delete transactionDeleteController;
    private Order_Controller orderController;
    private Order_Insert orderInsertController;
    private Order_Update orderUpdateController;
    private Order_Delete orderDeleteController;

    public void setPrimaryStage(Scene scene){
        this.primaryStage.setScene(scene);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getMenu() {
        return menu;
    }

    public Scene getCourier() {
        return courier;
    }

    public Scene getCourierInsert() {
        return courierInsert;
    }

    public Scene getCourierUpdate() {
        return courierUpdate;
    }

    public Scene getCourierDelete() {
        return courierDelete;
    }

    public Scene getCustomer() {
        return customer;
    }

    public Scene getCustomerInsert() {
        return customerInsert;
    }

    public Scene getCustomerUpdate() {
        return customerUpdate;
    }

    public Scene getCustomerDelete() {
        return customerDelete;
    }

    public Scene getDelivery() {
        return delivery;
    }

    public Scene getDeliveryInsert() {
        return deliveryInsert;
    }

    public Scene getDeliveryUpdate() {
        return deliveryUpdate;
    }

    public Scene getDeliveryDelete() {
        return deliveryDelete;
    }

    public Scene getOrder() {
        return order;
    }

    public Scene getOrderInsert() {
        return orderInsert;
    }

    public Scene getOrderUpdate() {
        return orderUpdate;
    }

    public Scene getOrderDelete() {
        return orderDelete;
    }

    public Scene getTransaction() {
        return transaction;
    }

    public Scene getTransactionInsert() {
        return transactionInsert;
    }

    public Scene getTransactionUpdate() {
        return transactionUpdate;
    }

    public Scene getTransactionDelete() {
        return transactionDelete;
    }

    public Courier_Controller getCourierController() {
        return courierController;
    }

    public Courier_Insert getCourierInsertController() {
        return courierInsertController;
    }

    public Courier_Update getCourierUpdateController() {
        return courierUpdateController;
    }

    public Courier_Delete getCourierDeleteController() {
        return courierDeleteController;
    }

    public Customer_Controller getCustomerController() {
        return customerController;
    }

    public Customer_Insert getCustomerInsertController() {
        return customerInsertController;
    }

    public Customer_Update getCustomerUpdateController() {
        return customerUpdateController;
    }

    public Customer_Delete getCustomerDeleteController() {
        return customerDeleteController;
    }

    public Delivery_Controller getDeliveryController() {
        return deliveryController;
    }

    public Delivery_Insert getDeliveryInsertController() {
        return deliveryInsertController;
    }

    public Delivery_Update getDeliveryUpdateController() {
        return deliveryUpdateController;
    }

    public Delivery_Delete getDeliveryDeleteController() {
        return deliveryDeleteController;
    }

    public Transaction_Controller getTransactionController() {
        return transactionController;
    }

    public Transaction_Insert getTransactionInsertController() {
        return transactionInsertController;
    }

    public Transaction_Update getTransactionUpdateController() {
        return transactionUpdateController;
    }

    public Transaction_Delete getTransactionDeleteController() {
        return transactionDeleteController;
    }

    public Order_Controller getOrderController() {
        return orderController;
    }

    public Order_Insert getOrderInsertController() {
        return orderInsertController;
    }

    public Order_Update getOrderUpdateController() {
        return orderUpdateController;
    }

    public Order_Delete getOrderDeleteController() {
        return orderDeleteController;
    }
    private static HelloApplication applicationInstance;
    public static HelloApplication getApplicationInstance() {
        return applicationInstance;
    }
    public HelloApplication() {
        applicationInstance = this;
    }
    public static HelloApplication getapplicationInstance() {
        return applicationInstance;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Babi!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}