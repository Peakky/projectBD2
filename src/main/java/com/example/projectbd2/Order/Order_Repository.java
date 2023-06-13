package com.example.projectbd2.Order;

import com.example.projectbd2.Delivery.Delivery;
import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class Order_Repository {
    private Connection conn;

    public Order_Repository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetOrderCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(id) FROM order";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Order> GetOrder(Pagination pgn) throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM order LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            orders.add(
                    new Order(
                            rs.getInt("id"),
                            rs.getString("Tanggal")
                    )
            );
        }
        return orders;
    }

    public void insertData(String Tanggal) {
        String Query = "INSERT INTO order (Tanggal) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setString(1, Tanggal);

            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void updateData(int id, String Tanggal) {
        String Query = "UPDATE order SET ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query + "Tanggal = '" + Tanggal + "' where id = " + id);
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
        String Query = "DELETE FROM order WHERE id = " + id;
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
        String Query = "select * FROM order WHERE id = " + id;
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