package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.net.URL; // Import the URL class
import java.sql.Connection;
import java.sql.DriverManager;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {
        setBackground(new Color(255, 255, 204));
        setBounds(550, 250, 700, 400);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        ImageIcon c1 = getImageIcon("/icons/login.png"); // Adjust the path as necessary 
        if (c1 != null) { 
            JLabel l6 = new JLabel(c1); 
            l6.setBounds(480, 70, 150, 150); 
            panel.add(l6); 
        }

        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(176, 224, 230));
        b1.setBounds(149, 181, 113, 25);
        panel.add(b1);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);
        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 25);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(199, 231, 179, 25);
        panel.add(b3);

        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(new Color(255, 0, 0));
        l5.setBounds(70, 235, 110, 20);
        panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);

        setVisible(true);
    }

    private ImageIcon getImageIcon(String path) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                // Establish connection using Conn class
                Conn con = new Conn();
                Connection conn = con.establishConnection();

                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = conn.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, new String(passwordField.getPassword()));

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(textField.getText()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }
                conn.close(); // Close the connection after use
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            new Signup().setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
class Conn {
    public Connection establishConnection() {
        Connection conn = null;
        try {
            // Load the driver class. Make sure you have the correct driver in your classpath.
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Database URL, Username, and Password
            String url = "jdbc:oracle:thin:@10.90.3.11:1521:xe";
            String uname = "System";
            String upass = "mysql";

            // Establishing the connection
            conn = DriverManager.getConnection(url, uname, upass);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Oracle JDBC Driver not found. Make sure it is in the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}

