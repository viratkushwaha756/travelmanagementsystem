package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Destination extends JFrame implements Runnable {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Thread th;
        private String username;
    

    public void run() {
        try {
            l2.setVisible(true);
            Thread.sleep(2800);
            l2.setVisible(false);
            l3.setVisible(true);
            Thread.sleep(2800);
            l3.setVisible(false);
            l4.setVisible(true);
            Thread.sleep(2800);
            l4.setVisible(false);
            l5.setVisible(true);
            Thread.sleep(2800);
            l5.setVisible(false);
            l6.setVisible(true);
            Thread.sleep(2800);
            l6.setVisible(false);
            l7.setVisible(true);
            Thread.sleep(2800);
            l7.setVisible(false);
            l8.setVisible(true);
            Thread.sleep(2800);
            l8.setVisible(false);
            l9.setVisible(true);
            Thread.sleep(2800);
            l9.setVisible(false);
            l10.setVisible(true);
            Thread.sleep(2800);
            l10.setVisible(false);
            l11.setVisible(true);
            Thread.sleep(2800);
            l11.setVisible(false);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Destination(String username) {
        this.username = username; // Assigning the provided username
        System.out.println(username);

       setBounds(0, 0, 900, 700);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(220, 250, 250));

        th = new Thread(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dest1.jpeg"));
        Image img1 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        l2 = new JLabel(i2);
        l2.setBounds(0, 0, 900, 700);
        add(l2);

        // Rest of your code for adding JLabels l3 to l11
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/dest2.png"));
Image img3 = i3.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i4 = new ImageIcon(img3);
l3 = new JLabel(i4);
l3.setBounds(0, 0, 900, 700);
add(l3);
l3.setVisible(false);

ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/dest3.jpg"));
Image img5 = i5.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i6 = new ImageIcon(img5);
l4 = new JLabel(i6);
l4.setBounds(0, 0, 900, 700);
add(l4);
l4.setVisible(false);

ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/dest4.jpg"));
Image img7 = i7.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i8 = new ImageIcon(img7);
l5 = new JLabel(i8);
l5.setBounds(0, 0, 900, 700);
add(l5);
l5.setVisible(false);

ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icons/dest5.jpg"));
Image img9 = i9.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i10 = new ImageIcon(img9);
l6 = new JLabel(i10);
l6.setBounds(0, 0, 900, 700);
add(l6);
l6.setVisible(false);

ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/dest6.jpg"));
Image img11 = i11.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i12 = new ImageIcon(img11);
l7 = new JLabel(i12);
l7.setBounds(0, 0, 900, 700);
add(l7);
l7.setVisible(false);

ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/dest7.jpeg"));
Image img13 = i13.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i14 = new ImageIcon(img13);
l8 = new JLabel(i14);
l8.setBounds(0, 0, 900, 700);
add(l8);
l8.setVisible(false);

ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("icons/dest8.jpg"));
Image img15 = i15.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i16 = new ImageIcon(img15);
l9 = new JLabel(i16);
l9.setBounds(0, 0, 900, 700);
add(l9);
l9.setVisible(false);

ImageIcon i17 = new ImageIcon(ClassLoader.getSystemResource("icons/dest9.jpg"));
Image img17 = i17.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i18 = new ImageIcon(img17);
l10 = new JLabel(i18);
l10.setBounds(0, 0, 900, 700);
add(l10);
l10.setVisible(false);

ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/dest10.jpg"));
Image img19 = i19.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
ImageIcon i20 = new ImageIcon(img19);
l11 = new JLabel(i20);
l11.setBounds(0, 0, 900, 700);
add(l11);
l11.setVisible(false);


        th.start();
    }

    public static void main(String args[]) {
        new Destination("username").setVisible(true);
    }
}

