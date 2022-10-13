package Clinica.HomePageAngajat;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomePageAngajatView extends JFrame {
    private final JButton btnHR = new StyledJButton("Resurse Umane").getButton(); // human resources
    private final JButton btnFR = new StyledJButton("Resurse Financiare").getButton(); // financial resources
    private final JButton btnMR = new StyledJButton("Resurse Medicale").getButton(); // medical resources
    private final JButton btnDisconnect = new StyledJButton("Log out").getButton(); // log out

    public HomePageAngajatView()
    {
        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel PanelHR = new JPanel(new FlowLayout());
        btnHR.setBackground(Colors.MAIN_COLOR.getColor());
        PanelHR.setBorder(new EmptyBorder(0, 0, 0, 50));
        PanelHR.add(btnHR);
        btnHR.setPreferredSize(new Dimension(160,30));

        JPanel PanelFR = new JPanel(new FlowLayout());
        btnFR.setBackground(Colors.MAIN_COLOR.getColor());
        PanelFR.setBorder(new EmptyBorder(0, 0, 0, 0));
        PanelFR.add(btnFR);
        btnFR.setPreferredSize(new Dimension(160,30));

        JPanel PanelMR = new JPanel(new FlowLayout());
        btnMR.setBackground(Colors.MAIN_COLOR.getColor());
        PanelMR.setBorder(new EmptyBorder(0, 50, 0, 0));
        PanelMR.add(btnMR);
        btnMR.setPreferredSize(new Dimension(160,30));

        JPanel logos = new JPanel(new GridLayout(1,3));
        logos.add(load1());
        logos.add(load2());
        logos.add(load3());
        logos.setBorder(new EmptyBorder(20,10,20,10));

        JPanel content = new JPanel(new BorderLayout());
        content.add(logos, BorderLayout.NORTH);
        content.add(PanelHR, BorderLayout.WEST);
        content.add(PanelFR, BorderLayout.CENTER);
        content.add(PanelMR, BorderLayout.EAST);
        content.add(disconnectPanel, BorderLayout.SOUTH);
        content.setBorder(new EmptyBorder(100,20,10,20));

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel load1() {
        try {
            JLabel jLabel = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("hr.png")).getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
            jLabel.setBorder(new EmptyBorder(0, 0, 10, 20));
            return jLabel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private JLabel load2() {
        try {
            JLabel jLabel = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("fr.png")).getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
            jLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
            return jLabel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private JLabel load3() {
        try {
            JLabel jLabel = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("mr.png")).getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
            jLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
            return jLabel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendError(String message) {
        JOptionPane.showMessageDialog(this, message, "Eroare!", JOptionPane.ERROR_MESSAGE);
    }

    public void addBtnHRListener(ActionListener actionListener) {
        btnHR.addActionListener(actionListener);
    }

    public void addBtnFRListener(ActionListener actionListener) {
        btnFR.addActionListener(actionListener);
    }

    public void addBtnMRListener(ActionListener actionListener) {
        btnMR.addActionListener(actionListener);
    }

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}
