package com.example.projectbd2.Transaction;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class Transaction_Repository {
    private Connection conn;

    public Transaction_Repository() throws SQLException {
        conn = connection.GetConnection();
    }

    public int GetTransactionCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(Transaction_id) FROM transaction";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }

    public ArrayList<Transaction> GetTransaction(Pagination pgn) throws SQLException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM transaction LIMIT %o OFFSET %o", pgn.limit,pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            transactions.add(
                    new Transaction(
                            rs.getInt("Transaction_id"),
                            rs.getInt("Price"),
                            rs.getInt("Customer_id")
                    )
            );
        }
        return transactions;
    }

    public void insertData(int nominal) throws SQLException {
        String Query = "INSERT INTO transaction (Price) VALUES (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(Query);

        preparedStatement.setString(1, Integer.toString(nominal));

        System.out.println(preparedStatement);
        preparedStatement.execute();
    }

    public void updateData(int id,int nominal) throws SQLException {
        String Query = "UPDATE transaction SET ";
        PreparedStatement preparedStatement = conn.prepareStatement(Query + "Price = '" + nominal + "' where Transaction_id = " + id);
        System.out.println(preparedStatement);
        preparedStatement.execute();

    }
    public void deleteData(int id) throws SQLException {
        String Query = "DELETE FROM transaction WHERE Transaction_id = " + id;
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
        String Query = "select * FROM transaction WHERE Transaction_id = " + id;
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
