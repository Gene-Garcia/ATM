package atm;

/**
 *  Author: Gene Joseph Garcia
 *  Date created: 11/19/18
 */

import login.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * 
 * @author Team Lezned
 */

public class ATM {

    final String HOST = "jdbc:derby://localhost:1527/LEZNED";
    final String USERNAME = "Lezned";
    final String PASSWORD = "Kimi";

    private Connection connect;
    
    public static void main(String[] args) {
        
        ATM obj = new ATM();
        obj.configureConnection();
        
        new Login(obj.connect).show();
    }
    
    public void configureConnection(){     
        try {
            connect = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " at " + HOST);
        }
    }

}
