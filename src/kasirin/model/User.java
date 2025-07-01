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
    private String username;
    private String password;    
    private String fullname;
    private LocalDate registered_at;    

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        
    }
   
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    
    
    
    public void addUser(User user, Connection conn, String selectedRole, LocalTime startShift) throws SQLException{
        String sql = "USE KASIRIN EXEC InsertUser @username=?, @password=?, @fullname=?, @selectedRole=?, @startShift=?";        
        try (PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, selectedRole);
            ps.setObject(5, startShift);
            ps.executeUpdate();
        }
    }
    
    
    
}
