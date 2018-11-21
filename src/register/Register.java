package register;

/**
 * 
 * @author Mark Anthoy Mamauag
 */

import login.Login;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        connectToDatabase();

    }

    public Register(Connection con) {
        initComponents();
        connect = con;
        connectToDatabase();
    }

    //USER DEFINED METHODS ----------------------------------------------------
    Login log;

    int currentRecord;

    Connection connect;
    Statement sCommand;
    ResultSet rsData;

    public int getHighestRecord() {
        int returnValue = 0;
        try {

            String newSql = "SELECT MAX(CARD_NUMBER) FROM APP.CUSTOMER_DATA";
            rsData = sCommand.executeQuery(newSql);
            rsData.next();
            returnValue = rsData.getInt(1) + 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return returnValue;
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

    public void clearFields() {
        txtCardNo.setText("");
        txtPin.setText("");
        txtCardNo.setText("");
        txtName.setText("");
        txtBalance.setText("");
    }
    //END OF USER DEFINED METHODS -------------------------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInput = new javax.swing.JPanel();
        txtPin = new javax.swing.JTextField();
        txtCardNo = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        lblCardNo = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lnlName = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCardNo.setEditable(false);

        lblCardNo.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        lblCardNo.setText("Card No.");

        lblPin.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        lblPin.setText("PIN Code");

        lblBalance.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        lblBalance.setText("Initial Balance");

        lnlName.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        lnlName.setText("Name");

        btnGenerate.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlInputLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lblPin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lnlName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(lblCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCardNo)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnlName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 420, 250));

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HUMAN ATM KACHING!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 480, -1));

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegister.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnReturn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 270, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        int newCardNo = 0;
        int newPin = 0;
        double newBal = 0;
        String name = "";

        if (!(txtCardNo.getText().equals("") || txtPin.getText().equals("") || txtBalance.getText().equals("") || txtName.getText().equals(""))) {

            //Getting Input from Text Fields
            name = txtName.getText();

            //Parsing Integer Variables
            newCardNo = Integer.parseInt(txtCardNo.getText());
            newPin = Integer.parseInt(txtPin.getText());
            newBal = Double.parseDouble(txtBalance.getText());

            //Inserting Data to Table
            try {

                rsData = sCommand.executeQuery("select * from APP.CUSTOMER_DATA");
                rsData.moveToInsertRow();
                rsData.updateInt("CARD_NUMBER", newCardNo);
                rsData.updateInt("PIN", newPin);
                rsData.updateDouble("OUTSTANDING_BALANCE", newBal);
                rsData.updateString("NAME", name);
                rsData.insertRow();

                sCommand.close();
                rsData.close();

                connectToDatabase();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Successful Registration! ");

            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Error registering your account.\nPlease check if you have filled up the required fields.");
        }

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        txtCardNo.setText(String.valueOf(getHighestRecord()));
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        // Move the window
        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowStateChanged

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed

        this.dispose();
        log = new Login(connect);
        log.show();
    }//GEN-LAST:event_btnReturnActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCardNo;
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lnlName;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCardNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPin;
    // End of variables declaration//GEN-END:variables
}
