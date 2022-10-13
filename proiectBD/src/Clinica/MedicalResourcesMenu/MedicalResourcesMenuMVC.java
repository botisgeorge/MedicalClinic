package Clinica.MedicalResourcesMenu;


import javax.swing.*;

public class MedicalResourcesMenuMVC {
    public MedicalResourcesMenuMVC(JFrame previousView)
    {
        MedicalResourcesMenuModel model = new MedicalResourcesMenuModel();
        MedicalResourcesMenuView view = new MedicalResourcesMenuView();
        MedicalResourcesMenuController controller = new MedicalResourcesMenuController(model, view, previousView);

        view.setVisible(true);
    }
}