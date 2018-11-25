package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Team Lezned
 */
public class Deposit extends javax.swing.JFrame {

    public Deposit(Connection con, ResultSet rs) {
        initComponents();
        this.connect = con;
        this.rsData = rs;
    }

    Connection connect;
    ResultSet rsData;

    final int MINIMUM_DEPOSIT_AMOUNT = 100;
    final int MAXIMUM_DEPOSIT_AMOUNT = 200000;

    public boolean verifyDepositAmount(double depositAmount) {
        if (depositAmount >= MINIMUM_DEPOSIT_AMOUNT && depositAmount <= MAXIMUM_DEPOSIT_AMOUNT) {

            return true;
        } else if (depositAmount <= MINIMUM_DEPOSIT_AMOUNT) {
            JOptionPane.showMessageDialog(null, "Less than the Minimum Withdrawal Limit Please Try Again");
        } else if (depositAmount > MAXIMUM_DEPOSIT_AMOUNT) {
            JOptionPane.showMessageDialog(null, "Exceeded the Maximum Deposit Limit Please Try Again.");
        }

        return false;
    }

    public void returnToTransaction() {
        try {
            this.dispose();
            new Transactions(connect, rsData.getInt("CARD_NUMBER")).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblPIN = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        jlblAmount = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        txtPin = new javax.swing.JPasswordField();
        btnEye = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPIN.setText("PIN:");
        getContentPane().add(jlblPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 139, -1, -1));
        getContentPane().add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 70, 164, -1));

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 222, -1, -1));

        jlblAmount.setText("Deposit Amount:");
        getContentPane().add(jlblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 73, -1, -1));

        btnReturn.setText("Cancel");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 222, -1, -1));
        getContentPane().add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 136, 149, -1));

        btnEye.setText("Eye");
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {

            double depositValue = Double.parseDouble(txtAmount.getText());
            int inputPin = Integer.parseInt(String.valueOf(txtPin.getPassword()));

            int pin = rsData.getInt("PIN");

            if (txtPin.getText().length() == 4) {
                
                if (inputPin == pin) {

                    if (verifyDepositAmount(depositValue)) {

                        double currBal = rsData.getDouble("OUTSTANDING_BALANCE");
                        double newBal = currBal + depositValue;

                        rsData.updateDouble("OUTSTANDING_BALANCE", newBal);
                        rsData.updateRow();
                        JOptionPane.showMessageDialog(null, "Transaction Complete");

                        returnToTransaction();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect pin Please Try Again");
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
                break;
            default:
                txtPin.setEchoChar('•');
        }
    }//GEN-LAST:event_btnEyeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEye;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jlblAmount;
    private javax.swing.JLabel jlblPIN;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
