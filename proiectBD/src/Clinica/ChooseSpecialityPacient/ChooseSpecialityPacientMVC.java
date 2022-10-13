package Clinica.ChooseSpecialityPacient;

import javax.swing.*;

public class ChooseSpecialityPacientMVC {

    public ChooseSpecialityPacientMVC(JFrame previousView) {
        ChooseSpecialityModel model = new ChooseSpecialityModel();
        ChooseSpecialityView view = new ChooseSpecialityView();
        ChooseSpecialityController controller = new ChooseSpecialityController(model, view, previousView);

        view.setVisible(true);
    }
}
