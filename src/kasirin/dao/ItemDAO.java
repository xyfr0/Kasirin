/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class ItemDAO {
    
    Connection conn;

    public ItemDAO() throws SQLException, ClassNotFoundException {
        conn = Koneksi.connect();
    }
    
    public void addOperator(String itemID, String itemName, int stock, double price){
        String query = "USE KASIRIN "
                + "INSERT INTO Operators (ItemID, ItemName, Stock, Price) "
                + "VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, itemID);
            ps.setString(2, itemName);
            ps.setInt(3, stock);            
            ps.setDouble(4, price);
            ps.executeUpdate();
        }catch(SQLException se){
            se.getMessage();
        }
    }
    
}
