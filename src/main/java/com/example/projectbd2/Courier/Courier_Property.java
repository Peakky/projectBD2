package com.example.projectbd2.Courier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Courier_Property {
    private final StringProperty id;
    private final StringProperty nama;
    private final StringProperty no_telp;


    public Courier_Property(){
        id = new SimpleStringProperty(this, "id");
        nama = new SimpleStringProperty(this, "nama");
        no_telp = new SimpleStringProperty(this, "no hp");
    }

    public StringProperty IdCourier(){return id;}
    public String getId(){return IdCourier().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty NamaCourier(){return nama;}
    public String getNama(){return NamaCourier().get();}
    public void setNama(String newNama){nama.set(newNama);}

    public StringProperty no_Courier(){return no_telp;}
    public String getNo_telp(){return no_Courier().get();}
    public void setNo_telp(String newEmail){
        no_telp.set(newEmail);}


}
