package com.example.projectbd2.Customer;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class Customer_Repository {
    private Connection conn;

    public Customer_Repository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetCustomerCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(Customer_id) FROM customer";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Customer> GetCustomer(Pagination pgn) throws SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM customer LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            customers.add(
                    new Customer(
                            rs.getInt("customer_id"),
                            rs.getString("nama"),
                            rs.getString("E_mail"),
                            rs.getString("no_hp")
                    )
            );
        }
        return customers;
    }

    public void insertData(String nama, String email, String number) {
        String Query = "INSERT INTO customer (nama,E_mail, No_hp) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, number);


            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void updateData(int id, String nama, String email,String number) {
        String Query = "UPDATE Customer SET ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query + "nama = '" + nama + "' where Customer_id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(Query + "E_mail = '" + email + "' where Customer_id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(Query + "no_hp = '" + number + "' where Customer_id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();


            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public void deleteData(int id){
        String Query = "DELETE FROM customer WHERE Customer_id = " + id;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public boolean cekId(int id){
        String Query = "select * FROM customer WHERE Customer_id = " + id;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
