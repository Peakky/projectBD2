package com.example.projectbd2.Product;

public class Product {
    int ProductID,SupplierID,StockProduct;
    String NamaProduct;

    public Product(int productID,String namaProduct,int StockProduct, int supplierID) {
        ProductID = productID;
        this.StockProduct = StockProduct;
        SupplierID = supplierID;
        NamaProduct = namaProduct;
    }
}
