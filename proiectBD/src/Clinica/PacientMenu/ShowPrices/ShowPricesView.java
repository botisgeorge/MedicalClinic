package Clinica.PacientMenu.ShowPrices;

import Clinica.PacientMenu.ShowDoctors.ShowDoctorsModel;
import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowPricesView extends JFrame {
    private final ShowPricesModel model;
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();
    JLabel mediciText = new JLabel("test");
    public ShowPricesView(ShowPricesModel model)
    {
        this.model=model;
        JPanel preturi = new JPanel(new FlowLayout());
        mediciText.setText(model.AfiseazaPreturi());
        mediciText.setText("<html>" + model.AfiseazaPreturi().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        preturi.add(mediciText);
        preturi.setBorder(new EmptyBorder(0,50,0,50));

        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel content = new JPanel(new BorderLayout());
        content.add(preturi, BorderLayout.NORTH);
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

    public void addBtnDisconnectListener(ActionListener actionListener) {
        btnDisconnect.addActionListener(actionListener);
    }
}

