package Clinica.ChooseSpecialityPacient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseSpecialityController {
    private final ChooseSpecialityView view;
    private final ChooseSpecialityModel model;

    public ChooseSpecialityController(ChooseSpecialityModel model, ChooseSpecialityView view, JFrame previousView)
    {
        this.model=model;
        this.view=view;
        view.addBtnOkListener(new ButtonListener());
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            JComboBox<String> specialityComboBox = view.getSpecialityComboBox();;
            String selectedSpeciality = specialityComboBox.getItemAt(specialityComboBox.getSelectedIndex());


            view.setVisible(false);
            model.openProgramarePacient(view);

        }
    }
}
