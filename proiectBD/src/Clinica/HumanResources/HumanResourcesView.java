package Clinica.HumanResources;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class HumanResourcesView extends JFrame {
    private final JButton btnProgramari = new StyledJButton("Programari").getButton();
    private final JButton btnConcedii = new StyledJButton("Concedii").getButton();
    private final JButton btnBack = new StyledJButton("Inapoi").getButton();

    public HumanResourcesView()
    {
        JPanel backPanel = new JPanel(new FlowLayout());
        btnBack.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        backPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
        backPanel.add(btnBack);

        JPanel panelProgramari = new JPanel(new FlowLayout());
        btnProgramari.setBackground(Colors.MAIN_COLOR.getColor());
        panelProgramari.setBorder(new EmptyBorder(0, 30, 0, 30));
        panelProgramari.add(btnProgramari);

        JPanel panelConcedii = new JPanel(new FlowLayout());
        btnConcedii.setBackground(Colors.MAIN_COLOR.getColor());
        panelConcedii.setBorder(new EmptyBorder(0, 30, 0, 30));
        panelConcedii.add(btnConcedii);

        JPanel content = new JPanel(new BorderLayout());
        //content.add(loadLogo(), BorderLayout.NORTH);
        content.add(panelProgramari, BorderLayout.WEST);
        content.add(panelConcedii, BorderLayout.EAST);
        content.add(backPanel, BorderLayout.SOUTH);
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

    public void addBtnProgramareListener(ActionListener actionListener) {btnProgramari.addActionListener(actionListener);}

    public void addBtnConcediiListener(ActionListener actionListener) {btnConcedii.addActionListener(actionListener);}

    public void addBtnBackListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
}
