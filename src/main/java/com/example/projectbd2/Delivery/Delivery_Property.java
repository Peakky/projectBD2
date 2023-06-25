package com.example.projectbd2.Delivery;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Delivery_Property {
    private final StringProperty id;
    private final StringProperty Tanggal_Delivery;
    private final StringProperty CourierID;


    public Delivery_Property() {
        id = new SimpleStringProperty(this,"Delivery_id");
        Tanggal_Delivery = new SimpleStringProperty(this, "Tanggal_delivery");
        CourierID= new SimpleStringProperty(this,"Courier_ID");
    }

    public String getCourierID() {
        return CourierID.get();
    }

    public StringProperty courierIDProperty() {
        return CourierID;
    }

    public void setCourierID(String courierID) {
        this.CourierID.set(courierID);
    }

    public StringProperty IdDelivery(){return id;}
    public String getId(){return IdDelivery().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty TanggalDelivery(){return Tanggal_Delivery;}
    public String getTanggal(){return TanggalDelivery().get();}
    public void setTanggal_Delivery(String Tanggal){Tanggal_Delivery.set(Tanggal);}


}
