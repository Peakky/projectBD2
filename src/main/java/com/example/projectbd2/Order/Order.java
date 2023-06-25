package com.example.projectbd2.Order;

public class Order {
    int orderID,transactionID;
    String Tanggal_Delivery;

    public Order(int id, String Tanggal,int transactionID) {
        this.orderID = id;
        this.Tanggal_Delivery= Tanggal;
        this.transactionID=transactionID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getTanggal_Delivery() {
        return Tanggal_Delivery;
    }

    public void setTanggal_Delivery(String tanggal_Delivery) {
        Tanggal_Delivery = tanggal_Delivery;
    }
}
