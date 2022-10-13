package Clinica.ScheduleMenu;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScheduleMenuView extends JFrame {
    private final JButton btnMED = new StyledJButton("Alege un medic").getButton();
    private final JButton btnData = new StyledJButton("Alege data").getButton();
    private final JButton btnOra = new StyledJButton("Alege ora").getButton();
    private final JButton btnOK = new StyledJButton("OK").getButton();
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();

    public ScheduleMenuView()
    {
        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel PanelOK = new JPanel(new FlowLayout());
        btnOK.setBackground(Colors.MAIN_COLOR.getColor());
        PanelOK.setBorder(new EmptyBorder(50, 0, 0, 0));
        PanelOK.add(btnOK);

        JPanel butoane = new JPanel(new FlowLayout());
        butoane.add(btnMED);
        btnMED.setBackground(Colors.MAIN_COLOR.getColor());
        btnMED.setPreferredSize(new Dimension(160,30));
        butoane.add(btnData);
        btnData.setBackground(Colors.MAIN_COLOR.getColor());
        btnData.setPreferredSize(new Dimension(160,30));
        butoane.add(btnOra);
        btnOra.setBackground(Colors.MAIN_COLOR.getColor());
        btnOra.setPreferredSize(new Dimension(160,30));

        JPanel content = new JPanel(new BorderLayout());
        content.add(butoane, BorderLayout.NORTH);
        content.add(PanelOK, BorderLayout.CENTER);
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

    public void sendError(String message) {
        JOptionPane.showMessageDialog(this, message, "Eroare!", JOptionPane.ERROR_MESSAGE);
    }

    public void addBtnMEDListener(ActionListener actionListener) {
        btnMED.addActionListener(actionListener);
    }

    public void addBtnDataListener(ActionListener actionListener) {
        btnData.addActionListener(actionListener);
    }

    public void addBtnOraListener(ActionListener actionListener) {
        btnOra.addActionListener(actionListener);
    }

    public void addBtnOKListener(ActionListener actionListener) {
        btnOK.addActionListener(actionListener);
    }

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}