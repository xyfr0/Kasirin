/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.db;

import java.sql.*;
import java.util.Date;

/**
 *
 * @author jabba
 */
public class CRUDRecord {
    Koneksi koneksi = new Koneksi();

    private String SQL_QUERY = "USE KASIRIN ";

    public void insertTransaction(int transactionID, double amount, Date transactionDate, String transactionType, String description) {

        try (Connection conn = koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY
                + "INSERT INTO Transactions (TransactionID, Order, , TransactionType, Description) "
                + "VALUES (?, ?, ?, ?, ?);"
        )) {
            ps.setInt(1, transactionID);
            ps.setDouble(2, amount);
            ps.setDate(3, new java.sql.Date(transactionDate.getTime()));
            ps.setString(4, transactionType);
            ps.setString(5, description);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }

    public void deleteTransaction(int transactionID) {
        try (Connection conn = koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY 
                + "DELETE FROM Transactions WHERE TransactionID = ?")) {
            ps.setInt(1, transactionID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }

}
