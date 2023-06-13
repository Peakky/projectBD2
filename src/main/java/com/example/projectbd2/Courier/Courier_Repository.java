package com.example.projectbd2.Courier;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class Courier_Repository {
    private Connection conn;

    public Courier_Repository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetCourierCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(id) FROM courier";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Courier> GetCourier(Pagination pgn) throws SQLException {
        ArrayList<Courier> couriers = new ArrayList<Courier>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM courier LIMIT %o OFFSET %o",pgn.limit,pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            couriers.add(
                    new Courier(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("no hp")
                    )
            );
        }
        return couriers;
    }

    public void insertData(String nama,String no_hp) {
        String Query = "INSERT INTO courier (nama, no_hp) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, no_hp);

            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void updateData(int id, String nama, String no_hp ) {
        String Query = "UPDATE pengguna SET ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(Query + "nama = '" + nama + "' where id = " + id);
            System.out.println(preparedStatement);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(Query + "no hp = '" + no_hp + "' where id = " + id);
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
        String Query = "DELETE FROM courier WHERE id = " + id;
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
        String Query = "select * FROM courier WHERE id = " + id;
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
