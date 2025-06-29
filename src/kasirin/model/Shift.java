/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

import java.sql.*;
import java.time.LocalTime;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class Shift {

    private String shift_id;
    private String day;
    private LocalTime start_time;
    private LocalTime end_time;

    public String getShift_id() {
        return shift_id;
    }

    public void setShift_id(String shift_id) {
        this.shift_id = shift_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public void addShift(Shift shift) {
        if (isIdAvailable(shift.getShift_id())) {
            try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN INSERT INTO Shift (shift_id, day, start_time, end_time) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, shift.getShift_id());
                ps.setObject(2, shift.getDay());
                ps.setObject(3, shift.getStart_time());
                ps.setObject(4, shift.getEnd_time());
                ps.executeUpdate();
            } catch (SQLException | ClassNotFoundException sce) {
                sce.printStackTrace();
            }
        }
    }

    public boolean isIdAvailable(String id) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement("USE KASIRIN "
                + "SELECT COUNT(*) FROM Shift WHERE shift_id = ?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 0;
            }
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
        return false;
    }

    public String generateShiftId(Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT MAX(operator_id) FROM Operator WHERE operator_id LIKE 'S%'"); ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getString(1) != null) {
                int num = Integer.parseInt(rs.getString(1).substring(1));
                return String.format("S%04d", num + 1);
            }
            return "S0001";
        }
    }
}
