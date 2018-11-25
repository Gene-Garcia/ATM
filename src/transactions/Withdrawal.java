package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Team Lezned
 */
public class Withdrawal extends javax.swing.JFrame {

    public Withdrawal(Connection con, ResultSet rs) {
        initComponents();
        connect = con;
        this.rsData = rs;
    }

    Connection connect;
    ResultSet rsData;

    final int MAXIMUM_AMOUNT_WITHDRAWABLE = 10000;
    final int MINIMUM_WITHDRAWABLE_AMOUT = 200;

    public boolean checkWithdrawableAmount(double withdrawAmount) {
        if (withdrawAmount >= MINIMUM_WITHDRAWABLE_AMOUT && withdrawAmount <= MAXIMUM_AMOUNT_WITHDRAWABLE) {

            return true;

        } else if (withdrawAmount < MINIMUM_WITHDRAWABLE_AMOUT) {
            JOptionPane.showMessageDialog(null, "Less than withdrawal limit.");
        } else if (withdrawAmount > MAXIMUM_AMOUNT_WITHDRAWABLE) {
            JOptionPane.showMessageDialog(null, "Exceeded the maximum withdrawal limit.");
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

        btnConfirm = new javax.swing.JButton();
        lblWithdraw = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        txtAmount = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        btnEye = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(445, 243));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 222, -1, -1));

        lblWithdraw.setText("Amount to be Withdrawn:");
        getContentPane().add(lblWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        lblPin.setText("PIN:");
        getContentPane().add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 139, -1, -1));
        getContentPane().add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 136, 164, -1));
        getContentPane().add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 70, 164, -1));

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 222, -1, -1));

        btnEye.setText("Eye");
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {

            double withdrawal = Double.parseDouble(txtAmount.getText());
            int inputPin = Integer.parseInt(String.valueOf(txtPin.getPassword()));

            int pin = rsData.getInt("PIN");

            if (txtPin.getText().length() == 4) {
                
                if (inputPin == pin) {

                    if (checkWithdrawableAmount(withdrawal)) {

                        double currentBalance = rsData.getDouble("OUTSTANDING_BALANCE");
                        double newBalance = currentBalance - withdrawal;

                        rsData.updateDouble("OUTSTANDING_BALANCE", newBalance);

                        rsData.updateRow();

                        JOptionPane.showMessageDialog(null, "Transaction Complete");

                        returnToTransaction();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect pin.");
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
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblWithdraw;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
