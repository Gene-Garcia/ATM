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

        lblLogoSecond = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblWithdraw = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        txtAmount = new javax.swing.JTextField();
        btnEye = new javax.swing.JButton();
        lblBackground1 = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblBackgroundButton = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Withdraw");
        setMinimumSize(new java.awt.Dimension(445, 243));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 93, 150, 50));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 24, -1, 70));

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWithdraw.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblWithdraw.setForeground(new java.awt.Color(204, 255, 255));
        lblWithdraw.setText("Withdraw Amount:");
        pnlInput.add(lblWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 37));

        lblPin.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblPin.setForeground(new java.awt.Color(204, 255, 255));
        lblPin.setText("PIN:");
        pnlInput.add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 37));

        txtPin.setBackground(new java.awt.Color(201, 235, 249));
        txtPin.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 261, 37));

        txtAmount.setBackground(new java.awt.Color(201, 235, 249));
        txtAmount.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 261, 37));

        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        pnlInput.add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 116, 50, 50));

        lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/withdraw-background.jpg"))); // NOI18N
        pnlInput.add(lblBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 475, 175));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 480, 180));

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/withdraw.png"))); // NOI18N
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlButton.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlButton.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, 50, 50));

        lblBackgroundButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/withdraw-background.jpg"))); // NOI18N
        pnlButton.add(lblBackgroundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 120, 63));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 382, 127, 70));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/withdraw-background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 475));

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
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackgroundButton;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblWithdraw;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
