package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame {

    private JButton exitButton;
    private JLabel titleLabel;
    private JTextArea descriptionArea;
    private String projectDescription;
    private String username;

    public About(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        setTitle("About Travel Management System");
        setLayout(null);

        // Button setup
        exitButton = new JButton("Close");
        exitButton.setBounds(200, 450, 100, 30);
        exitButton.addActionListener(e -> dispose()); // Lambda expression for closing the window
        add(exitButton);

        // Text area setup
        projectDescription = "About Project\n\n"
                + "The Travel and Tourism Management System is designed to automate the processes and activities related to travel. "
                + "Its primary objective is to provide a comprehensive system for users to handle all aspects of traveling.\n\n"
                + "Key Features:\n"
                + "- Provides accurate information regarding travel.\n"
                + "- Streamlines manual work processes.\n"
                + "- Reduces paperwork by digitizing documentation.\n"
                + "- Ensures up-to-date information is readily available.\n"
                + "- Offers a user-friendly environment with warning messages.\n"
                + "- Enables easy access to traveler details.\n"
                + "- Sends booking confirmation notifications.";

        descriptionArea = new JTextArea(projectDescription);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setBounds(50, 100, 400, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Add vertical scrollbar always
        add(scrollPane);

        // Label setup
        titleLabel = new JLabel("About Travel Management System");
        titleLabel.setBounds(50, 20, 400, 30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel);

        // Frame setup
        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]) {
        new About("username");
    }
}
