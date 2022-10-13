package Clinica.ChooseCityPacient;

import javax.swing.*;

public class ChooseCityPacientMVC {

    public ChooseCityPacientMVC(JFrame previousView) {
        ChooseCityPacientModel model = new ChooseCityPacientModel();
        ChooseCityPacientView view = new ChooseCityPacientView();
        ChooseCityPacientController controller = new ChooseCityPacientController(model, view, previousView);

        view.setVisible(true);
    }

}
