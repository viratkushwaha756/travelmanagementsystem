package travel.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5; // Added t5 for username
    private JLabel l2, l3, l4, l5;
    private Choice c1;
    private Conn connInstance;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookPackage frame = new BookPackage(" ");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookPackage(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        setBounds(420, 220, 1100, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        connInstance = new Conn(); // Initialize Conn instance

        // Load the image
        String imagePath = "icons/bookpackage.jpg";
        URL imageUrl = getClass().getClassLoader().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon i1 = new ImageIcon(imageUrl);
            Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel la1 = new JLabel(i2);
            la1.setBounds(450, 50, 700, 300);
            add(la1);
        } else {
            System.err.println("Image resource not found: " + imagePath);
            // Handle the case where the image resource is not found
        }

        JLabel lblName = new JLabel("BOOK PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        t5 = new JTextField(); // Added for username
        t5.setBounds(271, 70, 150, 20); // Adjusted bounds
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel lblId = new JLabel("Select Package :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271, 110, 150, 30);
        contentPane.add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 190, 200, 14);
        contentPane.add(lbl1);

        t2 = new JTextField();
        t2.setBounds(271, 190, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 230, 200, 14);
        contentPane.add(lbl2);

        t3 = new JTextField();
        t3.setBounds(271, 230, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(35, 270, 200, 14);
        contentPane.add(lbl3);

        t4 = new JTextField();
        t4.setBounds(271, 270, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 310, 200, 14);
        contentPane.add(lblDeposite);

        l5 = new JLabel();
        l5.setBounds(271, 310, 200, 14);
        l5.setForeground(Color.RED);
        contentPane.add(l5);

        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p = c1.getSelectedItem();
                int cost = 0;
                if (p.equals("Gold Package")) {
                    cost += 12000;
                }
                if (p.equals("Silver Package")) {
                    cost += 25000;
                } else if (p.equals("Bronze Package")) {
                    cost += 32000;
                }

                cost *= Integer.parseInt(t1.getText());
                l5.setText("Rs " + cost);

            }
        });
        b1.setBounds(50, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = c1.getSelectedItem();
                    int totalPrice = Integer.parseInt(t1.getText()) * getPrice(s1);
                    // Update the column name in the SQL query
                    String query = "INSERT INTO bookPackage (username, package, total_persons, id, phone, total_price) "
                            + "VALUES ('" + t5.getText() + "', '" + s1 + "', " + t1.getText() + ", '" + t2.getText()
                            + "',  '" + t4.getText() + "', " + totalPrice + ")";

                    connInstance.establishConnection().createStatement().executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(200, 350, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }

    private int getPrice(String packageType) {
        switch (packageType) {
            case "Gold Package":
                return 12000;
            case "Silver Package":
                return 25000;
            case "Bronze Package":
                return 32000;
            default:
                return 0;
        }
    }
}

class Conn {
    public Connection establishConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@10.90.3.11:1521:xe";
        String uname = "system";
        String upass = "mysql";
        conn = DriverManager.getConnection(url, uname, upass);
        return conn;
    }
}
