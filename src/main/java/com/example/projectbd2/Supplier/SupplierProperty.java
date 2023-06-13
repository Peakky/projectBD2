package com.example.projectbd2.Supplier;

import javafx.beans.property.SimpleStringProperty;

public class SupplierProperty {
    private SimpleStringProperty idSup;
    private SimpleStringProperty NamaSup, NoTelp;

    public SupplierProperty() {
        idSup = new SimpleStringProperty(this, "id");
        NamaSup = new SimpleStringProperty(this, "Nama Supplier");
        NoTelp = new SimpleStringProperty(this, "No Telepon");
    }

    public String getIdSup() {
        return idSup.get();
    }

    public SimpleStringProperty idSupProperty() {
        return idSup;
    }

    public void setIdSup(String idSup) {
        this.idSup.set(idSup);
    }

    public String getNamaSup() {
        return NamaSup.get();
    }

    public SimpleStringProperty namaSupProperty() {
        return NamaSup;
    }

    public void setNamaSup(String namaSup) {
        this.NamaSup.set(namaSup);
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
