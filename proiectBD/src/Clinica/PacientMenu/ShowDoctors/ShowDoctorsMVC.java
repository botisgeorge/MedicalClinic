package Clinica.PacientMenu.ShowDoctors;

import javax.swing.*;

public class ShowDoctorsMVC {
    public ShowDoctorsMVC(JFrame previousView)
    {
        ShowDoctorsModel model = new ShowDoctorsModel();
        ShowDoctorsView view = new ShowDoctorsView(model);
        ShowDoctorsController controller = new ShowDoctorsController(model, view, previousView);

        view.setVisible(true);
    }
}