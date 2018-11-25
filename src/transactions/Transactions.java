package transactions;

import java.sql.*;
import javax.swing.JOptionPane;

public class Transactions extends javax.swing.JFrame {
    
    Connection connect;
    Statement sCommand;
    ResultSet rsData;
    int curRow = 0;
    int cardNumber;
    
    public Transactions(Connection con, int cardNumber) {
        initComponents();
        connect = con;
        this.cardNumber = cardNumber;
        connectToDatabase();
    }
    
    
    public void connectToDatabase() {
        try {
            sCommand = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM APP.CUSTOMER_DATA WHERE CARD_NUMBER = " + cardNumber;
            System.out.println(cardNumber);
            rsData = sCommand.executeQuery(sql);
            rsData.first();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeposit = new javax.swing.JButton();
        btnWithdrawal = new javax.swing.JButton();
        btnChangePin = new javax.swing.JButton();
        btnBalanceInquiry = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnDeposit.setText("Deposit");
        btnDeposit.setPreferredSize(new java.awt.Dimension(107, 23));
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        btnWithdrawal.setText("Withdrawal");
        btnWithdrawal.setPreferredSize(new java.awt.Dimension(107, 23));
        btnWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawalActionPerformed(evt);
            }
        });

        btnChangePin.setText("Change Pin");
        btnChangePin.setMinimumSize(new java.awt.Dimension(107, 23));
        btnChangePin.setPreferredSize(new java.awt.Dimension(107, 23));
        btnChangePin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePinActionPerformed(evt);
            }
        });

        btnBalanceInquiry.setText("Balance Inquiry");
        btnBalanceInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceInquiryActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(107, 23));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBalanceInquiry)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBalanceInquiry))
                .addGap(41, 41, 41)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBalanceInquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceInquiryActionPerformed
        int outstandingBalance;
        
        try {
            outstandingBalance = rsData.getInt("BALANCE");
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
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalanceInquiry;
    private javax.swing.JButton btnChangePin;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnWithdrawal;
    // End of variables declaration//GEN-END:variables
}
