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
}
