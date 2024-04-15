package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class CheckHotels extends JFrame implements Runnable {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JLabel caption;
    JLabel details1, details2, details3, details4, details5, details6, details7, details8, details9, details10;
    JButton backButton;
    Thread th;
    private String username;
    


    public void run() {
        try {
            l2.setVisible(true);
            caption.setText("JW Marriott Hotel");
            details1.setVisible(true); // Show details for JW Marriott
            Thread.sleep(2800);
            l2.setVisible(false);
            details1.setVisible(false);
            l3.setVisible(true);
            caption.setText("Mandarin Oriental Hotel");
            details2.setVisible(true); // Show details for Mandarin Oriental
            l3.setVisible(true);
            Thread.sleep(2800);
            l3.setVisible(false);
            details2.setVisible(false);
            l4.setVisible(true);
            caption.setText("Four Seasons Hotel");
            details3.setVisible(true); // Show details for Four Seasons
            l4.setVisible(true);
            Thread.sleep(2800);
            l4.setVisible(false);
            details3.setVisible(false);
            l5.setVisible(true);
            caption.setText("Radisson Hotel");
            details4.setVisible(true); // Show details for Radisson
            l5.setVisible(true);
            Thread.sleep(2800);
            l5.setVisible(false);
            details4.setVisible(false);
            l6.setVisible(true);
            caption.setText("Classio Hotel");
            details5.setVisible(true); // Show details for Classio
            l6.setVisible(true);
            Thread.sleep(2800);
            l6.setVisible(false);
            details5.setVisible(false);
            l7.setVisible(true);
            caption.setText("The Bay Club Hotel");
            details6.setVisible(true); // Show details for The Bay Club
            l7.setVisible(true);
            Thread.sleep(2800);
            l7.setVisible(false);
            details6.setVisible(false);
            l8.setVisible(true);
            caption.setText("Breeze Blows Hotel");
            details7.setVisible(true); // Show details for Breeze Blows
            l8.setVisible(true);
            Thread.sleep(2800);
            l8.setVisible(false);
            details7.setVisible(false);
            l9.setVisible(true);
            caption.setText("Quick Stop Hotel");
            details8.setVisible(true); // Show details for Quick Stop
            l9.setVisible(true);
            Thread.sleep(2800);
            l9.setVisible(false);
            details8.setVisible(false);
            l10.setVisible(true);
            caption.setText("Happy Mornings Motel");
            details9.setVisible(true); // Show details for Happy Mornings
            l10.setVisible(true);
            Thread.sleep(2800);
            l10.setVisible(false);
            details9.setVisible(false);
            l11.setVisible(true);
            caption.setText("Moss View Hotel");
            details10.setVisible(true); // Show details for Moss View
            l11.setVisible(true);
            Thread.sleep(2800);
            l11.setVisible(false);
            details10.setVisible(false);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CheckHotels(String username) {
         this.username = username; // Assigning the provided username
        System.out.println(username);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(220, 250, 250));

        th = new Thread(this);

        caption = new JLabel();
        caption.setBounds(50, 500, 700, 50);
        caption.setForeground(Color.red);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(caption);

        backButton = new JButton("Back");
        backButton.setBounds(50, 600, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Home("username").setVisible(true);
            }
        });
        add(backButton);

        setLayout(null);

        try {
           // Load hotel images and create JLabels for details for each hotel
ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/hotel1.jpg"));
Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l2 = new JLabel(new ImageIcon(i2));
l2.setBounds(200, 50, 400, 300);
add(l2);
l2.setVisible(false);

details1 = new JLabel("<html><b>JW Marriott Hotel</b><br/>Facilities: <font color='blue'>Swimming pool</font>, <font color='green'>Spa</font>, <font color='red'>Fitness center</font>, <font color='orange'>Restaurants</font><br/>Location: Downtown area</html>");
details1.setBounds(650, 50, 300, 150);
details1.setForeground(Color.BLACK);
details1.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details1);
details1.setVisible(false); // Initially hide details


// Repeat the process for the remaining hotels

// Load hotel 2 image
ImageIcon i3 = new ImageIcon(getClass().getResource("/icons/hotel2.jpg"));
Image i4 = i3.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l3 = new JLabel(new ImageIcon(i4));
l3.setBounds(200, 50, 400, 300);
add(l3);
l3.setVisible(false);

// JLabels for hotel 2 details and facilities
details2 = new JLabel("<html><b>Mandarin Oriental Hotel</b><br/>Facilities: <font color='blue'>Spa</font>, <font color='green'>Rooftop Bar</font>, <font color='red'>Conference Rooms</font><br/>Location: City Center</html>");
details2.setBounds(650, 50, 300, 150);
details2.setForeground(Color.BLACK);
details2.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details2);
details2.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 3 image
ImageIcon i5 = new ImageIcon(getClass().getResource("/icons/hotel3.jpg"));
Image i6 = i5.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l4 = new JLabel(new ImageIcon(i6));
l4.setBounds(200, 50, 400, 300);
add(l4);
l4.setVisible(false);

// JLabels for hotel 3 details and facilities
details3 = new JLabel("<html><b>Four Seasons Hotel</b><br/>Facilities: <font color='blue'>Luxury Suites</font>, <font color='green'>Fine Dining</font>, <font color='red'>Spa</font>, <font color='orange'>Event Spaces</font><br/>Location: Waterfront</html>");
details3.setBounds(650, 50, 300, 150);
details3.setForeground(Color.BLACK);
details3.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details3);
details3.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 4 image
ImageIcon i7 = new ImageIcon(getClass().getResource("/icons/hotel4.jpg"));
Image i8 = i7.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l5 = new JLabel(new ImageIcon(i8));
l5.setBounds(200, 50, 400, 300);
add(l5);
l5.setVisible(false);

// JLabels for hotel 4 details and facilities
details4 = new JLabel("<html><b>Radisson Hotel</b><br/>Facilities: <font color='blue'>Business Center</font>, <font color='green'>Swimming Pool</font>, <font color='red'>Fitness Center</font><br/>Location: Business District</html>");
details4.setBounds(650, 50, 300, 150);
details4.setForeground(Color.BLACK);
details4.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details4);
details4.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 5 image
ImageIcon i9 = new ImageIcon(getClass().getResource("/icons/hotel5.jpg"));
Image i10 = i9.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l6 = new JLabel(new ImageIcon(i10));
l6.setBounds(200, 50, 400, 300);
add(l6);
l6.setVisible(false);

// JLabels for hotel 5 details and facilities
details5 = new JLabel("<html><b>Classio Hotel</b><br/>Facilities: <font color='blue'>Rooftop Pool</font>, <font color='green'>Spa</font>, <font color='red'>Restaurants</font>, <font color='orange'>Event Spaces</font><br/>Location: Suburban Area</html>");
details5.setBounds(650, 50, 300, 150);
details5.setForeground(Color.BLACK);
details5.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details5);
details5.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 6 image
ImageIcon i11 = new ImageIcon(getClass().getResource("/icons/hotel6.jpg"));
Image i12 = i11.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l7 = new JLabel(new ImageIcon(i12));
l7.setBounds(200, 50, 400, 300);
add(l7);
l7.setVisible(false);

// JLabels for hotel 6 details and facilities
details6 = new JLabel("<html><b>The Bay Club Hotel</b><br/>Facilities: <font color='blue'>Private Beach</font>, <font color='green'>Restaurants</font>, <font color='red'>Water Sports</font><br/>Location: Coastal Area</html>");
details6.setBounds(650, 50, 300, 150);
details6.setForeground(Color.BLACK);
details6.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details6);
details6.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 7 image
ImageIcon i13 = new ImageIcon(getClass().getResource("/icons/hotel7.jpg"));
Image i14 = i13.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l8 = new JLabel(new ImageIcon(i14));
l8.setBounds(200, 50, 400, 300);
add(l8);
l8.setVisible(false);

// JLabels for hotel 7 details and facilities
details7 = new JLabel("<html><b>Breeze Blows Hotel</b><br/>Facilities: <font color='blue'>Oceanfront Suites</font>, <font color='green'>Spa</font>, <font color='red'>Bars</font>, <font color='orange'>Fitness Center</font><br/>Location: Coastal Area</html>");
details7.setBounds(650, 50, 300, 150);
details7.setForeground(Color.BLACK);
details7.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details7);
details7.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 8 image
ImageIcon i15 = new ImageIcon(getClass().getResource("/icons/hotel8.jpg"));
Image i16 = i15.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l9 = new JLabel(new ImageIcon(i16));
l9.setBounds(200, 50, 400, 300);
add(l9);
l9.setVisible(false);

// JLabels for hotel 8 details and facilities
details8 = new JLabel("<html><b>Quick Stop Hotel</b><br/>Facilities: <font color='blue'>Budget Accommodation</font>, <font color='green'>Restaurant</font>, <font color='red'>Parking</font><br/>Location: City Outskirts</html>");
details8.setBounds(650, 50, 300, 150);
details8.setForeground(Color.BLACK);
details8.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details8);
details8.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 9 image
ImageIcon i17 = new ImageIcon(getClass().getResource("/icons/hotel9.jpg"));
Image i18 = i17.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l10 = new JLabel(new ImageIcon(i18));
l10.setBounds(200, 50, 400, 300);
add(l10);
l10.setVisible(false);

// JLabels for hotel 9 details and facilities
details9 = new JLabel("<html><b>Happy Mornings Motel</b><br/>Facilities: <font color='blue'>Affordable Rooms</font>, <font color='green'>Breakfast</font>, <font color='red'>Wi-Fi</font><br/>Location: Suburban Area</html>");
details9.setBounds(650, 50, 300, 150);
details9.setForeground(Color.BLACK);
details9.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details9);
details9.setVisible(false); // Initially hide details

// Repeat the process for the remaining hotels similarly

// Load hotel 10 image
ImageIcon i19 = new ImageIcon(getClass().getResource("/icons/hotel10.jpg"));
Image i20 = i19.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
l11 = new JLabel(new ImageIcon(i20));
l11.setBounds(200, 50, 400, 300);
add(l11);
l11.setVisible(false);

// JLabels for hotel 10 details and facilities
details10 = new JLabel("<html><b>Moss View Hotel</b><br/>Facilities: <font color='blue'>Garden View Rooms</font>, <font color='green'>Conference Rooms</font>, <font color='red'>Spa</font><br/>Location: Rural Area</html>");
details10.setBounds(650, 50, 300, 150);
details10.setForeground(Color.BLACK);
details10.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size
add(details10);
details10.setVisible(false); // Initially hide details

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        th.start();
    }

    public static void main(String args[]) {
        new CheckHotels("username").setVisible(true);
    }
}
