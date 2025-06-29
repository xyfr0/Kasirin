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
import java.time.LocalTime;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class User {
    private String userID;
    private String fullname;    
    private String status;
    private String username;
    private String password;
    private String role;    
    private LocalDate registered_at;
    private LocalDate updated_at;


    public User() {
    }
    
    

    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String operatorID) {
        this.userID = operatorID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(LocalDate registered_at) {
        this.registered_at = registered_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
    
    
    
    public void addUser(User user){
        if (isIdAvailable(user.getUserID())) {
            try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN INSERT INTO Operator "
                    + "(operator_id, operator_name, operator_gender, status, password, role, username, registered_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {                
                ps.setString(1, user.getUserID());
                ps.setString(2, user.getFullname());                
                ps.setString(4, user.getStatus());
                ps.setString(5, user.getPassword());
                ps.setString(6, user.getRole());
                ps.setString(7, user.getUsername());
                ps.setObject(8, user.getRegistered_at());
                ps.setObject(9, user.getUpdated_at());
                ps.executeUpdate();
            }catch( SQLException | ClassNotFoundException sce){
                sce.getMessage();
            }
        }
    }

    public boolean isIdAvailable(String id) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN "
                + "SELECT COUNT(*) FROM Operator WHERE user_id = ?")) {
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

    public String generateOperatorId(Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT MAX(user_id) FROM Users WHERE user_id LIKE 'U%'"); ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getString(1) != null) {
                int num = Integer.parseInt(rs.getString(1).substring(1));
                return String.format("U%04d", num + 1);
            }
            return "U0001";
        }
    }
    
}
