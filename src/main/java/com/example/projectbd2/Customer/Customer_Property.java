package com.example.projectbd2.Customer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer_Property {
    private final StringProperty id;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty no_hp;


    public Customer_Property(){
        id = new SimpleStringProperty(this, "Customer_id");
        nama = new SimpleStringProperty(this, "nama");
        email = new SimpleStringProperty(this, "E-mail");
        no_hp = new SimpleStringProperty(this, "No_HP");
    }

    public StringProperty   Id_Customer(){return id;}
    public String getId(){return Id_Customer().get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty NamaCustomer(){return nama;}
    public String getNama(){return NamaCustomer().get();}
    public void setNama(String newNama){nama.set(newNama);}

    public StringProperty EmailCustomer(){return email;}
    public String getEmail(){return EmailCustomer().get();}
    public void setEmail(String newEmail){email.set(newEmail);}

    public StringProperty NumberCustomer(){return no_hp;}
    public String getNumber(){return NumberCustomer().get();}
    public void setNumber(String newNumber){no_hp.set(newNumber);}


}
