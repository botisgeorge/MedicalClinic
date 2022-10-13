package Clinica.MedicalResources;

import javax.swing.*;

public class MedicalResourcesMVC {

    public MedicalResourcesMVC(JFrame previousView) {
        MedicalResourcesModel model = new MedicalResourcesModel();
        MedicalResourcesView view = new MedicalResourcesView();
        MedicalResourcesController controller = new MedicalResourcesController(model, view, previousView);

        view.setVisible(true);
    }

}
