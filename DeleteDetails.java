
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DeleteDetails extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private final String username;
    private Connection conn;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DeleteDetails frame = new DeleteDetails("username"); // Example username
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DeleteDetails(String username) {
        this.username = username;
        System.out.println(username);
        initialize();
        conn = new Conn().establishConnection(); // Establish database connection
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("DELETE CUSTOMER DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(118, 11, 300, 53);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(100, 100, 80, 20);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(190, 100, 150, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(this::searchAction);
        btnSearch.setBounds(360, 100, 80, 20);
        contentPane.add(btnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this::deleteAction);
        btnDelete.setBackground(Color.BLACK);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(100, 430, 120, 30);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> dispose());
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(260, 430, 120, 30);
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
    }

    private void searchAction(ActionEvent e) {
        String searchUsername = textField.getText().trim();
        if (!searchUsername.isEmpty()) {
            try {
                String query = "SELECT * FROM customer WHERE username = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, searchUsername);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Customer found with username: " + searchUsername);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer with username: " + searchUsername + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a username", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAction(ActionEvent e) {
        String deleteUsername = textField.getText().trim();
        if (!deleteUsername.isEmpty()) {
            try {
                String query = "DELETE FROM customer WHERE username = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, deleteUsername);
                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                     setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer Detail with username: " + deleteUsername + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a username", "Error", JOptionPane.ERROR_MESSAGE);
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
            String upass = "mysql";
            conn = DriverManager.getConnection(url, uname, upass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
