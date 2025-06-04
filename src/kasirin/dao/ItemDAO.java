/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kasirin.model.Item;
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
    
    public void addOperator(Item item){
        String query = "USE KASIRIN "
                + "INSERT INTO Operators (ItemID, ItemName, Stock, Price) "
                + "VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, item.getItemID());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getStock());            
            ps.setDouble(4, item.getPrice());
            ps.executeUpdate();
        }catch(SQLException se){
            se.getMessage();
        }
    }
    
}
