/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

import java.sql.*;

/**
 *
 * @author jabba
 */
public class Role {

    private String roleID;
    private String roleName;

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void addRole(Role role, Connection conn) throws SQLException {

        String sql = "USE KASIRIN EXEC InsertRole @role_name=?";
        try (PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setString(1, role.getRoleName());
            ps.executeUpdate();
        }
    }
    
    public void deleteRole(Role role, Connection conn) throws SQLException{
        String sql = "USE KASIRIN DELETE Roles WHERE role_name=?";
        try (PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setString(1, role.getRoleName());
            ps.executeUpdate();
        }
    }

}
