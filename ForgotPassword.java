package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;
    private Connection conn;

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {
        setBounds(500, 200, 850, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        // Initialize your buttons here before adding action listeners
        b1 = new JButton("Search");
        b2 = new JButton("Retrieve");
        b3 = new JButton("Back");

        // Now, you can safely add action listeners to these buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // The rest of your UI component initialization goes here...
        // Make sure you add these buttons to your contentPane
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(109, 83, 87, 29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(109, 122, 75, 21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 154, 156, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(new Color(105, 105, 105));
        t1.setBounds(277, 88, 139, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(277, 123, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(72, 61, 139));
        t3.setColumns(10);
        t3.setBounds(277, 161, 139, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(277, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(50, 205, 50));
        t5.setColumns(10);
        t5.setBounds(277, 225, 139, 20);
        contentPane.add(t5);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(560, 70, 200, 200);
        add(l6);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(428, 83, 80, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 188, 85, 29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBounds(47, 45, 508, 281);
        panel.setBackground(Color.PINK);
        contentPane.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Conn con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = new Conn(); // Assuming Conn class properly manages connection
            conn = con.establishConnection(); // Establishing connection
            if (ae.getSource() == b1) {
                String sql = "select * from account where username=?";
                st = conn.prepareStatement(sql);

                st.setString(1, t1.getText());
                rs = st.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("securityQuestion"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found.");
                }
            } else if (ae.getSource() == b2) {
                String sql = "select * from account where username=? AND answer=?";
                st = conn.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t4.getText());
                rs = st.executeQuery();

                if (rs.next()) {
                    t5.setText(rs.getString("password")); // In a real application, consider security best practices
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect answer.");
                }
            } else if (ae.getSource() == b3) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.c.close(); // Assuming Conn class has a public Connection field 'c'
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Conn {
    public Connection c;

    public Connection establishConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@10.90.3.11:1521:xe";
            String uname = "system";
            String upass = "mysql";
            c = DriverManager.getConnection(url, uname, upass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
