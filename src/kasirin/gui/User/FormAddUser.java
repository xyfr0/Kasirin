/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasirin.gui.User;

import javax.swing.JOptionPane;
import kasirin.model.User;
import java.sql.*;
import java.time.LocalTime;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import kasirin.model.User;
import kasirin.util.Koneksi;

/**
 *
 * @author jabba
 */
public class FormAddUser extends javax.swing.JFrame {
    

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAddUser.class.getName());       
    

    /**
     * Creates new form FormAddOperator
     */
    public FormAddUser() {
        initComponents();
        
        try(Connection conn = Koneksi.connect()){
            String roleQuery = "SELECT role_name FROM Roles";
            PreparedStatement ps = conn.prepareStatement(roleQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                roleSelect.addItem(rs.getString("role_name"));
            }
        } catch (SQLException ex) {
            System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try(Connection conn = Koneksi.connect()){
            String shiftQuery = "SELECT CONCAT(FORMAT(shift_start, N'hh\\:mm'), ' - ', FORMAT(shift_end, N'hh\\:mm')) AS ShiftTime FROM Shifts";
            PreparedStatement ps = conn.prepareStatement(shiftQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                shiftSelect.addItem(rs.getString("ShiftTime"));
            }
        } catch (SQLException ex) {
            System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void emptyField() {
        nameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        roleSelect.setSelectedIndex(0);
        shiftSelect.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addOperatorButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        passwordField = new javax.swing.JTextField();
        roleSelect = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        shiftSelect = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jTextField4.setText(" ");

        jLabel2.setText("Nama Lengkap");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        addOperatorButton.setText("Add");
        addOperatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOperatorButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.setToolTipText("");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        roleSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel7.setText("Role");

        jLabel8.setText("Shift");

        shiftSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                        .addComponent(addOperatorButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clearButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(closeButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameField)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(shiftSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roleSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField)
                            .addComponent(usernameField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(shiftSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOperatorButton)
                    .addComponent(clearButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        emptyField();

    }//GEN-LAST:event_clearButtonActionPerformed

    private void addOperatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOperatorButtonActionPerformed
        if (nameField.getText().equalsIgnoreCase("") || usernameField.getText().equalsIgnoreCase("") || passwordField.getText().equalsIgnoreCase("") || roleSelect.getSelectedItem().equals(" ")) {
            JOptionPane.showMessageDialog(this, "Pastikan memasukkan seluruh data");
        } else {
            try {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String fullname = nameField.getText();
                String selectRole = roleSelect.getSelectedItem().toString();
                LocalTime selectShift = LocalTime.parse(shiftSelect.getSelectedItem().toString().substring(0, 5));
                System.out.println(selectShift);
                User userInput = new User(username, password, fullname);
                
                userInput.addUser(userInput, Koneksi.connect(), selectRole, selectShift);
                
                JOptionPane.showMessageDialog(this, "Register Success!");
                emptyField();
            } catch (SQLException ex) {
                System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (ClassNotFoundException ex) {
                System.getLogger(FormAddUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }//GEN-LAST:event_addOperatorButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    /**
     *
     * @param conn
     * @return
     */
    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormAddUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOperatorButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JComboBox<String> roleSelect;
    private javax.swing.JComboBox<String> shiftSelect;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
