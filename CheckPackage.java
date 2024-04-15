package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPackage extends JFrame {
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CheckPackage frame = new CheckPackage("username");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

      public  CheckPackage(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Check Packages");
        setSize(1000, 700); // Set initial size
        setLocationRelativeTo(null); // Open frame in center of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] packages = {
                {"package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights", "Airport Assistance at Airport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"},
                {"package2.jpg", "SILVER PACKAGE", "4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"},
                {"package3.jpg", "BRONZE PACKAGE", "6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"}
        };

        JTabbedPane tabbedPane = new JTabbedPane();

        for (int i = 0; i < packages.length; i++) {
            JPanel packagePanel = createPackagePanel(packages[i]);
            tabbedPane.addTab("Package " + (i + 1), null, packagePanel);
        }

        add(tabbedPane, BorderLayout.CENTER);

        // Adding back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size for button text
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle back button click, for example, closing the current frame
                dispose();
            }
        });
        backButton.setPreferredSize(new Dimension(150, 50)); // Set preferred size for button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel for center alignment
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createPackagePanel(String[] pack) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Adding border

        ImageIcon packageImage = new ImageIcon(getClass().getResource("/icons/" + pack[0]));
        Image scaledImage = packageImage.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT); // Increased image size
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel packageImageLabel = new JLabel(scaledIcon);
        packageImageLabel.setBounds(50, 50, 400, 300);
        panel.add(packageImageLabel);

        int yPosition = 50;
        for (int i = 1; i < pack.length; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font size and style
            label.setForeground(Color.DARK_GRAY); // Changed text color
            label.setBounds(500, yPosition, 450, 30); // Increased width and added some vertical spacing
            panel.add(label);
            yPosition += 40; // Increased vertical spacing
        }

        return panel;
    }
}