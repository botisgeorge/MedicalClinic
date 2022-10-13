package Clinica.FinancialResources;

import javax.swing.*;

public class FinancialResourcesMVC {

    public FinancialResourcesMVC(JFrame previousView)
    {
        FinancialResourcesModel model = new FinancialResourcesModel();
        FinancialResourcesView view = new FinancialResourcesView(model);
        FinancialResourcesController controller = new FinancialResourcesController(model, view, previousView);

        view.setVisible(true);
    }
}
