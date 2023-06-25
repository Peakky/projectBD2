package com.example.projectbd2.Product;

public class Product {
    int ProductID, SupplierFK,StockProduct,WarehouseID;
    String NamaProduct;

    public Product(int productID,String namaProduct,int StockProduct, int supplierID,int WarehouseID) {
        ProductID = productID;
        this.StockProduct = StockProduct;
        SupplierFK = supplierID;
        NamaProduct = namaProduct;
        this.WarehouseID = WarehouseID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getSupplierFK() {
        return SupplierFK;
    }

    public void setSupplierFK(int supplierFK) {
        SupplierFK = supplierFK;
    }

    public int getStockProduct() {
        return StockProduct;
    }

    public void setStockProduct(int stockProduct) {
        StockProduct = stockProduct;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        WarehouseID = warehouseID;
    }

    public String getNamaProduct() {
        return NamaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        NamaProduct = namaProduct;
    }
}
