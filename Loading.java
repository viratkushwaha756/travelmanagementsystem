package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable, ActionListener {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s = 0; // Initialize s to 0
    Thread th;
    JButton b2; // Declare b2 as a JButton

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public void setUploading() {
        th = new Thread(this); // Initialize the thread
        th.start(); // Start the thread after setting up loading frame
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home(username).setVisible(true); // Display the Home window
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        System.out.println(username);

        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("Travel and Toursim Application");
        lbllibraryManagement.setForeground(new Color(72, 209, 204));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(50, 46, 700, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JLabel lblusername = new JLabel("Welcome " + username); // Corrected label text
        lblusername.setForeground(Color.RED); // Corrected color instantiation
        lblusername.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblusername.setBounds(20, 310, 400, 40);
        contentPane.add(lblusername);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();

//        b2 = new JButton("Back");
//        b2.addActionListener(this); // Register the button with the action listener
//        panel.add(b2); // Add the button to the panel
    }

    // Implement actionPerformed method to handle button click event
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            this.setVisible(false);
            new Home(username).setVisible(true);
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