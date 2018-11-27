package register;

import login.Login;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Team Lezned
 */
public class Register extends javax.swing.JFrame {

    public Register(Connection con) {
        initComponents();
        connect = con;
        connectToDatabase();
    }

    Connection connect;
    Statement sCommand;
    ResultSet rsData;

    public int getHighestRecord() {
        final int STARTING_RECORD = 2018001;
        int returnValue = 0;
        try {

            String newSql = "SELECT MAX(CARD_NUMBER) FROM APP.CUSTOMER_DATA";
            rsData = sCommand.executeQuery(newSql);
            rsData.next();
            returnValue = rsData.getInt(1) + 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return returnValue == 1 ? STARTING_RECORD : returnValue;
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblLogoSecond = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        txtCardNo = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        lblCardNo = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        txtPin = new javax.swing.JPasswordField();
        btnEye = new javax.swing.JButton();
        lblBackgroundInput = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblBackgroundButton = new javax.swing.JLabel();
        lblBackgroundMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Ebrima", 0, 36)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.jpg"))); // NOI18N
        lblLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 20, 420, 70));

        lblLogoSecond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/second-logo.png"))); // NOI18N
        getContentPane().add(lblLogoSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 150, 50));

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCardNo.setEditable(false);
        txtCardNo.setBackground(new java.awt.Color(201, 235, 249));
        pnlInput.add(txtCardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 10, 261, 37));

        txtBalance.setBackground(new java.awt.Color(201, 235, 249));
        pnlInput.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 261, 37));

        lblCardNo.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblCardNo.setForeground(new java.awt.Color(204, 255, 255));
        lblCardNo.setText("Card No.");
        pnlInput.add(lblCardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 124, 37));

        lblPin.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblPin.setForeground(new java.awt.Color(204, 255, 255));
        lblPin.setText("PIN Code");
        pnlInput.add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 124, 37));

        lblBalance.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(204, 255, 255));
        lblBalance.setText("Initial Balance");
        pnlInput.add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 124, 37));

        txtName.setBackground(new java.awt.Color(201, 235, 249));
        pnlInput.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 261, 37));

        lblName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 255, 255));
        lblName.setText("Name");
        pnlInput.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 124, 37));

        btnGenerate.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/generate.png"))); // NOI18N
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        pnlInput.add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 53, 50, 50));

        txtPin.setBackground(new java.awt.Color(201, 235, 249));
        txtPin.setName(""); // NOI18N
        pnlInput.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 261, 37));

        btnEye.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        pnlInput.add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 152, 50, 50));

        lblBackgroundInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register-background.jpg"))); // NOI18N
        pnlInput.add(lblBackgroundInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 413, 303));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 420, 310));

        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegister.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register.png"))); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        pnlButton.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        btnReturn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlButton.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 50));

        lblBackgroundButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register-background.jpg"))); // NOI18N
        pnlButton.add(lblBackgroundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 124, 64));

        getContentPane().add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 130, 70));

        lblBackgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register-background.jpg"))); // NOI18N
        getContentPane().add(lblBackgroundMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        int newCardNo = 0;
        int newPin = 0;
        double newBal = 0;
        String name = "";

        if (!(txtCardNo.getText().equals("") || txtPin.getText().equals("") || txtBalance.getText().equals("") || txtName.getText().equals(""))) {
            if (txtPin.getText().length() == 4) {
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
                    rsData.updateString("PIN", String.valueOf(newPin));
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
                JOptionPane.showMessageDialog(null, "Invalid pin, minimum and maximum of 4 digits.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error registering your account.\nPlease check if you have filled up the required fields.");
        }

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        int highestRec = getHighestRecord();
        if (highestRec == 0) {
            txtCardNo.setText("2018000");
        } else {
            txtCardNo.setText(String.valueOf(highestRec));
        }
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
        new Login(connect).show();

    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnEyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEyeActionPerformed

        char echo = txtPin.getEchoChar();

        switch (echo) {
            case '•':
                txtPin.setEchoChar((char) 0);
                break;
            default:
                txtPin.setEchoChar('•');
        }

    }//GEN-LAST:event_btnEyeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEye;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel lblBackgroundButton;
    private javax.swing.JLabel lblBackgroundInput;
    private javax.swing.JLabel lblBackgroundMain;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCardNo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoSecond;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPin;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCardNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
