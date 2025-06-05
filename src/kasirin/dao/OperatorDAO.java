/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kasirin.model.Operator;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class OperatorDAO {
    
    Connection conn;

    public OperatorDAO() {        
            try {   
                conn = Koneksi.connect();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.getMessage();
            }        
    }
    
    public void addOperator(Operator operator){
        String query = "USE KASIRIN "
                + "INSERT INTO Operators (OperatorID, OperatorName, OperatorGender) "
                + "VALUES (?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, operator.getOperatorID());
            ps.setString(2, operator.getOperatorName());
            ps.setString(3, operator.getOperatorGender());            
            ps.executeUpdate();
        }catch(SQLException se){
            se.getMessage();
        }
    }
    
    public List<String> getOperatorNames(){
        List<String> itemNames = new ArrayList<>();        
        String query = "USE KASIRIN SELECT * FROM Operators";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                itemNames.add(rs.getString("OperatorName"));
            }
            return itemNames;
        } catch (SQLException e) {
            e.getMessage();
        }
        return itemNames;
    }
    
}
