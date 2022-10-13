package Clinica.TrimiteAnaliza;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TrimiteAnalizaView extends JFrame{
    private final JButton btnAnaliza = new StyledJButton("Trimite analiza").getButton();
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();

    public TrimiteAnalizaView()
    {
        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel PanelAnaliza = new JPanel(new FlowLayout());
        btnAnaliza.setBackground(Colors.MAIN_COLOR.getColor());
        PanelAnaliza.setBorder(new EmptyBorder(0, 0, 50, 0));
        PanelAnaliza.add(btnAnaliza);


        JPanel content = new JPanel(new BorderLayout());
        //content.add(loadLogo(), BorderLayout.NORTH);
        content.add(PanelAnaliza, BorderLayout.CENTER);
        content.add(disconnectPanel, BorderLayout.SOUTH);
        content.setBorder(new EmptyBorder(50,20,10,20));

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

    public void addBtnAnalizaListener(ActionListener actionListener) {
        btnAnaliza.addActionListener(actionListener);
    }

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}