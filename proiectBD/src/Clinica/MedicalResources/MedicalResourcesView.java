package Clinica.MedicalResources;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MedicalResourcesView extends JFrame {
    private final JTextField tfNume = new JTextField(20);
    private final JTextField tfPrenume = new JTextField(20);
    private final JTextField tfCNP = new JTextField(13);
    private final JButton btnOk = new StyledJButton("Continua").getButton();
    private final JButton btnBack = new StyledJButton("Inapoi").getButton();

    public MedicalResourcesView()
    {
        JPanel formular = new JPanel(new GridLayout(3,2));
        formular.add(new JLabel("Nume"));
        formular.add(tfNume);
        formular.add(new JLabel("Prenume"));
        formular.add(tfPrenume);
        formular.add(new JLabel("CNP"));
        formular.add(tfCNP);
        formular.setBorder(new EmptyBorder(5,5,5,5));

        JPanel butoane = new JPanel(new BorderLayout());
        butoane.add(btnOk, BorderLayout.WEST);
        btnOk.setBackground(Colors.MAIN_COLOR.getColor());
        butoane.add(btnBack, BorderLayout.EAST);
        btnBack.setBackground(Colors.BTN_DISCONNECT_COLOR.getColor());

        JPanel content = new JPanel(new BorderLayout());
        content.add(formular,BorderLayout.CENTER);
        content.setBorder(new EmptyBorder(5,5,5,5));
        content.add(butoane,BorderLayout.SOUTH);

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void clear() {
        tfCNP.setText("");
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
    public JTextField getTfCNP() {return tfCNP;}

}
