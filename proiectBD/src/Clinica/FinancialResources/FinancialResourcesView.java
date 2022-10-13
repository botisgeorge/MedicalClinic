package Clinica.FinancialResources;

import Clinica.PacientMenu.ShowPrices.ShowPricesModel;
import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinancialResourcesView extends JFrame {
    private final FinancialResourcesModel model;
    private final JButton btnSalarii = new StyledJButton("Salarii Angajati").getButton();
    private final JButton btnIstoric = new StyledJButton("Istoric Tranzactii").getButton();
    private final JButton btnBack = new StyledJButton("Inapoi").getButton();
    JLabel salariiText = new JLabel("test");

    public FinancialResourcesView( FinancialResourcesModel model)
    {
        this.model=model;

        JPanel backPanel = new JPanel(new FlowLayout());
        btnBack.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        backPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
        backPanel.add(btnBack);

        JPanel panelSalarii = new JPanel(new FlowLayout());
        btnSalarii.setBackground(Colors.MAIN_COLOR.getColor());
        panelSalarii.setBorder(new EmptyBorder(0, 30, 0, 30));
        panelSalarii.add(btnSalarii);

        JPanel panelIstoric = new JPanel(new FlowLayout());
        btnIstoric.setBackground(Colors.MAIN_COLOR.getColor());
        panelIstoric.setBorder(new EmptyBorder(0, 30, 0, 30));
        panelIstoric.add(btnIstoric);

        JPanel content = new JPanel(new BorderLayout());
        content.add(panelSalarii, BorderLayout.WEST);
        content.add(panelIstoric, BorderLayout.EAST);
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

    public void addBtnSalariiListener(ActionListener actionListener) {btnSalarii.addActionListener(actionListener);}

    public void addBtnIstoricListener(ActionListener actionListener) {btnIstoric.addActionListener(actionListener);}

    public void addBtnBackListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
}
