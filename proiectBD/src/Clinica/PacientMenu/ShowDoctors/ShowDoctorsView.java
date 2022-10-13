package Clinica.PacientMenu.ShowDoctors;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowDoctorsView extends JFrame {
    private final ShowDoctorsModel model;
    private final JButton btnDisconnect = new StyledJButton("Inapoi").getButton();
    JLabel mediciText = new JLabel("test");
    public ShowDoctorsView(ShowDoctorsModel model)
    {
        this.model=model;
        JPanel medici = new JPanel(new FlowLayout());
        mediciText.setText(model.AfiseazaDoctori());
        mediciText.setText("<html>" + model.AfiseazaDoctori().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        medici.add(mediciText);
        medici.setBorder(new EmptyBorder(20,50,0,50));

        JPanel disconnectPanel = new JPanel(new FlowLayout());
        btnDisconnect.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());
        disconnectPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
        disconnectPanel.add(btnDisconnect);

        JPanel content = new JPanel(new BorderLayout());
        content.add(medici, BorderLayout.NORTH);
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
