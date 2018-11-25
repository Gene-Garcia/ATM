package transactions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import login.Login;

/**
 *
 * @author Team Lezned
 */
public class Transactions extends javax.swing.JFrame {

    Connection connect;
    Statement sCommand;
    ResultSet rsData;

    int cardNumber;

    String sqlCommand;

    public Transactions(Connection con, int cardNumber) {
        initComponents();
        connect = con;
        this.cardNumber = cardNumber;
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            sCommand = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlCommand = "SELECT * FROM APP.CUSTOMER_DATA WHERE CARD_NUMBER = " + cardNumber;
            System.out.println(cardNumber);
            rsData = sCommand.executeQuery(sqlCommand);
            rsData.first();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTransactButtons = new javax.swing.JPanel();
        btnDeposit = new javax.swing.JButton();
        btnChangePin = new javax.swing.JButton();
        btnWithdrawal = new javax.swing.JButton();
        btnBalanceInquiry = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblBackgroundInput = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lblBackgroundButton = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLogoSecond = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kaching Bank");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTransactButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlTransactButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deposit-big.png"))); // NOI18N
        btnDeposit.setPreferredSize(new java.awt.Dimension(107, 23));
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        pnlTransactButtons.add(btnDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 80));

        btnChangePin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change-pin-big.png"))); // NOI18N
        btnChangePin.setMinimumSize(new java.awt.Dimension(107, 23));
        btnChangePin.setPreferredSize(new java.awt.Dimension(107, 23));
        btnChangePin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePinActionPerformed(evt);
            }
        });
        pnlTransactButtons.add(btnChangePin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 100, 80));

        btnWithdrawal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/withdraw-bigpng.png"))); // NOI18N
        btnWithdrawal.setPreferredSize(new java.awt.Dimension(107, 23));
        btnWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawalActionPerformed(evt);
            }
        });
        pnlTransactButtons.add(btnWithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 80));

        btnBalanceInquiry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/balance-big.png"))); // NOI18N
        btnBalanceInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceInquiryActionPerformed(evt);
            }
        });
        pnlTransactButtons.add(btnBalanceInquiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 100, 80));

        lblMessage.setBackground(new java.awt.Color(201, 235, 249));
        lblMessage.setForeground(new java.awt.Color(0, 0, 0));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("jLabel1");
        lblMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblMessage.setOpaque(true);
        pnlTransactButtons.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 260, 170));

        lblBackgroundInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaction-bacground.jpg"))); // NOI18N
        pnlTransactButtons.add(lblBackgroundInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 495, 245));

        getContentPane().add(pnlTransactButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 170, 500, 250));

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnExit.setPreferredSize(new java.awt.Dimension(107, 23));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlButton.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 50, 50));

        lblBackgroundButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaction-bacground.jpg"))); // NOI18N
        pnlButton.add(lblBackgroundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 55, 55));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 430, 60, 60));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 20, -1, 70));

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 150, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaction-bacground.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 505));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBalanceInquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceInquiryActionPerformed
        double outstandingBalance;

        try {
            outstandingBalance = rsData.getDouble("OUTSTANDING_BALANCE");
            JOptionPane.showMessageDialog(this.btnBalanceInquiry, "Your balance is " + outstandingBalance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBalanceInquiryActionPerformed

    private void btnChangePinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePinActionPerformed
        try {
            this.dispose();
            new ChangePin(connect, rsData).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnChangePinActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        try {
            this.dispose();
            new Deposit(connect, rsData).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kachings", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnWithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawalActionPerformed
        try {
            this.dispose();
            new Withdrawal(connect, rsData).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnWithdrawalActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        new Login(connect).show();
    }//GEN-LAST:event_btnExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalanceInquiry;
    private javax.swing.JButton btnChangePin;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnWithdrawal;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundButton;
    private javax.swing.JLabel lblBackgroundInput;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlTransactButtons;
    // End of variables declaration//GEN-END:variables
}
