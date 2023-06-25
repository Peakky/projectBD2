package com.example.projectbd2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;

public class connection {
    private static Connection conn;

    private static Connection Connect() throws SQLException {
        String dbName = "proyekbd";
        String dbUrl = "jdbc:mysql://localhost:3306/Delivery" ;
        String dbUser = "root";
        String dbPassword = "";
        Connection dbLink = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return dbLink;
    }

    public static Connection GetConnection() throws SQLException {
        if (conn != null) {
            return conn;
        } else {
            conn = Connect();
            return conn;
        }
    }
}