package Clinica.MedicalResourcesMenu;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MedicalResourcesMenuView extends JFrame{
    private final JButton btnBon = new StyledJButton("Genereaza bon").getButton();
    private final JButton btnAnaliza = new StyledJButton("Trimite analiza").getButton();
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();

    public MedicalResourcesMenuView()
    {
        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel PanelBon = new JPanel(new FlowLayout());
        btnBon.setBackground(Colors.MAIN_COLOR.getColor());
        PanelBon.setBorder(new EmptyBorder(0, 0, 0, 50));
        PanelBon.add(btnBon);

        JPanel PanelAnaliza = new JPanel(new FlowLayout());
        btnAnaliza.setBackground(Colors.MAIN_COLOR.getColor());
        PanelAnaliza.setBorder(new EmptyBorder(0, 0, 0, 0));
        PanelAnaliza.add(btnAnaliza);


        JPanel content = new JPanel(new BorderLayout());
        //content.add(loadLogo(), BorderLayout.NORTH);
        content.add(PanelBon, BorderLayout.WEST);
        content.add(PanelAnaliza, BorderLayout.EAST);
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

    public void addBtnBonListener(ActionListener actionListener) {
        btnBon.addActionListener(actionListener);
    }

    public void addBtnAnalizaListener(ActionListener actionListener) {
        btnAnaliza.addActionListener(actionListener);
    }

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}