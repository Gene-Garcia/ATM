package transact;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    Connection connect;
    Statement sCommand;
    ResultSet rsData;
    int curRow = 0;

    public MainMenu() {
        initComponents();
        connectToDatabase();
    }

    public MainMenu(Connection con) {
        initComponents();
        connectToDatabase();
        connect = con;
    }

    public void connectToDatabase() {
        try {

            sCommand = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM APP.CUSTOMER_DATA";
            rsData = sCommand.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnDeposit = new javax.swing.JButton();
        jbtnWithdrawal = new javax.swing.JButton();
        jbtnChangeP = new javax.swing.JButton();
        jbtnBalance = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jbtnDeposit.setText("Deposit");
        jbtnDeposit.setPreferredSize(new java.awt.Dimension(107, 23));
        jbtnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDepositActionPerformed(evt);
            }
        });

        jbtnWithdrawal.setText("Withdrawal");
        jbtnWithdrawal.setPreferredSize(new java.awt.Dimension(107, 23));
        jbtnWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnWithdrawalActionPerformed(evt);
            }
        });

        jbtnChangeP.setText("Change Pin");
        jbtnChangeP.setMinimumSize(new java.awt.Dimension(107, 23));
        jbtnChangeP.setPreferredSize(new java.awt.Dimension(107, 23));
        jbtnChangeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChangePActionPerformed(evt);
            }
        });

        jbtnBalance.setText("Balance Inquiry");
        jbtnBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBalanceActionPerformed(evt);
            }
        });

        jbtnExit.setText("Exit");
        jbtnExit.setPreferredSize(new java.awt.Dimension(107, 23));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
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
                        .addComponent(jbtnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(jbtnChangeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBalance)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnChangeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBalance))
                .addGap(41, 41, 41)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBalanceActionPerformed
        int bal;
        try {
            rsData.next();
            bal = rsData.getInt("BALANCE");
            JOptionPane.showMessageDialog(this.jbtnBalance, "Your balance is " + bal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jbtnBalanceActionPerformed

    private void jbtnChangePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChangePActionPerformed
        this.dispose();
        new ChangePass().setVisible(true);
    }//GEN-LAST:event_jbtnChangePActionPerformed

    private void jbtnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDepositActionPerformed
        this.dispose();
        new Deposit().setVisible(true);
    }//GEN-LAST:event_jbtnDepositActionPerformed

    private void jbtnWithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnWithdrawalActionPerformed
        this.dispose();
        new Withdrawal().setVisible(true);
    }//GEN-LAST:event_jbtnWithdrawalActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnExitActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnBalance;
    private javax.swing.JButton jbtnChangeP;
    private javax.swing.JButton jbtnDeposit;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnWithdrawal;
    // End of variables declaration//GEN-END:variables
}
