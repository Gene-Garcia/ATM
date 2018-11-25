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

        lblLogoSecond = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblBackground1 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        jlblPIN = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jlblAmount = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        btnEye = new javax.swing.JButton();
        lblBackgroundInput = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deposit");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 90, 150, 50));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 70));

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deposit.png"))); // NOI18N
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlButton.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 50, 50));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlButton.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 8, 50, 50));

        lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deposit-background.jpg"))); // NOI18N
        pnlButton.add(lblBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 120, 60));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 380, 125, 65));

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPIN.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jlblPIN.setForeground(new java.awt.Color(204, 255, 255));
        jlblPIN.setText("PIN:");
        pnlInput.add(jlblPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 37));

        txtAmount.setBackground(new java.awt.Color(201, 235, 249));
        txtAmount.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 261, 37));

        jlblAmount.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jlblAmount.setForeground(new java.awt.Color(204, 255, 255));
        jlblAmount.setText("Deposit Amount:");
        pnlInput.add(jlblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 37));

        txtPin.setBackground(new java.awt.Color(201, 235, 249));
        txtPin.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 261, 37));

        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        pnlInput.add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 125, 50, 50));

        lblBackgroundInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deposit-background.jpg"))); // NOI18N
        pnlInput.add(lblBackgroundInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 473, 183));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 480, 190));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deposit-background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 463));

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
    private javax.swing.JLabel jlblAmount;
    private javax.swing.JLabel jlblPIN;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackgroundInput;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
