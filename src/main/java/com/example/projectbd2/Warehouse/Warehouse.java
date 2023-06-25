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
}
