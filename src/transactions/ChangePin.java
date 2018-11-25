package transactions;

import java.awt.Dimension;
import java.awt.Toolkit;
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

        pnlButton = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblBackgroundButton = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        jlblOld = new javax.swing.JLabel();
        jlblNew = new javax.swing.JLabel();
        jlblNew2 = new javax.swing.JLabel();
        txtOldPin = new javax.swing.JPasswordField();
        txtPin = new javax.swing.JPasswordField();
        txtVerificationPin = new javax.swing.JPasswordField();
        btnEye = new javax.swing.JButton();
        lblBackgroundInput = new javax.swing.JLabel();
        lblLogoSecond = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change-pin.png"))); // NOI18N
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlButton.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 8, 50, 50));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlButton.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 8, 50, 50));

        lblBackgroundButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change-pin-background.jpg"))); // NOI18N
        pnlButton.add(lblBackgroundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 120, 60));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 125, 65));

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblOld.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jlblOld.setForeground(new java.awt.Color(204, 255, 255));
        jlblOld.setText("Old PIN:");
        pnlInput.add(jlblOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 37));

        jlblNew.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jlblNew.setForeground(new java.awt.Color(204, 255, 255));
        jlblNew.setText("New PIN:");
        pnlInput.add(jlblNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 37));

        jlblNew2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jlblNew2.setForeground(new java.awt.Color(204, 255, 255));
        jlblNew2.setText("Re-enter new PIN:");
        pnlInput.add(jlblNew2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 37));

        txtOldPin.setBackground(new java.awt.Color(201, 235, 249));
        txtOldPin.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtOldPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 261, 37));

        txtPin.setBackground(new java.awt.Color(201, 235, 249));
        txtPin.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 261, 37));

        txtVerificationPin.setBackground(new java.awt.Color(201, 235, 249));
        txtVerificationPin.setForeground(new java.awt.Color(0, 0, 0));
        txtVerificationPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVerificationPinActionPerformed(evt);
            }
        });
        pnlInput.add(txtVerificationPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 261, 37));

        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        pnlInput.add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 168, 50, 50));

        lblBackgroundInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change-pin-background.jpg"))); // NOI18N
        pnlInput.add(lblBackgroundInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 480, 223));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 487, 230));

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 150, 50));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 70));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change-pin-background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 505));

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

    private void txtVerificationPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVerificationPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVerificationPinActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEye;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jlblNew;
    private javax.swing.JLabel jlblNew2;
    private javax.swing.JLabel jlblOld;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundButton;
    private javax.swing.JLabel lblBackgroundInput;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPasswordField txtOldPin;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JPasswordField txtVerificationPin;
    // End of variables declaration//GEN-END:variables
}
