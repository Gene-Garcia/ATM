package login;

import register.Register;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gene Garcia
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        connectToDatabase();
    }

    public Login(Connection con) {
        initComponents();
        connect = con;
        connectToDatabase();

    }

    //  USER DEFINED --------------------------------------
    //classes
    Register reg;

    Connection connect;
    Statement sCommand;
    ResultSet rsData;

    String sqlCommand = "";

    public void connectToDatabase() {

        try {

            sCommand = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlCommand = "SELECT CARD_NUMBER FROM APP.CUSTOMER_DATA";
            rsData = sCommand.executeQuery(sqlCommand);
            rsData.next();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public boolean checkAccount(int cardNum) {

        try {

            sqlCommand = "SELECT CARD_NUMBER FROM APP.CUSTOMER_DATA WHERE CARD_NUMBER = " + cardNum;
            rsData = sCommand.executeQuery(sqlCommand);

            if (rsData.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No account matched!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return false;
    }

    // END USER DEFINED -----------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlInput = new javax.swing.JPanel();
        txtCardNumber = new javax.swing.JTextField();
        lnlCardNo = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        pnlButton = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(510, 335));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtCardNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtCardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardNumberActionPerformed(evt);
            }
        });

        lnlCardNo.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        lnlCardNo.setText("Card Number");

        btnClear.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(lnlCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lnlCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(pnlInput);
        pnlInput.setBounds(30, 130, 430, 120);

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(null);

        btnEnter.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        pnlButton.add(btnEnter);
        btnEnter.setBounds(133, 8, 107, 40);

        btnRegister.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        pnlButton.add(btnRegister);
        btnRegister.setBounds(8, 8, 107, 40);

        getContentPane().add(pnlButton);
        pnlButton.setBounds(210, 270, 248, 56);

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HUMAN ATM KACHING!");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 20, 470, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardNumberActionPerformed

    }//GEN-LAST:event_txtCardNumberActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        this.dispose();
        reg = new Register(connect);
        reg.show();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {

            if (!(txtCardNumber.getText().equals(""))) {
                //textAreas not empty

                boolean accountMatch = checkAccount(Integer.parseInt(txtCardNumber.getText()));

                if (accountMatch) {
                    //go to proccessing
                    JOptionPane.showMessageDialog(null, "Account found!");
                    //call transaction (row, cardnum)
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtCardNumber.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lnlCardNo;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtCardNumber;
    // End of variables declaration//GEN-END:variables
}
