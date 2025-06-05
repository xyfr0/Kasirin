/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import kasirin.model.Item;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class ItemDAO {

    Connection conn;    

    public ItemDAO() {        
            try {   
                conn = Koneksi.connect();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.getMessage();
            }        
    }

    public void addItem(Item item) {
        String query = "USE KASIRIN "
                + "INSERT INTO Operators (ItemID, ItemName, Stock, Price) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, item.getItemID());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getStock());
            ps.setDouble(4, item.getPrice());
            ps.executeUpdate();
        } catch (SQLException se) {
            se.getMessage();
        }
    }

    public List<Item> getAllItems(){
        List<Item> itemList = new ArrayList<>();
        String query = "USE KASIRIN SELECT * FROM Items";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                itemList.add(new Item(
                        rs.getString("ItemID"),
                        rs.getString("ItemName"),
                        rs.getDouble("Stock"),
                        rs.getInt("Price")));
            }
            return itemList;
        } catch (SQLException e) {
            e.getMessage();
        }
        return itemList;

    }

    public List<String> getItemNames(){
        List<String> itemNames = new ArrayList<>();        
        String query = "USE KASIRIN SELECT * FROM Items";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                itemNames.add(rs.getString("ItemName"));
            }
            return itemNames;
        } catch (SQLException e) {
            e.getMessage();
        }
        return itemNames;
    }

}
