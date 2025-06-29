/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class Product {
    private String productId;
    private String productName;
    private int stock;
    private double price;
    private LocalDate registerDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
    
    public void addProduct(Product product){
        if (isIdAvailable(product.getProductId())) {
            try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN INSERT INTO Product "
                    + "(product_id, product_name, stock, price, register_date) VALUES (?, ?, ?, ?, ?)")) {                
                ps.setString(1, product.getProductId());
                ps.setString(stock, product.getProductName());
                ps.setInt(3, product.getStock());
                ps.setDouble(4, product.getPrice());
                ps.setObject(5, product.getRegisterDate());

                ps.executeUpdate();
            }catch( SQLException | ClassNotFoundException sce){
                sce.getMessage();
            }
        }
    }
    
    public boolean isIdAvailable(String id) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN "
                + "SELECT COUNT(*) FROM Product WHERE product_id = ?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 0;
            }
        } catch (SQLException | ClassNotFoundException sce) {
            sce.getMessage();
        }
        return false;
    }
    
    public String generateProductId(Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT MAX(operator_id) FROM Operator WHERE operator_id LIKE 'P%'"); ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getString(1) != null) {
                int num = Integer.parseInt(rs.getString(1).substring(1));
                return String.format("O%04d", num + 1);
            }
            return "P0001";
        }
    }   
    
    
}
