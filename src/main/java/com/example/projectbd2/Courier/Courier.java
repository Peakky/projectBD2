package com.example.projectbd2.Courier;

public class Courier {
    int courierID;
    String nama,no_telp;

    public Courier(int id, String nama, String no_telp) {
        this.courierID = id;
        this.nama = nama;
        this.no_telp = no_telp;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
