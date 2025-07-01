/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

import java.sql.*;
import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;
import kasirin.gui.shift.FormShift;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class Shift {

    private String shift_id;    
    private LocalTime start_time;
    private LocalTime end_time;

    public Shift(LocalTime start_time, LocalTime end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Shift() {
    }
    
    
    
    

    public String getShift_id() {
        return shift_id;
    }

    public void setShift_id(String shift_id) {
        this.shift_id = shift_id;
    }   

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public void addShift(Shift shift, Connection conn) throws SQLException{
        String sql = "{call InsertShift(?, ?)}";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, shift.getStart_time());
            ps.setObject(2, shift.getEnd_time());
            ps.executeUpdate();
        }
    }
    
    public void readShiftTable(){
        DefaultTableModel dtm = (DefaultTableModel) FormShift.getShiftTable().getModel();
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN SELECT * FROM Shifts")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int n = 1;
                String startShiftTime = rs.getTime("shift_start").toString().substring(0, 5);
                String endShiftTime = rs.getTime("shift_start").toString().substring(0, 5);                                
                String shiftTime = startShiftTime + " - " + endShiftTime;
                dtm.addRow(new Object[]{n, shiftTime});
                n++;
            }
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }

    }
}
