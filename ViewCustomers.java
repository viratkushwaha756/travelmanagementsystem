package travel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.*;

public class ViewCustomers extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JLabel lblUsername, lblId, lblName, lblGender, lblCountry, lblAddress, lblPhone, lblEmail;

    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            String username = "username"; // Assuming you have the username
           ViewCustomers frame = new ViewCustomers(username);
//            frame.updateTable(); 
            
      //      ViewCustomers frame = new ViewCustomers("username");
//                viewCustomers viewCustomers = new ViewCustomers(username);
//             /  viewCustomers.updateTable();
                frame.setLocationRelativeTo(null); // Open the frame at the center
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomers(String username) {
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Add images
        addLabelWithIcon("/icons/viewall.jpg", 450, 0);
        addLabelWithIcon("/icons/viewall.jpg", 450, 615);

        // Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 866, 350);
        contentPane.add(scrollPane);
        table = new JTable();
        scrollPane.setViewportView(table);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> setVisible(false));
        btnBack.setBounds(390, 400, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        // Column labels
        lblUsername = new JLabel("Username");
        lblUsername.setBounds(10, 15, 90, 14);
        contentPane.add(lblUsername);

        lblId = new JLabel("ID ");
        lblId.setBounds(110, 15, 90, 14);
        contentPane.add(lblId);

        lblName = new JLabel("Name");
        lblName.setBounds(220, 15, 90, 14);
        contentPane.add(lblName);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(320, 15, 90, 14);
        contentPane.add(lblGender);

        lblCountry = new JLabel("Country");
        lblCountry.setBounds(420, 15, 90, 14);
        contentPane.add(lblCountry);

        lblAddress = new JLabel("Address");
        lblAddress.setBounds(520, 15, 90, 14);
        contentPane.add(lblAddress);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(620, 15, 90, 14);
        contentPane.add(lblPhone);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(720, 15, 90, 14);
        contentPane.add(lblEmail);

        getContentPane().setBackground(Color.WHITE);

        // Fetch data from database and populate table
        updateTable();
    }

    private void addLabelWithIcon(String path, int yPos, int xPos) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        JLabel label = new JLabel(icon);
        label.setBounds(xPos, yPos, icon.getIconWidth(), icon.getIconHeight());
        contentPane.add(label);
    }

    public void updateTable() {
        try {
            Conn c = new Conn();
            Connection conn = c.establishConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
            table.setModel(new ResultSetTableModel(rs));
//           viewCustomers viewCustomers = new ViewCustomers(username);
//                viewCustomers.updateTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in fetching data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    public ResultSetTableModel(ResultSet rs) throws SQLException {
        this.rs = rs;
        this.rsmd = rs.getMetaData();
    }

    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in database connection: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
