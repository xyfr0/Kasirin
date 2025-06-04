/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.dao;

import kasirin.util.Koneksi;
import java.sql.*;

/**
 *
 * @author jabba
 */
public class OrderDAO {    
    Connection conn;
    
    public OrderDAO() throws SQLException, ClassNotFoundException{
        conn = DriverManager.getConnection("jdbc:sqlserver://Tenma:1691;databaseName=KASIRIN;encrypt=true;trustServerCertificate=true;user=irhamjab;password=basdatOke123;");
    }
    
    
    
    
    
}
