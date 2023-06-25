package com.example.projectbd2;

import com.example.projectbd2.Warehouse.*;
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
    private Scene Product,ProductInsert,ProductUpdate,ProductDelete;
    private Scene order,orderInsert,orderUpdate,orderDelete;
    private Scene transaction,transactionInsert,transactionUpdate,transactionDelete;
    private Scene Supplier, SupplierInsert, SupplierUpdate, SupplierDelete;
    private Scene Warehouse, WarehouseInsert, WarehouseUpdate, WarehouseDelete;
    private Courier_Controller courierController;
    private Courier_Insert courierInsertController;
    private Courier_Update courierUpdateController;
    private Courier_Delete courierDeleteController;
    private Customer_Controller customerController;
    private Customer_Insert customerInsertController;
    private Customer_Update customerUpdateController;
    private Customer_Delete customerDeleteController;
    private ProductController productController;

    private ProductDelete productDeleteController;
    private ProductInsert productInsertController;
    private ProductUpdate productUPdateController;
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
    private WarehouseController warehouseController;
    private WarehouseInsert warehouseInsertController;
    private WarehouseDelete warehouseDeleteController;
    private WarehouseUpdate warehouseUpdateController;
    private SupplierController supplierController;
    private SupplierInsert supplierInsertController;
    private SupplierUpdate supplierUpdateController;
    private SupplierDelete supplierDeleteController;

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

    public SupplierController getSupplierController() {
        return supplierController;
    }

    public void setSupplierController(SupplierController supplierController) {
        this.supplierController = supplierController;
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

    public Scene getSupplier() {
        return Supplier;
    }

    public void setSupplier(Scene supplier) {
        Supplier = supplier;
    }

    public Scene getSupplierInsert() {
        return SupplierInsert;
    }

    public void setSupplierInsert(Scene supplierInsert) {
        SupplierInsert = supplierInsert;
    }

    public Scene getSupplierUpdate() {
        return SupplierUpdate;
    }

    public void setSupplierUpdate(Scene supplierUpdate) {
        SupplierUpdate = supplierUpdate;
    }

    public Scene getSupplierDelete() {
        return SupplierDelete;
    }

    public void setSupplierDelete(Scene supplierDelete) {
        SupplierDelete = supplierDelete;
    }

    public Scene getProduct() {
        return Product;
    }

    public void setProduct(Scene product) {
        Product = product;
    }

    public Scene getProductInsert() {
        return ProductInsert;
    }

    public void setProductInsert(Scene productInsert) {
        ProductInsert = productInsert;
    }

    public Scene getProductUpdate() {
        return ProductUpdate;
    }

    public void setProductUpdate(Scene productUpdate) {
        ProductUpdate = productUpdate;
    }

    public Scene getProductDelete() {
        return ProductDelete;
    }

    public void setProductDelete(Scene productDelete) {
        ProductDelete = productDelete;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public Scene getWarehouse() {
        return Warehouse;
    }

    public Scene getWarehouseInsert() {
        return WarehouseInsert;
    }

    public Scene getWarehouseUpdate() {
        return WarehouseUpdate;
    }

    public Scene getWarehouseDelete() {
        return WarehouseDelete;
    }

    public WarehouseController getWarehouseController() {
        return warehouseController;
    }

    public ProductDelete getProductDeleteController() {
        return productDeleteController;
    }

    public ProductInsert getProductInsertController() {
        return productInsertController;
    }

    public ProductUpdate getProductUPdateController() {
        return productUPdateController;
    }

    public WarehouseInsert getWarehouseInsertController() {
        return warehouseInsertController;
    }

    public WarehouseDelete getWarehouseDeleteController() {
        return warehouseDeleteController;
    }

    public WarehouseUpdate getWarehouseUpdateController() {
        return warehouseUpdateController;
    }

    public SupplierUpdate getSupplierUpdateController() {
        return supplierUpdateController;
    }

    public SupplierDelete getSupplierDeleteController() {
        return supplierDeleteController;
    }

    public SupplierInsert getSupplierInsertController() {
        return supplierInsertController;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        menu = new Scene(fxmlLoader.load());

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Courier.fxml"));
        courier = new Scene(fxmlLoader.load());
        courierController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourierInsert.fxml"));
        courierInsert = new Scene(fxmlLoader.load());
        courierInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourierDelete.fxml"));
        courierDelete = new Scene(fxmlLoader.load());
        courierDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourierUpdate.fxml"));
        courierUpdate = new Scene(fxmlLoader.load());
        courierUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer.fxml"));
        customer = new Scene(fxmlLoader.load());
        customerController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerUpdate.fxml"));
        customerUpdate = new Scene(fxmlLoader.load());
        customerUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerDelete.fxml"));
        customerDelete = new Scene(fxmlLoader.load());
        customerDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerInsert.fxml"));
        customerInsert = new Scene(fxmlLoader.load());
        customerInsertController = fxmlLoader.getController();


        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Delivery.fxml"));
        delivery = new Scene(fxmlLoader.load());
        deliveryController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DeliveryDelete.fxml"));
        deliveryDelete = new Scene(fxmlLoader.load());
        deliveryDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DeliveryInsert.fxml"));
        deliveryInsert = new Scene(fxmlLoader.load());
        deliveryInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DeliveryUpdate.fxml"));
        deliveryUpdate = new Scene(fxmlLoader.load());
        deliveryUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Order.fxml"));
        order = new Scene(fxmlLoader.load());
        orderController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OrderDelete.fxml"));
        orderDelete = new Scene(fxmlLoader.load());
        orderDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OrderInsert.fxml"));
        orderInsert = new Scene(fxmlLoader.load());
        orderInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OrderUpdate.fxml"));
        orderUpdate = new Scene(fxmlLoader.load());
        orderUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Product.fxml"));
        Product = new Scene(fxmlLoader.load());
        productController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductDelete.fxml"));
        ProductDelete = new Scene(fxmlLoader.load());
        productDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductInsert.fxml"));
        ProductInsert = new Scene(fxmlLoader.load());
        productInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductUpdate.fxml"));
        ProductUpdate = new Scene(fxmlLoader.load());
        productUPdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Supplier.fxml"));
        Supplier = new Scene(fxmlLoader.load());
        supplierController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupplierInsert.fxml"));
        SupplierInsert = new Scene(fxmlLoader.load());
        supplierInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupplierDelete.fxml"));
        SupplierDelete = new Scene(fxmlLoader.load());
        supplierDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupplierUpdate.fxml"));
        SupplierUpdate = new Scene(fxmlLoader.load());
        supplierUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Transaction.fxml"));
        transaction = new Scene(fxmlLoader.load());
        transactionController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TransactionDelete.fxml"));
        transactionDelete = new Scene(fxmlLoader.load());
        transactionDeleteController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TransactionUpdate.fxml"));
        transactionUpdate = new Scene(fxmlLoader.load());
        transactionUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TransactionInsert.fxml"));
        transactionInsert = new Scene(fxmlLoader.load());
        transactionInsertController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Warehouse.fxml"));
        Warehouse= new Scene(fxmlLoader.load());
        warehouseController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WarehouseInsert.fxml"));
        WarehouseInsert= new Scene(fxmlLoader.load());
        warehouseInsertController= fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WarehouseUpdate.fxml"));
        WarehouseUpdate= new Scene(fxmlLoader.load());
        warehouseUpdateController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WarehouseDelete.fxml"));
        WarehouseDelete= new Scene(fxmlLoader.load());
        warehouseDeleteController = fxmlLoader.getController();



        stage.setTitle("Project Database!");
        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}