package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t5, t6, t7, t8;
    private JComboBox<String> comboBox;
    private JRadioButton r1, r2;
    private JButton btnAdd, btnBack;
    private String username;

    public AddCustomer(String username) {
        this.username = username;
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/newcustomer.jpg"));
            Image image = imageIcon.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(450, 40, 450, 420);
            contentPane.add(imageLabel);
        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
            e.printStackTrace();
        }

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);

        JLabel l3 = new JLabel("username :");
        l3.setBounds(35, 70, 200, 14);
        contentPane.add(l3);

        t7 = new JTextField(username);
        t7.setBounds(271, 70, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        comboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        comboBox.setBounds(271, 110, 150, 20);
        contentPane.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 150, 200, 14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 190, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 230, 80, 12);
        contentPane.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 230, 100, 12);
        contentPane.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        t3 = new JTextField();
        t3.setBounds(271, 270, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel lblAddress = new JLabel("Address :");
        lblAddress.setBounds(35, 310, 200, 14);
        contentPane.add(lblAddress);

        t5 = new JTextField();
        t5.setBounds(271, 310, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(35, 350, 200, 14);
        contentPane.add(lblPhone);

        t6 = new JTextField();
        t6.setBounds(271, 350, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(35, 390, 200, 14);
        contentPane.add(lblEmail);

        t8 = new JTextField();
        t8.setBounds(271, 390, 150, 20);
        contentPane.add(t8);
        t8.setColumns(10);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });
        btnAdd.setBounds(100, 430, 120, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
    }

    private void addCustomer() {
        String radio = r1.isSelected() ? "Male" : "Female";
        try {
            conn = new Conn().establishConnection();

            String s9 = t7.getText(); // username
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = t1.getText();
            String s3 = t2.getText();
            String s5 = t3.getText(); // country
            String s7 = t5.getText(); // address
            String s8 = t6.getText(); // phone
            String s10 = t8.getText(); // email
            
            String query = "INSERT INTO Customer (username, ID, \"Number\", Name, Gender, Country, Address, Phone, Email) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
       pst = conn.prepareStatement(query);
       pst.setString(1, s9);
       pst.setString(2, s1);
       pst.setString(3, s2);
       pst.setString(4, s3);
       pst.setString(5, radio);
       pst.setString(6, s5);
       pst.setString(7, s7);
       pst.setString(8, s8);
       pst.setString(9, s10);
       pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
             setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
                
                
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCustomer frame = new AddCustomer("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class Conn {
    public Connection establishConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@10.90.3.11:1521:xe";
            String uname = "system";
            String upass = "mysql";
            conn = DriverManager.getConnection(url, uname, upass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database driver not found!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
