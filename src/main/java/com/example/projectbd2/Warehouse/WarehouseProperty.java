package com.example.projectbd2.Warehouse;

import javafx.beans.property.SimpleStringProperty;

public class WarehouseProperty {
    SimpleStringProperty WarehouseID,NamaWarehouse, alamat, NoTelp;

    public WarehouseProperty() {
        WarehouseID = new SimpleStringProperty(this, "Warehouse ID");
        NamaWarehouse = new SimpleStringProperty(this, "Nama Warehouse");
        alamat = new SimpleStringProperty(this, "Alamat");
        NoTelp = new SimpleStringProperty(this, "Nomor Telepon");
    }

    public String getWarehouseID() {
        return WarehouseID.get();
    }

    public SimpleStringProperty warehouseIDProperty() {
        return WarehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.WarehouseID.set(warehouseID);
    }

    public String getNamaWarehouse() {
        return NamaWarehouse.get();
    }

    public SimpleStringProperty namaWarehouseProperty() {
        return NamaWarehouse;
    }

    public void setNamaWarehouse(String namaWarehouse) {
        this.NamaWarehouse.set(namaWarehouse);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public SimpleStringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public String getNoTelp() {
        return NoTelp.get();
    }

    public SimpleStringProperty noTelpProperty() {
        return NoTelp;
    }

    public void setNoTelp(String noTelp) {
        this.NoTelp.set(noTelp);
    }
}
