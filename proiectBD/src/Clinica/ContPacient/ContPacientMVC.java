package Clinica.ContPacient;

import javax.swing.*;

public class ContPacientMVC {

    public ContPacientMVC(JFrame previousView) {
        ContPacientModel model = new ContPacientModel();
        ContPacientView view = new ContPacientView();
        ContPacientController controller = new ContPacientController(model, view, previousView);

        view.setVisible(true);
    }
}
