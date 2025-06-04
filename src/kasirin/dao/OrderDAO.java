/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import kasirin.util.Koneksi;
import java.sql.*;
import java.time.LocalDateTime;
import kasirin.model.Order;

/**
 *
 * @author jabba
 */
public class OrderDAO {

    Connection conn;

    public OrderDAO() throws SQLException, ClassNotFoundException {
        conn = Koneksi.connect();
    }
    
    public void addOrder(Order order){
        String query = "USE KASIRIN "
                + "INSERT INTO Orders (OrderId, CustomerName, OrderDate, OrderTotal) "
                + "VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, order.getOrderID());
            ps.setString(2, order.getCustomerName());
            ps.setObject(3, order.getOrderDate());
            ps.setInt(4, order.getOrderTotal());
            ps.executeUpdate();
        }catch(SQLException se){
            se.getMessage();              
        }
    }

}
