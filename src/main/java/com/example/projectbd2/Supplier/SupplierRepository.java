package com.example.projectbd2.Supplier;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class SupplierRepository {
    private Connection conn;

    public SupplierRepository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetSupplierCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(id) FROM supplier";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Supplier> GetSupplier(Pagination pgn) throws SQLException {
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM Supplier LIMIT %o OFFSET %o", pgn.limit,pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            suppliers.add(
                    new Supplier(
                            rs.getInt("id"),
                            rs.getString("Nama"),
                            rs.getInt("No Telepon")
                    )
            );
        }
        return suppliers;
    }

    public void insertData(String Nama, int NomorTelp) throws SQLException {
        String Query = "INSERT INTO Supplier (Nama,Nomor_Telepon) VALUES (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(Query);
        preparedStatement.setString(1, Nama);
        preparedStatement.setInt(2, NomorTelp);
        System.out.println(preparedStatement);
        preparedStatement.execute();
    }

    public void updateData(int id,String Nama, int Nomor_Telepon) throws SQLException {
        String Query = "UPDATE Supplier SET ";
        PreparedStatement preparedStatement = conn.prepareStatement(Query + "Nama = '" + Nama + "' where id = " + id );
        System.out.println(preparedStatement);
        preparedStatement.execute();
        preparedStatement = conn.prepareStatement(Query + "No_Telepon = '" + Nomor_Telepon  + "' where id = " + id);
        System.out.println(preparedStatement);
        preparedStatement.execute();
    }
    public void deleteData(int id) throws SQLException {
        String Query = "DELETE FROM Supplier WHERE id = " + id;
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
        String Query = "select * FROM Supplier WHERE id = " + id;
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
