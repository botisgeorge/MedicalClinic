package Clinica.ChooseCityPacient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCityPacientController {
    private final ChooseCityPacientView view;
    private final ChooseCityPacientModel model;
    String selectedCity;
    public ChooseCityPacientController(ChooseCityPacientModel model, ChooseCityPacientView view, JFrame previousView)
    {
        this.model=model;
        this.view=view;
        view.addBtnOkListener(new ButtonListener());
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            JComboBox<String> cityComboBox = view.getCityComboBox();
            selectedCity = cityComboBox.getItemAt(cityComboBox.getSelectedIndex());
            view.setVisible(false);
            System.out.println(getMedicalUnitId());
            model.openContPacient(view);
        }
    }
    public int getMedicalUnitId() {
        if(selectedCity.equals("Baia Mare")) return 1;
        if(selectedCity.equals("Baia Sprie")) return 2;
        if(selectedCity.equals("Bucuresti")) return 3;
        if(selectedCity.equals("Cluj-Napoca")) return 4;
        if(selectedCity.equals("Hateg")) return 5;
        return -1;
    }
}
