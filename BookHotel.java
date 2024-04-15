package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JTextField usernameTextField;
    private Choice c1, c2, c3;
    private String username;

    // Constructor
    public BookHotel(String username) {
        this.username = username; // Assigning the provided username
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null); // Open the frame in the center of the screen
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Load image for the JLabel
        ImageIcon i1 = new ImageIcon(BookHotel.class.getResource("/icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 100, 700, 300);
        contentPane.add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        // Username label and text field
        JLabel la2 = new JLabel("Username:");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(271, 70, 150, 20);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        // Select Hotel label and choice
        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        c1 = new Choice();
        c1.add("JW Marriott Hotel");
        c1.add("Mandarin Oriental Hotel");
        c1.add("Four Seasons Hotel");
        c1.add("Radisson Hotel");
        c1.add("Classio Hotel");
        c1.add("The Bay Club Hotel");
        c1.add("Breeze Blows Hotel");
        c1.add("Quick Stop Hotel");
        c1.add("Happy Mornings Motel");
        // Add more hotels below
        c1.add("New Hotel 1");
        c1.add("New Hotel 2");
        // Add as many hotels as needed
        c1.setBounds(271, 110, 150, 30);
        contentPane.add(c1);

        // Total Persons label and text field
        JLabel la3 = new JLabel("Total Persons:");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        // Number of Days label and text field
        JLabel la4 = new JLabel("Number of Days:");
        la4.setBounds(35, 190, 200, 14);
        contentPane.add(la4);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(271, 190, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        // AC / Non-AC label and choice
        JLabel la5 = new JLabel("AC / Non-AC:");
        la5.setBounds(35, 230, 200, 14);
        contentPane.add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(271, 230, 150, 30);
        contentPane.add(c2);

        // Food Included label and choice
        JLabel la6 = new JLabel("Food Included :");
        la6.setBounds(35, 270, 200, 14);
        contentPane.add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271, 270, 150, 30);
        contentPane.add(c3);

        // ID label and text field
        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(35, 310, 200, 14);
        contentPane.add(lblID);

        t3 = new JTextField();
        t3.setBounds(271, 310, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        // Number label and text field
        JLabel lblNumber = new JLabel("Number:");
        lblNumber.setBounds(35, 350, 200, 14);
        contentPane.add(lblNumber);

        t4 = new JTextField();
        t4.setBounds(271, 350, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        // Phone Number label and text field
        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(35, 390, 200, 14);
        contentPane.add(lblPhoneNumber);

        t5 = new JTextField();
        t5.setBounds(271, 390, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        // Total Price label
        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 430, 200, 14);
        contentPane.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
        contentPane.add(l5);

        // Check Price button
        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int persons = Integer.parseInt(t1.getText());
                int days = Integer.parseInt(t2.getText());
                int acPrice = c2.getSelectedItem().equals("AC") ? 5000 : 3000;
                int foodPrice = c3.getSelectedItem().equals("Yes") ? 500 : 0;
                int total = (acPrice + foodPrice) * persons * days;
                l5.setText("Rs " + total);
            }
        });
        b1.setBounds(50, 470, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        // Book button
        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    String hotelName = c1.getSelectedItem();
                    int persons = t1.getText().isEmpty() ? 0 : Integer.parseInt(t1.getText());
                    int days = t2.getText().isEmpty() ? 0 : Integer.parseInt(t2.getText());

                    String acOption = c2.getSelectedItem();
                    String foodOption = c3.getSelectedItem();
                    String totalPrice = l5.getText();
                    int id = t3.getText().isEmpty() ? 0 : Integer.parseInt(t3.getText());
                    String number = t4.getText();
                    String phoneNumber = t5.getText();

                    // Perform database insertion here
                    String query = "INSERT INTO bookHotel (id, username, hotel_name, total_persons, num_of_days, ac_non_ac, food_included, \"number\", phone, total_price) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = c.establishConnection().prepareStatement(query);
                    pstmt.setInt(1, id);
                    pstmt.setString(2, usernameTextField.getText());
                    pstmt.setString(3, hotelName);
                    pstmt.setInt(4, persons);
                    pstmt.setInt(5, days);
                    pstmt.setString(6, acOption);
                    pstmt.setString(7, foodOption);
                    pstmt.setString(8, number);
                    pstmt.setString(9, phoneNumber);
                    pstmt.setString(10, totalPrice);

                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Hotel Booked Successfully\nTotal Price: " + totalPrice);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error occurred while booking hotel.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(200, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        // Back button
        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }

    // Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Pass username to the constructor
                    BookHotel frame = new BookHotel("username");
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
            String upass = "mysql"; // Corrected typo from "mysql" to "system"
            conn = DriverManager.getConnection(url, uname, upass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
