package transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ChangePin extends javax.swing.JFrame {

    Connection connect;
    ResultSet rsData;

    public ChangePin(Connection con, ResultSet rs) {
        initComponents();
        connect = con;
        this.rsData = rs;
    }

    public void clearTexts(){
        txtPin.setText("");
        txtOldPin.setText("");
        txtVerificationPin.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblOld = new javax.swing.JLabel();
        jlblNew = new javax.swing.JLabel();
        jlblNew2 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        txtOldPin = new javax.swing.JPasswordField();
        txtPin = new javax.swing.JPasswordField();
        txtVerificationPin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlblOld.setText("Old PIN:");

        jlblNew.setText("New PIN:");

        jlblNew2.setText("Re-enter new PIN:");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

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
                        .addGap(141, 141, 141)
                        .addComponent(btnConfirm)
                        .addGap(35, 35, 35)
                        .addComponent(btnReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblOld)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOldPin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblNew2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVerificationPin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblNew)
                                .addGap(4, 4, 4)
                                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblOld))
                    .addComponent(txtOldPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblNew))
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNew2)
                    .addComponent(txtVerificationPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm)
                    .addComponent(btnReturn)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        int oldPin = Integer.parseInt(String.valueOf(txtOldPin.getPassword()));
        int newPin1 = Integer.parseInt(String.valueOf(txtPin.getPassword()));
        int newPin2 = Integer.parseInt(String.valueOf(txtVerificationPin.getPassword()));
        
        try {
            int pin = rsData.getInt("PIN");

            if (newPin1 == newPin2 && pin == oldPin) {
                
                rsData.updateInt("PIN", newPin1);
                rsData.updateRow();
                JOptionPane.showMessageDialog(this.btnConfirm, "Successfully Changed Pin");
                
                clearTexts();
                
            }else if(newPin1 != newPin2){
                JOptionPane.showMessageDialog(this.btnConfirm, "new Pin Does not Match Please Try Again");
            }else if(pin != oldPin){
                JOptionPane.showMessageDialog(this.btnConfirm, "Incorrect old pin Pls try Again");
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
    private javax.swing.JLabel jlblNew;
    private javax.swing.JLabel jlblNew2;
    private javax.swing.JLabel jlblOld;
    private javax.swing.JPasswordField txtOldPin;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JPasswordField txtVerificationPin;
    // End of variables declaration//GEN-END:variables
}
