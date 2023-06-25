package com.example.projectbd2;

public class Menu {
    public void onCourierButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCourier());
    }
    public void onCustomerButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getCustomer());
    }

    public void onDeliveryClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getDelivery());
    }

    public void onTransaksiButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getTransaction());
    }
    public void onOrderButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getOrder());
    }
    public void onProductButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getProduct());
    }
    public void onSupplierButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getSupplier());
    }
    public void onWarehouseButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getWarehouse());
    }
}
