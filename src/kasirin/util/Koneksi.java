/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.util;

import java.sql.*;

/**
 *
 * @author jabba
 */
public class Koneksi {

    Connection con = null;

    public static Connection connect() throws SQLException, ClassNotFoundException {        
        String connectionUrl = "jdbc:sqlserver://Tenma:1691;databaseName=KASIRIN;encrypt=true;trustServerCertificate=true;user=irhamjab;password=basdatOke123;";
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }

    public Connection getCon() {
        return con;
    }
    
    
}
