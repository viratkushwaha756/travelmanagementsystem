package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Splash {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashFrame f1 = new SplashFrame();
            f1.setVisible(true);
           
        });
    }
}

class SplashFrame extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    private Thread t1;

    SplashFrame() {
        setLayout(null); // Using null layout for precise positioning
        ImageIcon c1 = createImageIcon("/icons/splash.jpg");
        if (c1 != null) {
            setSize(1200, 650);
            setLocationRelativeTo(null); // Center the splash frame on the screen
            Image i1 = c1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
            JLabel l1 = new JLabel(i2);
            l1.setBounds(0, 0, 1200, 650); // Set bounds for the JLabel
            add(l1);
        } else {
            System.err.println("Could not load splash image.");
        }
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void run() {
        try {
            Thread.sleep(2800); // Wait for 3 seconds
            dispose(); // Close the splash frame after animation
            SwingUtilities.invokeLater(() -> new Login().setVisible(true)); // Open the login frame
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
