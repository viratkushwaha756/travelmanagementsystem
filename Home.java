package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, deletePersonalDetails,
            checkPackage, bookPackage, bookedPackageDetails, viewDestinations, viewHotels, bookHotels,
            viewbookHotels, about, calculators, notepad, payment;

    Connection connection;

   
    public Home(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        // Initialize other buttons...

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 50, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 100, 300, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 300, 50);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 200, 300, 50);
        checkPackage.setBackground(new Color(0, 0, 102));
        checkPackage.setForeground(Color.white);
        checkPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 300, 50);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        bookedPackageDetails = new JButton("View Booked Package Details");
        bookedPackageDetails.setBounds(0, 300, 300, 50);
        bookedPackageDetails.setBackground(new Color(0, 0, 102));
        bookedPackageDetails.setForeground(Color.white);
        bookedPackageDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookedPackageDetails.addActionListener(this);
        p2.add(bookedPackageDetails);

        viewDestinations = new JButton("View Destinations");
        viewDestinations.setBounds(0, 350, 300, 50);
        viewDestinations.setBackground(new Color(0, 0, 102));
        viewDestinations.setForeground(Color.white);
        viewDestinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewDestinations.addActionListener(this);
        p2.add(viewDestinations);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 400, 300, 50);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(0, 450, 300, 50);
        bookHotels.setBackground(new Color(0, 0, 102));
        bookHotels.setForeground(Color.white);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewbookHotels = new JButton("View Booked Hotels");
        viewbookHotels.setBounds(0, 500, 300, 50);
        viewbookHotels.setBackground(new Color(0, 0, 102));
        viewbookHotels.setForeground(Color.white);
        viewbookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookHotels.addActionListener(this);
        p2.add(viewbookHotels);

        payment = new JButton("Payment");
        payment.setBounds(0, 550, 300, 50);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payment.addActionListener(this);
        p2.add(payment);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 600, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.addActionListener(this);
        p2.add(notepad);

        calculators = new JButton("Calculator");
        calculators.setBounds(0, 650, 300, 50);
        calculators.setBackground(new Color(0, 0, 102));
        calculators.setForeground(Color.white);
        calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculators.addActionListener(this);
        p2.add(calculators);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/icons/home.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 1950, 1000);
        add(backgroundLabel);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        backgroundLabel.add(text);

        // Establish connection
        Conn conn = new Conn();
        connection = conn.establishConnection();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username).setVisible(true);
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomers(username).setVisible(true);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username).setVisible(true);
        } else if (ae.getSource() == deletePersonalDetails) {
            new DeleteDetails(username).setVisible(true);
        } else if (ae.getSource() == checkPackage) {
            new CheckPackage(username).setVisible(true);
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username).setVisible(true);
        } else if (ae.getSource() == bookedPackageDetails) {
            new ViewPackage(username).setVisible(true);
        } else if (ae.getSource() == viewDestinations) {
            new Destination(username).setVisible(true);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotels(username).setVisible(true);
        } else if (ae.getSource() == bookHotels) {
            new BookHotel(username).setVisible(true);
        } else if (ae.getSource() == viewbookHotels) {
            new ViewBookedHotel(username).setVisible(true);
        } else if (ae.getSource() == about) {
            new About(username).setVisible(true);
        } else if (ae.getSource() == payment) {
            new Payment(username).setVisible(true);
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
          
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String username = "username";
        SwingUtilities.invokeLater(() -> new Home(username));
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database driver not found!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return c;
    }

    public void closeConnection() {
        try {
            if (c != null)
                c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
