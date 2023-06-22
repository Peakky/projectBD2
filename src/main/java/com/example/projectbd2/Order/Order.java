package com.example.projectbd2.Order;

public class Order {
    int orderID,transactionID;
    String Tanggal_Delivery;

    public Order(int id, String Tanggal,int transactionID) {
        this.orderID = id;
        this.Tanggal_Delivery= Tanggal;
        this.transactionID=transactionID;
    }
}
