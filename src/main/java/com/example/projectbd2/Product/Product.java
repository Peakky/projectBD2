package com.example.projectbd2.Product;

public class Product {
    int ProductID,SupplierID,StockProduct,WarehouseID;
    String NamaProduct;

    public Product(int productID,String namaProduct,int StockProduct, int supplierID,int WarehouseID) {
        ProductID = productID;
        this.StockProduct = StockProduct;
        SupplierID = supplierID;
        NamaProduct = namaProduct;
        this.WarehouseID = WarehouseID;
    }
}
