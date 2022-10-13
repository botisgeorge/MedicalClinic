package Clinica.ContPacient;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContPacientView extends JFrame {
    private final JTextField tfNume = new JTextField(20);
    private final JTextField tfPrenume = new JTextField(20);
    private final JTextField tfEmail = new JTextField(20);
    private final JTextField tfAdresa = new JTextField(20);
    private final JTextField tfNrTelefon = new JTextField(20);
    private final JButton btnOk = new StyledJButton("Continua").getButton();
    private final JButton btnBack = new StyledJButton("Inapoi").getButton();

    public ContPacientView()
    {
        JPanel panelFormular = new JPanel(new GridLayout(5,2));
        panelFormular.add(new JLabel("Nume"));
        panelFormular.add(tfNume);
        panelFormular.add(new JLabel("Prenume"));
        panelFormular.add(tfPrenume);
        panelFormular.add(new JLabel("Email"));
        panelFormular.add(tfEmail);
        panelFormular.add(new JLabel("Adresa"));
        panelFormular.add(tfAdresa);
        panelFormular.add(new JLabel("Numar Telefon"));
        panelFormular.add(tfNrTelefon);

        JPanel panelButoane = new JPanel(new FlowLayout());
        panelButoane.add(btnOk, BorderLayout.WEST);
        btnOk.setBackground(Colors.MAIN_COLOR.getColor());
        panelButoane.add(btnBack, BorderLayout.EAST);
        btnBack.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());

        JPanel content = new JPanel(new BorderLayout());
        content.add(panelFormular,BorderLayout.CENTER);
        content.setBorder(new EmptyBorder(5,5,5,5));
        content.add(panelButoane, BorderLayout.SOUTH);

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void clear() {
        tfAdresa.setText("");
        tfEmail.setText("");
        tfNrTelefon.setText("");
        tfNume.setText("");
        tfPrenume.setText("");
    }
    public void sendError(String message) {JOptionPane.showMessageDialog(this,message,"Eroare",0);}
    public void addBtnOkListener(ActionListener actionListener) {btnOk.addActionListener(actionListener);}
    public void addBtnBackListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
    public JTextField getTfNume() {return tfNume;}
    public JTextField getTfPrenume() {return tfPrenume;}
    public JTextField getTfAdresa() {return tfAdresa;}
    public JTextField getTfEmail() {return tfEmail;}
    public JTextField getTfNrTelefon() {return tfNrTelefon;}
}
