package travel.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField, textField_1, textField_2, textField_3;
    private JButton b1, b2;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 250, 700, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        textField_1 = new JTextField();
        textField_1.setBounds(265, 128, 148, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        textField_2 = new JTextField();
        textField_2.setBounds(265, 165, 148, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblSecurityQuestion = new JLabel("Security Question:");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        comboBox = new JComboBox<>(new String[]{"Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?"});
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblAnswer = new JLabel("Answer:");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        textField_3 = new JTextField();
        textField_3.setBounds(265, 239, 148, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
          ImageIcon icon = new ImageIcon(getClass().getResource("/icons/signup.png")); 
        JLabel label = new JLabel(icon); 
        label.setBounds(460, 70, 200, 200); 
        contentPane.add(label);
       

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 46, 640, 367);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn connObj = new Conn();
            Connection con = connObj.establishConnection();
            if (ae.getSource() == b1) {
                String sql = "INSERT INTO account(username, name, password, securityquestion, answer) VALUES(?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    this.setVisible(false);
                    new Login().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error in creating account");
                }
                st.close();
            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Conn {
    public Connection establishConnection() {
        Connection conn = null;
        try {
            // Corrected the syntax for loading the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Database URL, Username, and Password
            String url = "jdbc:oracle:thin:@10.90.3.11:1521:xe";
            String uname = "system";
            String upass = "mysql";

            // Establishing the connection
            conn = DriverManager.getConnection(url, uname, upass);

        } catch (Exception e) {
            // Displaying a dialog box with the exception message
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
}
