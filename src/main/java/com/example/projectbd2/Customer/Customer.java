package com.example.projectbd2.Customer;

public class Customer {
    int customerID;
    String nama, email,no_hp;

    public Customer(int id, String nama, String email,String no_hp) {
        this.customerID = id;
        this.nama = nama;
        this.email = email;
        this.no_hp=no_hp;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNo_hp() {
        return no_hp;
    }
}
