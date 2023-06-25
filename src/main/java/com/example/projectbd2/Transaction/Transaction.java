package com.example.projectbd2.Transaction;

public class Transaction {
    int transactionID, nominal,customerID;


    public Transaction(int id,int nominal,int customerID) {
        this.transactionID = id;
        this.nominal = nominal;
        this.customerID= customerID;

    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
