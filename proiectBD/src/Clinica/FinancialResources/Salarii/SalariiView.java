package Clinica.FinancialResources.Salarii;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SalariiView extends JFrame {
    private final SalariiModel model;
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();
    JLabel salariiText = new JLabel("test");
    public SalariiView(SalariiModel model)
    {
        this.model=model;

        JPanel salarii = new JPanel(new FlowLayout());
        salariiText.setText(model.afiseazaSalarii());
        salariiText.setText("<html>" + model.afiseazaSalarii().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        salarii.add(salariiText);
        salarii.setBorder(new EmptyBorder(10,50,0,50));

        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel content = new JPanel(new BorderLayout());
        content.add(salarii, BorderLayout.NORTH);
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
