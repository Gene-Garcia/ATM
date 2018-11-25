package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Team Lezned
 */
public class ChangePin extends javax.swing.JFrame {

    public ChangePin(Connection con, ResultSet rs) {
        initComponents();
        connect = con;
        this.rsData = rs;
    }

    Connection connect;
    ResultSet rsData;

    public void returnToTransaction() {
        try {
            this.dispose();
            new Transactions(connect, rsData.getInt("CARD_NUMBER")).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean verifyPinLength() {
        if (txtOldPin.getText().length() == 4 && txtPin.getText().length() == 4 && txtVerificationPin.getText().length() == 4) {
            return true;
        }

        JOptionPane.showMessageDialog(null, "Invalid pin(s), minimum and maximum of 4 digits.", "Kaching", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblOld = new javax.swing.JLabel();
        jlblNew = new javax.swing.JLabel();
        jlblNew2 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnEye = new javax.swing.JButton();
        txtOldPin = new javax.swing.JPasswordField();
        txtPin = new javax.swing.JPasswordField();
        txtVerificationPin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblOld.setText("Old PIN:");
        getContentPane().add(jlblOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jlblNew.setText("New PIN:");
        getContentPane().add(jlblNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 85, -1, -1));

        jlblNew2.setText("Re-enter new PIN:");
        getContentPane().add(jlblNew2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 125, -1, -1));

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 175, -1, -1));

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        btnEye.setText("Eye");
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));
        getContentPane().add(txtOldPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 150, -1));
        getContentPane().add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 82, 140, -1));
        getContentPane().add(txtVerificationPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 122, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        int oldPin = Integer.parseInt(String.valueOf(txtOldPin.getPassword()));
        int newPin1 = Integer.parseInt(String.valueOf(txtPin.getPassword()));
        int newPin2 = Integer.parseInt(String.valueOf(txtVerificationPin.getPassword()));

        try {
            int pin = rsData.getInt("PIN");

            if (verifyPinLength()) {
                
                if (newPin1 == newPin2 && pin == oldPin) {

                    rsData.updateInt("PIN", newPin1);
                    rsData.updateRow();
                    JOptionPane.showMessageDialog(null, "Pin succesfully changed.", "Kaching", JOptionPane.INFORMATION_MESSAGE);

                    returnToTransaction();
                    
                } else if (newPin1 != newPin2) {
                    JOptionPane.showMessageDialog(null, "New pin does not match.", "Kaching", JOptionPane.WARNING_MESSAGE);
                } else if (pin != oldPin) {
                    JOptionPane.showMessageDialog(null, "Incorrect old pin.", "Kaching", JOptionPane.WARNING_MESSAGE);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        returnToTransaction();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnEyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEyeActionPerformed
        char echo = txtPin.getEchoChar();

        switch (echo) {
            case '•':
                txtPin.setEchoChar((char) 0);
                txtOldPin.setEchoChar((char) 0);
                txtVerificationPin.setEchoChar((char) 0);
                break;
            default:
                txtPin.setEchoChar('•');
                txtOldPin.setEchoChar('•');
                txtVerificationPin.setEchoChar('•');
        }
    }//GEN-LAST:event_btnEyeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEye;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jlblNew;
    private javax.swing.JLabel jlblNew2;
    private javax.swing.JLabel jlblOld;
    private javax.swing.JPasswordField txtOldPin;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JPasswordField txtVerificationPin;
    // End of variables declaration//GEN-END:variables
}
