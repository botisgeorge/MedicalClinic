package Clinica.PacientMenu;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PacientMenuView extends JFrame {
    private final JButton btnRAP = new StyledJButton("Rapoarte medicale").getButton();
    private final JButton btnMED = new StyledJButton("Medici").getButton();
    private final JButton btnCAB = new StyledJButton("Cabinete medicale").getButton();
    private final JButton btnPret = new StyledJButton("Preturi").getButton();
    private final JButton btnProg = new StyledJButton("Programare").getButton();
    private final JButton btnCont = new StyledJButton("Cont").getButton();
    private final JButton btnFacturi = new StyledJButton("Facturi").getButton();
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();

    public PacientMenuView()
    {
        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(100, 80, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel PanelRAP = new JPanel(new FlowLayout());
        btnRAP.setBackground(Colors.MAIN_COLOR.getColor());
        PanelRAP.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnRAP.setPreferredSize(new Dimension(160,30));
        PanelRAP.add(btnRAP);

        JPanel PanelMED = new JPanel(new FlowLayout());
        btnMED.setBackground(Colors.MAIN_COLOR.getColor());
        PanelMED.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnMED.setPreferredSize(new Dimension(160,30));
        PanelMED.add(btnMED);

        JPanel PanelCAB = new JPanel(new FlowLayout());
        btnCAB.setBackground(Colors.MAIN_COLOR.getColor());
        PanelCAB.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCAB.setPreferredSize(new Dimension(160,30));
        PanelCAB.add(btnCAB);

        JPanel PanelPret = new JPanel(new FlowLayout());
        btnPret.setBackground(Colors.MAIN_COLOR.getColor());
        PanelPret.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnPret.setPreferredSize(new Dimension(160,30));
        PanelPret.add(btnPret);

        JPanel PanelProg = new JPanel(new FlowLayout());
        btnProg.setBackground(Colors.MAIN_COLOR.getColor());
        PanelProg.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnProg.setPreferredSize(new Dimension(160,30));
        PanelProg.add(btnProg);

        JPanel PanelCont = new JPanel(new FlowLayout());
        btnCont.setBackground(Colors.MAIN_COLOR.getColor());
        PanelCont.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCont.setPreferredSize(new Dimension(160,30));
        PanelCont.add(btnCont);

        JPanel PanelFacturi = new JPanel(new FlowLayout());
        btnFacturi.setBackground(Colors.MAIN_COLOR.getColor());
        PanelFacturi.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnFacturi.setPreferredSize(new Dimension(160,30));
        PanelFacturi.add(btnFacturi);

        JPanel panelSUS = new JPanel(new GridLayout(1,4));
        panelSUS.add(PanelRAP);
        panelSUS.add(PanelMED);
        panelSUS.add(PanelCAB);
        panelSUS.add(PanelPret);
        panelSUS.setBorder(new EmptyBorder(0, 0, 2, 0));

        JPanel panelJOS = new JPanel(new GridLayout(1,4));
        panelJOS.add(PanelProg);
        panelJOS.add(PanelCont);
        panelJOS.add(PanelFacturi);
        panelJOS.add(disconnectPanel);
        panelJOS.setBorder(new EmptyBorder(2, 0, 0, 0));

        JPanel content = new JPanel(new BorderLayout());
        content.add(panelSUS,BorderLayout.NORTH);
        content.add(panelJOS,BorderLayout.SOUTH);


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

    public void addBtnRAPListener(ActionListener actionListener) {
        btnRAP.addActionListener(actionListener);
    }

    public void addBtnMEDListener(ActionListener actionListener) {
        btnMED.addActionListener(actionListener);
    }

    public void addBtnCABListener(ActionListener actionListener) {
        btnCAB.addActionListener(actionListener);
    }

    public void addBtnPretListener(ActionListener actionListener) {
        btnPret.addActionListener(actionListener);
    }

    public void addBtnProgListener(ActionListener actionListener) {
        btnProg.addActionListener(actionListener);
    }

    public void addBtnContListener(ActionListener actionListener) {
        btnCont.addActionListener(actionListener);
    }

    public void addBtnFacturiListener(ActionListener actionListener) {
        btnFacturi.addActionListener(actionListener);
    }

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}