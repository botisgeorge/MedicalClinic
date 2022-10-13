package Clinica.ChooseSpecialityPacient;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChooseSpecialityView extends JFrame {
    private final JTextField tfSpecialitate = new JTextField(20);
    private final JButton btnOk = new StyledJButton("Continua").getButton();
    private final String[] specialityOptions = {"Cardiologie","Dermatologie si venerologie","Chirurgie","Chirurgie plastica","Radiologie si imagistica","Pneumoftiziologie","Radiologie","Stomatologie","ORL","Ortopedie","Pediatrie","Diabet si boli de nutritie","Oftalmologie","Neurologie","Endocrinologie","Psihologie","Psihiatrie","Urologie"};
    private final JComboBox<String> specialityComboBox = new JComboBox<>(specialityOptions);

    public ChooseSpecialityView()
    {
        JPanel panelSpecialitate = new JPanel(new FlowLayout());
        panelSpecialitate.add(new JLabel("Alege specialitatea"));
        specialityComboBox.setBounds(80, 50, 140, 20);
        panelSpecialitate.add(specialityComboBox);

        btnOk.addActionListener(
                event -> {
                    String selectedSpeciality = specialityComboBox.getItemAt(specialityComboBox.getSelectedIndex());
                    tfSpecialitate.setText(selectedSpeciality);
                }
        );

        JPanel content = new JPanel(new BorderLayout());
        content.add(panelSpecialitate,BorderLayout.CENTER);
        content.add(btnOk, BorderLayout.SOUTH);
        btnOk.setBackground(Colors.MAIN_COLOR.getColor());
        content.setBorder(new EmptyBorder(5,5,5,5));

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void clear() {
        tfSpecialitate.setText("");
    }
    public void sendError(String message) {JOptionPane.showMessageDialog(this,message,"Eroare",0);}
    public void addBtnOkListener(ActionListener actionListener) {btnOk.addActionListener(actionListener);}
    public JComboBox<String> getSpecialityComboBox() {
        return specialityComboBox;
    }
}
