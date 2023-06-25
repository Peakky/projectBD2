package com.example.projectbd2.Delivery;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class Delivery_Repository {
    private Connection conn;

    public Delivery_Repository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetDeliveryCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(id) FROM delivery";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Delivery> GetDelivery(Pagination pgn) throws SQLException {
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM delivery LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            deliveries.add(
                    new Delivery(
                            rs.getInt("id"),
                            rs.getString("Tanggal"),
                            rs.getInt("Courier ID")
                    )
            );
        }
        return deliveries;
    }

    public void insertData(String Tanggal, int CourierID) {
        String Query = "INSERT INTO delivery (Tanggal, CourierID) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setString(1, Tanggal);
            preparedStatement.setInt(2, CourierID);

            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void updateData(int id, String Tanggal, int CourierID) {
        String Query = "UPDATE delivery SET ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query + "Tanggal = '" + Tanggal + "' where id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(Query + "CourierID = '" + CourierID  + "' where id = " + id);
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
        String Query = "DELETE FROM delivery WHERE id = " + id;
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
        String Query = "select * FROM delivery WHERE id = " + id;
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
