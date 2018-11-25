package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Deposit extends javax.swing.JFrame {

    Connection connect;
    ResultSet rsData;

    public Deposit(Connection con, ResultSet rs) {
        initComponents();
        this.connect = con;
        this.rsData = rs;
    }

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
    
    public void clearTexts(){
        txtAmount.setText("");
        txtPin.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblPIN = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        txtAmount = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        jlblAmount = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlblPIN.setText("PIN:");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jlblAmount.setText("Deposit Amount:");

        btnReturn.setText("Cancel");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jlblAmount)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblPIN)
                                .addGap(18, 18, 18)
                                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReturn)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblAmount))
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblPIN))
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnReturn))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {

            double depositValue = Double.parseDouble(txtAmount.getText());
            int inputPin = Integer.parseInt(String.valueOf(txtPin.getPassword()));

            int pin = rsData.getInt("PIN");

            if (inputPin == pin) {

                if (verifyDepositAmount(depositValue)) {

                    double currBal = rsData.getDouble("OUTSTANDING_BALANCE");
                    double newBal = currBal + depositValue;

                    rsData.updateDouble("OUTSTANDING_BALANCE", newBal);
                    rsData.updateRow();
                    JOptionPane.showMessageDialog(null, "Transaction Complete");
                    
                    clearTexts();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect pin Please Try Again");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        try {
            this.dispose();
            new Transactions(connect, rsData.getInt("CARD_NUMBER")).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jlblAmount;
    private javax.swing.JLabel jlblPIN;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
