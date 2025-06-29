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
public class Operator {
    private String operatorID;
    private String operatorName;
    private String operatorGender;
    private String status;
    private String password;
    private String role;
    private String username;
    private LocalDate registered_at;
    private LocalTime updated_at;

    public Operator(String operatorID, String operatorName, String operatorGender) {
        this.operatorID = operatorID;
        this.operatorName = operatorName;
        this.operatorGender = operatorGender;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorGender() {
        return operatorGender;
    }

    public void setOperatorGender(String operatorGender) {
        this.operatorGender = operatorGender;
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

    public LocalTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalTime updated_at) {
        this.updated_at = updated_at;
    }
    
    
    
    public void addOperator(Operator operator){
        if (isIdAvailable(operator.getOperatorID())) {
            try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN INSERT INTO Operator "
                    + "(operator_id, operator_name, operator_gender, status, password, role, username, registered_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {                
                ps.setString(1, operator.getOperatorID());
                ps.setString(2, operator.getOperatorName());
                ps.setString(3, operator.getOperatorGender());
                ps.setString(4, operator.getStatus());
                ps.setString(5, operator.getPassword());
                ps.setString(6, operator.getRole());
                ps.setString(7, operator.getUsername());
                ps.setObject(8, operator.getRegistered_at());
                ps.setObject(9, operator.getUpdated_at());
                ps.executeUpdate();
            }catch( SQLException | ClassNotFoundException sce){
                sce.getMessage();
            }
        }
    }

    public boolean isIdAvailable(String id) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN "
                + "SELECT COUNT(*) FROM Operator WHERE shift_id = ?")) {
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
        try (PreparedStatement ps = conn.prepareStatement("SELECT MAX(operator_id) FROM Operator WHERE operator_id LIKE 'O%'"); ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getString(1) != null) {
                int num = Integer.parseInt(rs.getString(1).substring(1));
                return String.format("O%04d", num + 1);
            }
            return "O0001";
        }
    }
    
}
