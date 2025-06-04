/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import java.sql.*;
import java.time.LocalDateTime;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class TransactionDAO {

    Connection conn;

    public TransactionDAO() throws SQLException, ClassNotFoundException {
        conn = Koneksi.connect();
    }

    public void addTransaction(String transactionID, LocalDateTime transactionDate, double income, double total) {
        String query = "USE KASIRIN "
                + "INSERT INTO Transactions (TransactionID, TransactionDate, income, total) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, transactionID);
            ps.setObject(2, transactionDate);
            ps.setDouble(3, income);
            ps.setDouble(4, total);
            ps.executeUpdate();
        } catch (SQLException se) {
            se.getMessage();
        }
    }

}
