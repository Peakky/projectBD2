package com.example.projectbd2.Delivery;

public class Delivery {
    int deliveryID,courierID;
    String Tanggal_Delivery;

    public Delivery(int id, String Tanggal,int courierID) {
        this.deliveryID = id;
        this.Tanggal_Delivery= Tanggal;
        this.courierID=courierID;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public int getCourierID() {
        return courierID;
    }

    public String getTanggal_Delivery() {
        return Tanggal_Delivery;
    }
}
