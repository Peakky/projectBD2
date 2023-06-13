package com.example.projectbd2.Transaction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction_Property {
    private final StringProperty id;

    private final StringProperty nominal;

    public Transaction_Property(){
        id = new SimpleStringProperty(this, "id");
        nominal = new SimpleStringProperty(this, "nominal");

    }

    public StringProperty idTransaction(){return id;}
    public String getId(){return idTransaction().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty NominalTransaction(){return nominal;}
    public String getNominal(){return NominalTransaction().get();}
    public void setNominal(String newNominal){nominal.set(newNominal);}


}
