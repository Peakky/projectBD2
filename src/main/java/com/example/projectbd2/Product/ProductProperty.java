package com.example.projectbd2.Product;

import javafx.beans.property.SimpleStringProperty;

public class ProductProperty {
    SimpleStringProperty ProductID;
    SimpleStringProperty NamaProduct;
    SimpleStringProperty SupplierID;

    public ProductProperty() {
        ProductID = new SimpleStringProperty(this, "Product ID");
        NamaProduct = new SimpleStringProperty(this, "Nama Product");
        SupplierID = new SimpleStringProperty(this, "Supplier ID");

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
}
