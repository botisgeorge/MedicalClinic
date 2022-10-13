package Clinica.HumanResources;

import javax.swing.*;

public class HumanResourcesMVC {

    public HumanResourcesMVC(JFrame previousView)
    {
        HumanResourcesModel model = new HumanResourcesModel();
        HumanResourcesView view = new HumanResourcesView();
        HumanResourcesController controller = new HumanResourcesController(model, view, previousView);

        view.setVisible(true);
    }
}
