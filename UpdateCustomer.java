package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class UpdateCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField[] textFields;
    private Connection conn;
    private String username;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateCustomer frame = new UpdateCustomer(""); // Example username
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateCustomer(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        initialize();
        conn = new Conn().establishConnection(); // Establish database connection
        fillForm(username);
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("UPDATE CUSTOMER DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(118, 11, 300, 53);
        contentPane.add(lblTitle);

        loadImage();

        String[] labels = {"username:","ID:", "Number:", "Name:", "Gender:", "Country:", "Address:", "Phone:", "Email:"};
        textFields = new JTextField[labels.length];
        int posY = 70;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(35, posY, 200, 14);
            contentPane.add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(271, posY, 150, 20);
            contentPane.add(textFields[i]);
            posY += 40;
        }

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this::updateAction);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBounds(100, 430, 120, 30);
        contentPane.add(btnUpdate);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> dispose());
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(260, 430, 120, 30);
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
    }

    private void loadImage() {
        try {
            ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
            Image image = originalIcon.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setBounds(500, 40, 200, 400);
            contentPane.add(imageLabel);
        } catch (NullPointerException e) {
            System.err.println("Image not found, proceeding without it.");
        }
    }

    private void fillForm(String username) {
        try {
            String query = "select * from customer where username = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < textFields.length; i++) {
                    textFields[i].setText(rs.getString(i + 1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateAction(ActionEvent e) {
        try {
            String query = "update customer set id = ?,username=?, \"Number\" = ?, name = ?, gender = ?, country = ?, address = ?, phone = ?, email = ? "
                    + "where username = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            for (int i = 0; i < textFields.length; i++) {
                pst.setString(i + 1, textFields[i].getText());
            }
            pst.setString(textFields.length + 1, username);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
             setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
