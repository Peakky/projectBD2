package com.example.projectbd2.Product;

import com.example.projectbd2.Pagination;
import com.example.projectbd2.Supplier.Supplier;
import com.example.projectbd2.connection;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {
    private Connection conn;

        public ProductRepository() throws SQLException {
            conn = connection.GetConnection();
        }

        public int GetProductCount() throws SQLException {
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(id) FROM Product";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return rs.getInt(1);
            } else{
                return 0;
            }
        }

        public ArrayList<Product> GetProduct(Pagination pgn) throws SQLException {
            ArrayList<Product> products = new ArrayList<Product>();
            Statement stmt = conn.createStatement();
            String sql = String.format("SELECT * FROM Product LIMIT %o OFFSET %o", pgn.limit,pgn.offset);
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                products.add(
                        new Product(
                                rs.getInt("id Product"),
                                rs.getString("Nama Product"),
                                rs.getInt("Jumlah Product"),
                                rs.getInt("Supplier ID"),
                                rs.getInt("Warehouse ID")
                        )
                );
            }
            return products;
        }

        public void insertData(String Nama, int JumlahProduct, int SupplierID, int WarehouseID) throws SQLException {
            String Query = "INSERT INTO Product (Nama_Product,Jumlah_Product,SupplierID,WarehouseID) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setString(1, Nama);
            preparedStatement.setInt(2, JumlahProduct);
            preparedStatement.setInt(3,SupplierID);
            preparedStatement.setInt(4,WarehouseID);
            System.out.println(preparedStatement);
            preparedStatement.execute();
        }

        public void updateData(int id,String Nama, int JumlahProduct, int SupplierID, int WarehouseID) throws SQLException {
            String Query = "UPDATE Supplier SET ";
            try {

                PreparedStatement preparedStatement = conn.prepareStatement(Query + "Nama_Product = '" + Nama + "' where id = " + id);
                System.out.println(preparedStatement);
                preparedStatement.execute();
                preparedStatement = conn.prepareStatement(Query + "Jumlah_Product = '" + JumlahProduct + "' where id = " + id);
                System.out.println(preparedStatement);
                preparedStatement.execute();
                preparedStatement = conn.prepareStatement(Query + "Supplier_ID = '" + SupplierID + "' where id = " + id);
                System.out.println(preparedStatement);
                preparedStatement.execute();
                preparedStatement = conn.prepareStatement(Query + "Warehouse_ID = '" + WarehouseID + "' where id = " + id);
                System.out.println(preparedStatement);
                preparedStatement.execute();

                System.out.println(preparedStatement);
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        public void deleteData(int id) throws SQLException {
            String Query = "DELETE FROM Product WHERE id = " + id;
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
            String Query = "select * FROM Product WHERE id = " + id;
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
