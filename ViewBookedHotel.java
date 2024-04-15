package travel.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewBookedHotel extends JFrame {
    private JPanel contentPane;
    private String username;
    private Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBookedHotel frame = new ViewBookedHotel("name");
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewBookedHotel(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        setBounds(580, 220, 850, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ViewBookedHotel.class.getResource("/icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 350, 350);
        add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

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
        c1.setBounds(271, 70, 150, 20);
        contentPane.add(c1);

        JLabel lb3 = new JLabel("Select Hotel :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);
        
       

        JLabel lblId = new JLabel("Name :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Number of Days :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("AC / Non-AC :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Food Included (Yes/No) :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("ID :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Number :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        contentPane.add(l8);

        JLabel lblDeposite = new JLabel("Phone :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        contentPane.add(l9);

        JLabel la2 = new JLabel("Cost :");
        la2.setBounds(35, 430, 200, 14);
        contentPane.add(la2);

        JLabel l10 = new JLabel();
        l10.setBounds(271, 430, 200, 14);
        contentPane.add(l10);

        Conn c = new Conn();
        try {
            Connection conn = c.establishConnection();
            if (conn != null) {
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bookhotel");
                  
                  
                while (rs.next()) {
                  

                    c1.add(rs.getString("name"));
                }
                rs.close();
            } else {
                System.out.println("Connection object is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
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
