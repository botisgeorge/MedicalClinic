package Clinica.PacientMenu.ShowPrices;

import javax.swing.*;

public class ShowPricesMVC {
    public ShowPricesMVC(JFrame previousView)
    {
        ShowPricesModel model = new ShowPricesModel();
        ShowPricesView view = new ShowPricesView(model);
        ShowPricesController controller = new ShowPricesController(model, view, previousView);

        view.setVisible(true);
    }
}