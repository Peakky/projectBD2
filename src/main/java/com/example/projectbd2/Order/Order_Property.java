package com.example.projectbd2.Order;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order_Property {
    private final StringProperty id;
    private final StringProperty Tanggal_Order;


    public Order_Property() {
        id = new SimpleStringProperty(this, "id");
        Tanggal_Order = new SimpleStringProperty(this, "Tanggal");

    }

    public StringProperty IdOrder(){return id;}
    public String getId(){return IdOrder().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty TanggalOrder(){return Tanggal_Order;}
    public String getTanggal(){return TanggalOrder().get();}
    public void setTanggal_Order(String Tanggal){
        Tanggal_Order.set(Tanggal);}
}
