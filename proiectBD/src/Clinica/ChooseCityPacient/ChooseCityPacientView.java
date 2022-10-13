package Clinica.ChooseCityPacient;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChooseCityPacientView extends JFrame {
    private final JTextField tfOras = new JTextField(20);
    private final JButton btnOk = new StyledJButton("Continua").getButton();
    private final String[] cityOptions = {"Baia Mare", "Baia Sprie", "Bucuresti", "Cluj-Napoca",
            "Hateg"};
    private final JComboBox<String> cityComboBox = new JComboBox<>(cityOptions);

    public ChooseCityPacientView() {
        JPanel panelOras = new JPanel(new FlowLayout());
        panelOras.add(new JLabel("Alege orasul"));
        cityComboBox.setBounds(80, 50, 140, 20);
        panelOras.add(cityComboBox);

        btnOk.addActionListener(
                event -> {
                    String selectedCity = cityComboBox.getItemAt(cityComboBox.getSelectedIndex());
                    tfOras.setText(selectedCity);
                }
        );

        JPanel content = new JPanel(new BorderLayout());
        content.add(panelOras, BorderLayout.CENTER);
        content.add(btnOk, BorderLayout.SOUTH);
        btnOk.setBackground(Colors.MAIN_COLOR.getColor());
        content.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void clear() {
        tfOras.setText("");
    }

    public void sendError(String message) {
        JOptionPane.showMessageDialog(this, message, "Eroare", 0);
    }

    public void addBtnOkListener(ActionListener actionListener) {
        btnOk.addActionListener(actionListener);
    }

    public JComboBox<String> getCityComboBox() {
        return cityComboBox;
    }
}
