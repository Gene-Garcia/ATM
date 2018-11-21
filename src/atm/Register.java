//Programmed by: Mark Anthony G. Mamauag
//Date Created: 11/21/2018

//Update: Still needs work on the Generate Card Number Method

package register;

import java.sql.*;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;

    public Register() {
        initComponents();
        doConnect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPin = new javax.swing.JTextField();
        txtCardNo = new javax.swing.JTextField();
        txtBal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);
        jPanel1.add(txtPin);
        txtPin.setBounds(249, 61, 94, 24);

        txtCardNo.setEditable(false);
        jPanel1.add(txtCardNo);
        txtCardNo.setBounds(249, 12, 94, 24);
        jPanel1.add(txtBal);
        txtBal.setBounds(249, 109, 94, 24);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel1.setText("Card No.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(95, 8, 72, 30);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel2.setText("PIN Code");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 57, 77, 30);

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel3.setText("Initial Balance");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(69, 105, 117, 30);
        jPanel1.add(txtName);
        txtName.setBounds(249, 157, 94, 24);

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(137, 153, 49, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 410, 191);

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 36)); // NOI18N
        jLabel5.setText("HUMAN ATM KACHING!");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 0, 391, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegister.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnGenerate.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 250, 290, 62);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int currentRecord;

    public int getHigestRecord() {
        int returnValue = 0;
        try {

            String newSql = "SELECT MAX(CARD_NUMBER) FROM APP.CUSTOMER_TABLE";
            rs = stmt.executeQuery(newSql);
            rs.next();
            returnValue = rs.getInt("CARD_NUMBER") + 1;
        } catch (Exception e) {

        }

        return returnValue;
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        int newCardNo = 0;
        int newPin = 0;
        double newBal = 0;
        String name = "";
        
        if (!(txtCardNo.getText().equals("")
                || txtPin.getText().equals("")
                || txtBal.getText().equals("")
                || txtName.getText().equals(""))) {

            //Getting Input from Text Fields
            name = txtName.getText();

            //Parsing Integer Variables
            newCardNo = Integer.parseInt(txtCardNo.getText());
            newPin = Integer.parseInt(txtPin.getText());
            newBal = Double.parseDouble(txtBal.getText());

            JOptionPane.showMessageDialog(null, "Successful Registration! "
                    + "Click OK to proceed to the Log-In Interface.");
        } else {
            JOptionPane.showMessageDialog(null, "Error registering your desired account."
                    + "\n\nPlease check if you have filled up the required fields.");
        }

        //Inserting Data to Table
        try {

            rs = stmt.executeQuery("select * from APP.CUSTOMER_DATA");
            curRow = rs.getRow();
            rs.moveToInsertRow();
            rs.updateInt("CARD_NUMBER", newCardNo);
            rs.updateInt("PIN", newPin);
            rs.updateDouble("OUTSTANDING_BALANCE", newBal);
            rs.updateString("NAME", name);
            rs.insertRow();

            stmt.close();
            rs.close();

            doConnect();

            this.hide();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }


    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        txtCardNo.setText(String.valueOf(getHigestRecord()));
    }//GEN-LAST:event_btnGenerateActionPerformed

    public void doConnect() {

        try {

            String host = "jdbc:derby://localhost:1527/LEZNED";
            String uName = "Lezned";
            String uPass = "kIMI";

            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM APP.CUSTOMER_DATA";
            rs = stmt.executeQuery(sql);
            curRow = rs.getRow();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Register.this, err.getMessage());
        }
    }

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBal;
    private javax.swing.JTextField txtCardNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPin;
    // End of variables declaration//GEN-END:variables
}
