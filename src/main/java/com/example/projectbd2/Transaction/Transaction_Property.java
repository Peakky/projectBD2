package com.example.projectbd2.Transaction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction_Property {
    private final StringProperty id;

    private final StringProperty nominal;
    private final StringProperty CustomerID;

    public Transaction_Property(){
        id = new SimpleStringProperty(this, "id");
        nominal = new SimpleStringProperty(this, "nominal");
        CustomerID = new SimpleStringProperty(this, "Customer ID");
    }

    public String getCustomerID() {
        return CustomerID.get();
    }

    public StringProperty customerIDProperty() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        this.CustomerID.set(customerID);
    }


    public StringProperty idTransaction(){return id;}
    public String getId(){return idTransaction().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty NominalTransaction(){return nominal;}
    public String getNominal(){return NominalTransaction().get();}
    public void setNominal(String newNominal){nominal.set(newNominal);}


}
