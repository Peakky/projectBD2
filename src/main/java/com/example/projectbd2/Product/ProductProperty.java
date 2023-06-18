package com.example.projectbd2.Product;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class ProductProperty {
    SimpleStringProperty ProductID;
    SimpleStringProperty NamaProduct;
    SimpleStringProperty SupplierID;
    SimpleStringProperty StockProduct;
    SimpleStringProperty WarehouseID;

    public ProductProperty() {
        ProductID = new SimpleStringProperty(this, "Product ID");
        NamaProduct = new SimpleStringProperty(this, "Nama Product");
        SupplierID = new SimpleStringProperty(this, "Supplier ID");
        StockProduct = new SimpleStringProperty(this, "Product Ready");
        WarehouseID = new SimpleStringProperty(this, "Warehouse ID");

    }

    public String getProductID() {
        return ProductID.get();
    }

    public SimpleStringProperty productIDProperty() {
        return ProductID;
    }

    public void setProductID(String productID) {
        this.ProductID.set(productID);
    }

    public String getNamaProduct() {
        return NamaProduct.get();
    }

    public SimpleStringProperty namaProductProperty() {
        return NamaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.NamaProduct.set(namaProduct);
    }

    public String getSupplierID() {
        return SupplierID.get();
    }

    public SimpleStringProperty supplierIDProperty() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        this.SupplierID.set(supplierID);
    }

    public String getStockProduct() {
        return StockProduct.get();
    }

    public SimpleStringProperty stockProductProperty() {
        return StockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.StockProduct.set(stockProduct);
    }

    public String getWarehouseID() {
        return WarehouseID.get();
    }

    public SimpleStringProperty warehouseIDProperty() {
        return WarehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.WarehouseID.set(warehouseID);
    }

}
