package Clinica.GenerareBon;


import javax.swing.*;

public class GenerareBonMVC {
    public GenerareBonMVC(JFrame previousView)
    {
        GenerareBonModel model = new GenerareBonModel();
        GenerareBonView view = new GenerareBonView();
        GenerareBonController controller = new GenerareBonController(model, view, previousView);

        view.setVisible(true);
    }
}