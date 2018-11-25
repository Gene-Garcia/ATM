package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Withdrawal extends javax.swing.JFrame {

    public Withdrawal(Connection con, ResultSet rs) {
        initComponents();
        connect = con;
        this.rsData = rs;
    }

    final int MAXIMUM_AMOUNT_WITHDRAWABLE = 10000;
    final int MINIMUM_WITHDRAWABLE_AMOUT = 200;

    Connection connect;
    ResultSet rsData;

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

    public void clearTexts() {
        txtAmount.setText("");
        txtPin.setText("");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(445, 243));

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblWithdraw.setText("Amount to be Withdrawn:");

        lblPin.setText("PIN:");

        btnReturn.setText("Return");
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
                        .addGap(10, 10, 10)
                        .addComponent(lblWithdraw)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConfirm)
                                .addGap(69, 69, 69)
                                .addComponent(btnReturn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPin)
                                .addGap(18, 18, 18)
                                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblWithdraw))
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblPin))
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn)
                    .addComponent(btnConfirm))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {

            double withdrawal = Double.parseDouble(txtAmount.getText());
            int inputPin = Integer.parseInt(String.valueOf(txtPin.getPassword()));

            int pin = rsData.getInt("PIN");

            if (inputPin == pin) {

                if (checkWithdrawableAmount(withdrawal)) {

                    double currentBalance = rsData.getDouble("OUTSTANDING_BALANCE");
                    double newBalance = currentBalance - withdrawal;

                    rsData.updateDouble("OUTSTANDING_BALANCE", newBalance);

                    rsData.updateRow();

                    JOptionPane.showMessageDialog(null, "Transaction Complete");

                    clearTexts();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Incorrect pin.");
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
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblWithdraw;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
