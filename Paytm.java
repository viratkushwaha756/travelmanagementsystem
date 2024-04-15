package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.client.j2se.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Paytm extends JFrame {
    private String username;
    public Paytm(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);
        setTitle("Paytm Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        getContentPane().add(scrollPane);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(back, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        // Generate Paytm UPI QR code
        ImageIcon paytmQRCode = generatePaytmUPIQRCode("PAYTM_UPI_ID", "PAYTM_AMOUNT");

        JLabel qrCodeLabel = new JLabel(paytmQRCode);
        JPanel qrCodePanel = new JPanel(new BorderLayout());
        qrCodePanel.add(qrCodeLabel, BorderLayout.CENTER);
        getContentPane().add(qrCodePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ImageIcon generatePaytmUPIQRCode(String upiId, String amount) {
        String paytmQRData = "upi://pay?pa=" + upiId + "&am=" + amount;
        int size = 300;

        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.MARGIN, 0);

        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(paytmQRData, BarcodeFormat.QR_CODE, size, size, hints);
            return new ImageIcon(MatrixToImageWriter.toBufferedImage(bitMatrix));
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new Paytm());
    }
}
