package com.example.projectbd2.Warehouse;

public class Warehouse {
    int WarehouseID,NomorTelp;
    String NamaWarehouse, alamat;

    public Warehouse(int warehouseID,String namaWarehouse, String alamat, int nomorTelp) {
        WarehouseID = warehouseID;
        NomorTelp = nomorTelp;
        NamaWarehouse = namaWarehouse;
        this.alamat = alamat;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        WarehouseID = warehouseID;
    }

    public int getNomorTelp() {
        return NomorTelp;
    }

    public void setNomorTelp(int nomorTelp) {
        NomorTelp = nomorTelp;
    }

    public String getNamaWarehouse() {
        return NamaWarehouse;
    }

    public void setNamaWarehouse(String namaWarehouse) {
        NamaWarehouse = namaWarehouse;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
