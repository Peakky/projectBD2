package com.example.projectbd2.Supplier;

public class Supplier {
    int id;
    String namaSup;
    int NoTelp;

    public Supplier(int id, String namaSup, int noTelp) {
        this.id = id;
        this.namaSup = namaSup;
        NoTelp = noTelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaSup() {
        return namaSup;
    }

    public void setNamaSup(String namaSup) {
        this.namaSup = namaSup;
    }

    public int getNoTelp() {
        return NoTelp;
    }

    public void setNoTelp(int noTelp) {
        NoTelp = noTelp;
    }
}
