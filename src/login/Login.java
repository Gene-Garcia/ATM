package login;

import register.Register;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import transactions.*;

/**
 * 
 * @author Team Lezned
 */

public class Login extends javax.swing.JFrame {

    public Login(Connection con) {
        initComponents();
        connect = con;
        connectToDatabase();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblLogo = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        txtCardNumber = new javax.swing.JTextField();
        lnlCardNo = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        lblBackgroundInput = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblBackgroundButton = new javax.swing.JLabel();
        lblLogoSecond = new javax.swing.JLabel();
        lblBackgroundMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KACHING");
        setMinimumSize(new java.awt.Dimension(468, 333));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Ebrima", 0, 36)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 420, 70));

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCardNumber.setBackground(new java.awt.Color(201, 235, 249));
        txtCardNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtCardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnlInput.add(txtCardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 22, 261, 37));

        lnlCardNo.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lnlCardNo.setForeground(new java.awt.Color(204, 255, 255));
        lnlCardNo.setText("Card No.");
        pnlInput.add(lnlCardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 124, 37));

        btnClear.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pnlInput.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 65, 45, 47));

        lblBackgroundInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-background.jpg"))); // NOI18N
        pnlInput.add(lblBackgroundInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 425, 115));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 430, 120));

        pnlButton.setBackground(new java.awt.Color(13, 60, 109));
        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEnter.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnEnter.setBorderPainted(false);
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        pnlButton.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 50));

        btnRegister.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register.png"))); // NOI18N
        btnRegister.setBorderPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        pnlButton.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        lblBackgroundButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-background.jpg"))); // NOI18N
        pnlButton.add(lblBackgroundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 125, 65));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 130, 70));

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 150, 50));

        lblBackgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-background.jpg"))); // NOI18N
        getContentPane().add(lblBackgroundMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 473, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        this.dispose();
        new Register(connect).show();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {

            if (!(txtCardNumber.getText().equals(""))) {
                //textAreas not empty

                boolean accountMatch = checkAccount(Integer.parseInt(txtCardNumber.getText()));

                if (accountMatch) {
                    //go to proccessing
                    JOptionPane.showMessageDialog(null, "Account found", "Kaching", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Transactions(connect, rsData.getInt("CARD_NUMBER")).show();
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Kaching", JOptionPane.ERROR_MESSAGE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblBackgroundButton;
    private javax.swing.JLabel lblBackgroundInput;
    private javax.swing.JLabel lblBackgroundMain;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JLabel lnlCardNo;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtCardNumber;
    // End of variables declaration//GEN-END:variables
}
