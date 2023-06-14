package com.example.projectbd2.Warehouse;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class WarehouseRepository {
    private Connection conn;

    public WarehouseRepository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetWarehouseCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(id) FROM Warehouse";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Warehouse> GetWarehouse(Pagination pgn) throws SQLException {
        ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM Warehouse LIMIT %o OFFSET %o", pgn.limit,pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            warehouses.add(
                    new Warehouse(
                            rs.getInt("Warehouse ID"),
                            rs.getString("Nama Warehouse"),
                            rs.getInt("Nomor Telepon")
                    )
            );
        }
        return warehouses;
    }

    public void insertData( String Nama,int NomorTelp) throws SQLException {
        String Query = "INSERT INTO Product (Nama_Warehouse,Nomor_Telepon) VALUES (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(Query);
        preparedStatement.setString(1, Nama);
        preparedStatement.setInt(2, NomorTelp);
        System.out.println(preparedStatement);
        preparedStatement.execute();
    }

    public void updateData(int id,String Nama, int NomorTelepon) throws SQLException {
        String Query = "UPDATE Supplier SET ";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(Query + "Nama_Product = '" + Nama + "' where id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(Query + "Nomor_Telepon = '" + NomorTelepon + "' where id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();

            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deleteData(int id) throws SQLException {
        String Query = "DELETE FROM Warehouse WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public boolean cekId(int id) throws SQLException {
        String Query = "select * FROM Warehouse WHERE id = " + id;
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
